package com.api.config.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * fileName       : ResEntity
 * author         : crlee
 * date           : 2023/08/21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/21        crlee       최초 생성
 */

public class ResponseUtils {

    public static ResponseEntity<ResMsg> ResEntity(String msg, Object data, HttpStatus httpStatus){
        ResMsg res = new ResMsg(msg, data);
        return buildResponseEntity(res, httpStatus);
    }
    public static ResponseEntity<ResMsg> ResEntity(String msg, Object data){
        ResMsg res = new ResMsg(msg, data);
        return buildResponseEntity(res, HttpStatus.OK);
    }
    public static ResponseEntity<ResMsg> ResEntity(String msg){
        ResMsg res = new ResMsg(msg);
        return buildResponseEntity(res, HttpStatus.OK);
    }
    public static ResponseEntity<ResMsg> ResEntity(String msg, HttpStatus httpStatus){
        ResMsg res = new ResMsg(msg);
        return buildResponseEntity(res, httpStatus);
    }
    private static ResponseEntity<ResMsg> buildResponseEntity(ResMsg message, HttpStatus httpStatus) {
        return ResponseEntity
                .status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(message);
    }
}
