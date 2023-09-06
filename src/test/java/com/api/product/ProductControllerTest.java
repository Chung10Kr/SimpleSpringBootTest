package com.api.product;

import com.api.config.http.ResMsg;
import com.api.config.message.Message;
import com.api.product.dto.Product;
import com.api.product.service.MockProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

/**
 * fileName       : ProductControllerTest
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@TestInstance(TestInstance. Lifecycle.PER_CLASS)
public class ProductControllerTest {

    ProductController productController;
    @BeforeAll
    void init(){
        productController = new ProductController(new MockProductService());
    }

    @Test
    @DisplayName("상품조회 테스트 - 존재하는 상품 코드")
    void getProduct(){
        ResponseEntity<ResMsg> response = productController.getProduct("P000001");
        Assertions.assertThat( response.getStatusCode() ).isEqualTo(HttpStatus.OK);
        Assertions.assertThat( response.getBody().getMessage() ).isEqualTo(Message.DONE_SEARCH_PRODUCT.getMessage());

        HashMap<String,Object> data = (HashMap) response.getBody().getData();
        Assertions.assertThat( data ).extracting("product");
        Assertions.assertThat( ( (Product) data.get("product") ).getProduct_code() ).isEqualTo( "P000001" );
    }
    @Test
    @DisplayName("상품조회 테스트 - 존재하는 않는 상품 코드")
    void getProductFail(){
        ResponseEntity<ResMsg> response = productController.getProduct("C00001");
        Assertions.assertThat( response.getStatusCode() ).isEqualTo(HttpStatus.OK);
        Assertions.assertThat( response.getBody().getMessage() ).isEqualTo(Message.NO_SUCH_PRODUCT_CODE.getMessage());
        HashMap<String,Object> data = (HashMap) response.getBody().getData();
        Assertions.assertThat( data ).extracting("product");
        Assertions.assertThat( data.get("product") ).isNull();

    }
}
