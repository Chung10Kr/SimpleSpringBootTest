package com.api.config;

import com.api.config.http.ResMsg;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * fileName       : MessageTest
 * author         : crlee
 * date           : 2023/08/21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/21        crlee       최초 생성
 */
public class ResMsgTest {
    @Test
    void MessageTest(){
        ResMsg message = new ResMsg();
        Map<String,Object> result = new HashMap<>();
        result.put("name","JaeHa Lee");
        message.setData(result);
        message.setMessage("테스트 메세지");

        Assertions.assertThat( message.getMessage() ).isEqualTo("테스트 메세지");
        Assertions.assertThat( ((HashMap) message.getData()).get("name") ).isEqualTo("JaeHa Lee");
    }
    @Test
    void MessageTest2(){
        ResMsg message = new ResMsg("Hellow Java");
        Assertions.assertThat( message.getMessage() ).isEqualTo("Hellow Java");

        Map<String,Object> result = new HashMap<>();
        result.put("name","JaeHa Lee");
        ResMsg message2 = new ResMsg("Hellow Java",result);
        Assertions.assertThat( message2.getMessage() ).isEqualTo("Hellow Java");
        Assertions.assertThat( ((HashMap) message2.getData()).get("name") ).isEqualTo("JaeHa Lee");
    }
    @Test
    void buildTest(){
        Map<String,Object> result = new HashMap<>();
        result.put("name","JaeHa Lee");
        ResMsg message = ResMsg.builder().message("테스트 메세지").data(result).build();

        Assertions.assertThat( message.getMessage() ).isEqualTo("테스트 메세지");
        Assertions.assertThat( ((HashMap) message.getData()).get("name") ).isEqualTo("JaeHa Lee");
    }
}
