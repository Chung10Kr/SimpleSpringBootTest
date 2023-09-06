package com.api.product.mapper;

import com.api.product.dto.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

/**
 * fileName       : productMapper
 * author         : crlee
 * date           : 2023/08/21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/21        crlee       최초 생성
 */
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    @DisplayName("findByCode() - exist Product Code")
    void findByCode(){
        String product_code = "P00001";
        Product product = productMapper.findByCode(product_code);
        Assertions.assertThat( product.getProduct_code() ).isEqualTo( product_code );
    }
    @Test
    @DisplayName("findByCode() - not exist Product Code")
    void findByCodeNot(){
        String product_code = "PNot1";
        Product product = productMapper.findByCode(product_code);
        Assertions.assertThat( product ).isNull();
    }
    @Test
    @DisplayName("findById() - exist Product ID")
    void findById(){
        int shipping_product_id = 1;
        Product product = productMapper.findById(shipping_product_id);
        Assertions.assertThat( product.getShipping_product_id() ).isEqualTo(shipping_product_id);
    }
    @Test
    @DisplayName("findById() - Not exist Product ID")
    void findByIdNot(){
        int shipping_product_id = 0;
        Product product = productMapper.findById(shipping_product_id);
        Assertions.assertThat( product ).isNull();
    }
}
