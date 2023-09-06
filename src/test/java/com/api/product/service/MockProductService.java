package com.api.product.service;

import com.api.config.exception.NoSuchDataException;
import com.api.config.message.Message;
import com.api.product.dto.Product;

/**
 * fileName       : MockProductService
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
public class MockProductService implements ProductService{
    @Override
    public Product findByCode(String product_code) throws NoSuchDataException {
        if( product_code.equals("P000001") ){
            return Product.builder()
                    .shipping_product_id(1)
                    .product_code("P000001")
                    .build();
        }
        throw new NoSuchDataException(Message.NO_SUCH_PRODUCT_CODE.getMessage());
    }

    @Override
    public Product findById(int shipping_product_id) throws NoSuchDataException {
        if( shipping_product_id== 1 ){
            return Product.builder()
                    .shipping_product_id(1)
                    .product_code("P000001")
                    .build();
        }
        throw new NoSuchDataException(Message.NO_SUCH_PRODUCT_CODE.getMessage());
    }
}
