package com.api.product.service;

import com.api.config.exception.NoSuchDataException;
import com.api.config.message.Message;
import com.api.product.dto.Product;
import com.api.product.mapper.MockProductMapper;
import com.api.product.service.impl.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * fileName       : ProductServiceTest
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@TestInstance(TestInstance. Lifecycle.PER_CLASS)
public class ProductServiceTest {


    ProductService productService;
    @BeforeAll
    void init(){
        productService = new ProductServiceImpl( new MockProductMapper() );
    }

    @Test
    @DisplayName("findByCode() - exist Product Code")
    void findByCode(){
        try{
            Product product =  productService.findByCode("P00001");
            Assertions.assertThat( product.getProduct_code() ).isEqualTo( "P00001" );
        }catch (NoSuchDataException e){
            Assertions.assertThat(true).isFalse();
        }
    }
    @Test
    @DisplayName("findByCode() - not exist Product Code , throw new NoSuchDataException")
    void findByCodeNo(){
        try{
            Product product =  productService.findByCode("C00001");
        }catch (NoSuchDataException e){
            Assertions.assertThat( e.getMessage() ).isEqualTo(Message.NO_SUCH_PRODUCT_CODE.getMessage());
        }
    }
    @Test
    @DisplayName("findById  - exist Product Id ")
    void findById(){
        try{
            Product product =  productService.findById(1);
            Assertions.assertThat( product.getShipping_product_id() ).isEqualTo( 1);
        }catch (NoSuchDataException e){
            Assertions.assertThat(true).isFalse();
        }
    }
    @Test
    @DisplayName("findByCode() - not exist Product Id , throw new NoSuchDataException")
    void findByIdNo(){
        try{
            Product product =  productService.findById(1);
        }catch (NoSuchDataException e){
            Assertions.assertThat( e.getMessage() ).isEqualTo(Message.NO_SUCH_PRODUCT_ID.getMessage());
        }
    }
}
