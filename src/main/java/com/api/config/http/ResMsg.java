package com.api.config.http;

import lombok.*;

/**
 * fileName       : Message
 * author         : crlee
 * date           : 2023/08/21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/21        crlee       최초 생성
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ResMsg {
    private String message;
    private Object data;

    public ResMsg(String message){
        this.message = message;
    }
    public ResMsg(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
