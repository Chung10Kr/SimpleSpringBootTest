package com.api.config.message;

/**
 * fileName       : ErrorMessage
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
public enum Message {
    NO_PARAMETER_PRODUCT_QTY("상품 ID, 수량 누락"),
    DONE_INBOUND_PRODUCT("상품 입고 완료"),
    DONE_SEARCH_PRODUCT("상품 조회 완료"),
    SKU_LIMIT_LOCATION("SKU 제한 로케이션"),


    NO_RECOMMEND_LOCATION("추천 로케이션 없음"),
    NO_SUCH_LOCATION("존재하지 않는 로케이션"),
    NO_SUCH_LOCATION_ID("존재하지 않는 로케이션 ID"),
    NO_SUCH_PRODUCT_ID("존재하지 않는 상품 ID"),
    NO_SUCH_PRODUCT_CODE("존재하지 않는 상품 Code");

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
