package com.api.stock.service.impl;

import com.api.config.exception.NoSuchDataException;
import com.api.config.message.Message;
import com.api.location.dto.Location;
import com.api.location.mapper.LocationMapper;
import com.api.stock.dto.Stock;
import com.api.stock.mapper.StockMapper;
import com.api.stock.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * fileName       : StockServiceImpl
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@Service
public class StockServiceImpl implements StockService {

    LocationMapper locationMapper;
    StockMapper stockMapper;

    public StockServiceImpl(LocationMapper locationMapper,StockMapper stockMapper){
        this.locationMapper = locationMapper;
        this.stockMapper = stockMapper;
    }
    @Override
    @Transactional
    public Stock inBound(int productId, String location_name, int qty) throws NoSuchDataException{
        int locationId;

        if( !ObjectUtils.isEmpty( location_name ) ){
            locationId = validLoc(productId,location_name);
        }else{
            locationId = recommendLoc(productId);
        }
        Stock newStock = Stock.builder()
                .shipping_product_id(productId)
                .location_id(locationId)
                .quantity(qty)
                .build();
        stockMapper.save(newStock);
        return newStock;
    }
    /* 로케이션 추천
    * 1. 대상 상품의 재고가 이미 있는 로케이션
    * 2. 빈 로케이션
    * 3. SKU 제한이 없는 로케이션
    * */
    private int recommendLoc(int productId){
        // 1. 대상 상품의 재고가 이미 있는 로케이션
        Stock exist = stockMapper.findByProduct(productId);
        if(exist != null ){
            return exist.getLocation_id();
        }

        // 2. 빈 로케이션
        Location empty = locationMapper.findEmpty();
        if( empty != null ){
            return empty.getLocation_id();
        }

        // 3. SKU 제한이 없는 로케이션
        Location unLimit = locationMapper.findUnLimit();
        if( unLimit != null ){
            return unLimit.getLocation_id();
        }

        throw new NoSuchDataException(Message.NO_RECOMMEND_LOCATION.getMessage());
    }

    /* 로케이션 직접 입력 & validation */
    private int validLoc(int productId, String location_name){

        // 1. 로케이션 유효 체크
        Location location = locationMapper.findByName(location_name);
        if(location == null ){
            throw new NoSuchDataException(Message.NO_SUCH_LOCATION.getMessage());
        };

        // 2. SKU LIMIT 체크
        if( location.getSku_limit() != 0 ){
            List<Stock> stockList = stockMapper.findByLocation(location.getLocation_id());
            int nowSku = (int) stockList.stream().mapToInt(Stock::getShipping_product_id).distinct().count();
            if( location.getSku_limit() <= nowSku ){
                boolean contain = stockList.stream().mapToInt(Stock::getShipping_product_id).anyMatch( x -> x == productId );
                if( !contain ){
                    throw new NoSuchDataException(Message.SKU_LIMIT_LOCATION.getMessage());

                }
            }
        }
        return location.getLocation_id();
    }
}
