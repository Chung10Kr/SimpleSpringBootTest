package com.api.product.mapper;

import com.api.product.dto.Product;

/**
 * fileName       : MockProductMapper
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
public class MockProductMapper implements ProductMapper{
    @Override
    public Product findByCode(String product_code) {
        if( product_code.equals("P00001") ){
            return Product.builder()
                    .shipping_product_id(1)
                    .product_code("P00001")
                    .build();
        };
        return null;
    }

    @Override
    public Product findById(int shipping_product_id) {
        if(shipping_product_id == 1){
            return Product.builder()
                    .shipping_product_id(1)
                    .product_code("P00001")
                    .build();
        }
        return null;
    }
}
