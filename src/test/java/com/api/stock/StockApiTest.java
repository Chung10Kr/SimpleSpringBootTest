package com.api.stock;

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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

/**
 * fileName       : StockApiTest
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
public class StockApiTest {
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
    @DisplayName("입고 Api")
    void getProductApi(){

        Map<String,Object> params = new HashMap<>();
        params.put("productId",1);
        params.put("location_name", null );
        params.put("quantity",13);

        HttpEntity request = new HttpEntity(params);
        TestRestTemplate rest = new TestRestTemplate();
        ResponseEntity<ResMsg> res = rest.postForEntity(this.SERVER_URL+"/inbound", request , ResMsg.class);

        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(res.getBody().getMessage()).isEqualTo(Message.DONE_INBOUND_PRODUCT.getMessage());

        HashMap<String,Object> data = (HashMap<String, Object>) res.getBody().getData();
        Assertions.assertThat( data ).extracting("stock");
        Assertions.assertThat( data ).extracting("product");
        Assertions.assertThat( data ).extracting("location");
    }
}
