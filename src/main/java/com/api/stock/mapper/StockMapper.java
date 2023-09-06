package com.api.stock.mapper;

import com.api.product.dto.Product;
import com.api.stock.dto.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * fileName       : StockMapper
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@Mapper
public interface StockMapper {
    public List<Stock> findByLocation(int location_id);
    public Stock findByProduct(int shipping_product_id);
    public int save(Stock stock);
}
