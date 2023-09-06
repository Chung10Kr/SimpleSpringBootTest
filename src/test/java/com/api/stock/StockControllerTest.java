package com.api.stock;

import com.api.config.http.ResMsg;
import com.api.config.message.Message;
import com.api.location.service.MockLocationService;
import com.api.product.service.MockProductService;
import com.api.stock.service.MockStockService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * fileName       : StockControllerTest
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@TestInstance(TestInstance. Lifecycle.PER_CLASS)
public class StockControllerTest {
    StockController stockController;
    @BeforeAll
    void init(){
        stockController = new StockController(new MockStockService(), new MockProductService(), new MockLocationService());
    }
    @Test
    @DisplayName("입고 테스트")
    void getProduct(){
        Map<String,Object> params = new HashMap<>();
        params.put("productId" , 1);
        params.put("location_name" , null);
        params.put("quantity" , 11);
        ResponseEntity<ResMsg> response = stockController.inbound(params);
        Assertions.assertThat( response.getStatusCode() ).isEqualTo(HttpStatus.OK);
        Assertions.assertThat( response.getBody().getMessage() ).isEqualTo(Message.DONE_INBOUND_PRODUCT.getMessage());
        HashMap<String,Object> data = (HashMap) response.getBody().getData();
        Assertions.assertThat( data ).extracting("stock");
        Assertions.assertThat( data ).extracting("location");
        Assertions.assertThat( data ).extracting("product");
    }
    @Test
    @DisplayName("입고 테스트 - 없는 로케이션")
    void getProduct_NoLoc(){
        Map<String,Object> params = new HashMap<>();
        params.put("productId" , 1);
        params.put("location_name" , "ABCABC");
        params.put("quantity" , 11);
        ResponseEntity<ResMsg> response = stockController.inbound(params);
        Assertions.assertThat( response.getStatusCode() ).isEqualTo(HttpStatus.OK);
        Assertions.assertThat( response.getBody().getMessage() ).isEqualTo(Message.NO_SUCH_LOCATION.getMessage());
    }
}
