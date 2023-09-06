package com.api.config;

import com.api.config.http.ResMsg;
import com.api.config.http.ResponseUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

/**
 * fileName       : ResponseUtilsTest
 * author         : crlee
 * date           : 2023/08/21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/21        crlee       최초 생성
 */
public class ResponseUtilsTest {

    @Test
    @DisplayName("ResEntity(String msg,Object data,HttpStatus httpStatus)")
    void ResponseUtilsTest1(){
        Map<String,Object> params = new HashMap<>();
        params.put("result","테스트입니다.");

        ResponseEntity<ResMsg> res = ResponseUtils.ResEntity("테스트 메세지",params, HttpStatus.OK);
        Assertions.assertThat( res.getStatusCode() ).isEqualTo(HttpStatus.OK);

        Map<String,Object> result = (HashMap) res.getBody().getData();

        Assertions.assertThat( res.getBody().getMessage() ).isEqualTo("테스트 메세지");
        Assertions.assertThat( res.getStatusCode() ).isEqualTo(HttpStatus.OK);
        Assertions.assertThat( result.get("result") ).isEqualTo("테스트입니다.");
    }
    @Test
    @DisplayName("ResEntity(String msg,Object data)")
    void ResponseUtilsTest2(){
        Map<String,Object> params = new HashMap<>();
        params.put("result","테스트입니다.");

        ResponseEntity<ResMsg> res = ResponseUtils.ResEntity("테스트 메세지",params);
        Assertions.assertThat( res.getStatusCode() ).isEqualTo(HttpStatus.OK);

        Map<String,Object> result = (HashMap) res.getBody().getData();

        Assertions.assertThat( res.getBody().getMessage() ).isEqualTo("테스트 메세지");
        Assertions.assertThat( res.getStatusCode() ).isEqualTo(HttpStatus.OK);
        Assertions.assertThat( result.get("result") ).isEqualTo("테스트입니다.");
    }
    @Test
    @DisplayName("ResEntity(String msg,HttpStatus httpStatus)")
    void ResponseUtilsTest3(){
        ResponseEntity<ResMsg> res = ResponseUtils.ResEntity("테스트 메세지",HttpStatus.BAD_REQUEST);
        Assertions.assertThat( res.getStatusCode() ).isEqualTo(HttpStatus.BAD_REQUEST);

        Map<String,Object> result = (HashMap) res.getBody().getData();

        Assertions.assertThat( res.getBody().getMessage() ).isEqualTo("테스트 메세지");
        Assertions.assertThat( res.getStatusCode() ).isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat( result ).isNull();
    }

}
