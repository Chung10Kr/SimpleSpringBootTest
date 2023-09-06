package com.api.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * fileName       : Product
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
public class Product {
    private int shipping_product_id;
    private String product_code;
}
