package com.api.stock.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * fileName       : Stock
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@Getter
@Setter
@Builder
public class Stock {
    private int stock_id;
    private int shipping_product_id;
    private int location_id;
    private int quantity;
}
