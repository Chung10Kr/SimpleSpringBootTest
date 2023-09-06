package com.api.product;

import com.api.config.http.ResMsg;
import com.api.config.message.Message;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

/**
 * fileName       : ProductApiTest
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@TestInstance(TestInstance. Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductApiTest {
    @LocalServerPort
    String PORT;

    @Value("${server.servlet.context-path}")
    String CONTEXT_PATH;
    String URL = "http://localhost";
    String SERVER_URL;
    @BeforeAll
    void init(){
        this.SERVER_URL = String.format("%s:%s%s", URL,PORT,CONTEXT_PATH);
    }
    @Test
    @DisplayName("상품 조회 Api - 존재하는 상품코드")
    void getProductApi(){
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<ResMsg> res = rest.exchange(this.SERVER_URL+"/product/P00001", HttpMethod.GET ,null , ResMsg.class);
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(res.getBody().getMessage()).isEqualTo(Message.DONE_SEARCH_PRODUCT.getMessage());
        HashMap<String,Object> data = (HashMap<String, Object>) res.getBody().getData();
        Assertions.assertThat( data ).extracting("product");
    }
    @Test
    @DisplayName("상품 조회 Api - 존재하는 않는 상품코드")
    void getProductNoApi(){
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<ResMsg> res = rest.exchange(this.SERVER_URL+"/product/C123401", HttpMethod.GET ,null , ResMsg.class);
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(res.getBody().getMessage()).isEqualTo(Message.NO_SUCH_PRODUCT_CODE.getMessage());
    }
}
