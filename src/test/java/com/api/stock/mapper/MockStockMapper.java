package com.api.stock.mapper;

import com.api.stock.dto.Stock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * fileName       : MockStockMapper
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
public class MockStockMapper implements StockMapper{
    @Override
    public List<Stock> findByLocation(int location_id) {
        if(location_id == 1 ){
            Stock stock1 = Stock.builder()
                    .stock_id(1)
                    .shipping_product_id(1)
                    .location_id(1)
                    .quantity(1)
                    .build();
            Stock stock2 = Stock.builder()
                    .stock_id(2)
                    .shipping_product_id(2)
                    .location_id(1)
                    .quantity(1)
                    .build();
            Stock stock3 = Stock.builder()
                    .stock_id(3)
                    .shipping_product_id(2)
                    .location_id(1)
                    .quantity(1)
                    .build();
            return Arrays.asList(stock1,stock2,stock3);
        }
        return null;
    }

    @Override
    public Stock findByProduct(int shipping_product_id) {
        if( shipping_product_id == 1){
            return Stock.builder()
                    .stock_id(1)
                    .shipping_product_id(1)
                    .location_id(2)
                    .quantity(3)
                    .build();
        }
        return null;
    }
    @Override
    public int save(Stock stock){
        return 1;
    }

}
