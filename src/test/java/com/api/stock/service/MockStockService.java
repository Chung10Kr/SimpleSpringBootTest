package com.api.stock.service;

import com.api.config.exception.NoSuchDataException;
import com.api.config.message.Message;
import com.api.stock.dto.Stock;

/**
 * fileName       : MockStockService
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
public class MockStockService implements StockService{
    @Override
    public Stock inBound(int productId, String location_name, int qty) throws NoSuchDataException {
        if( location_name == null ){
            return Stock.builder()
                    .shipping_product_id(1)
                    .location_id(1)
                    .stock_id(11)
                    .build();
        }
        if( location_name.equals("ABCABC") ){
            throw new NoSuchDataException(Message.NO_SUCH_LOCATION.getMessage());
        }
        return null;
    }
}
