package com.api.location.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * fileName       : Location
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
public class Location {
    private int location_id;
    private String location_name;
    private int sku_limit;
}
