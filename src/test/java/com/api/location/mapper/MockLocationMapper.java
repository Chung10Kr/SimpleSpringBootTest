package com.api.location.mapper;

import com.api.location.dto.Location;

/**
 * fileName       : MockLocationMapper
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
public class MockLocationMapper implements LocationMapper{
    @Override
    public Location findById(int location_id) {
        if( location_id == 1){
            return Location.builder()
                    .location_id(1)
                    .location_name("L0001")
                    .sku_limit(2)
                    .build();
        };
        return null;
    }

    @Override
    public Location findByName(String location_name) {
        if( location_name.equals("L0001") ){
            return Location.builder()
                    .location_id(1)
                    .location_name("L0001")
                    .sku_limit(2)
                    .build();
        };
        return null;
    }

    @Override
    public Location findEmpty() {
        return Location.builder()
                .location_id(1)
                .location_name("L0001")
                .sku_limit(2)
                .build();
    }
    @Override
    public Location findUnLimit(){
        return Location.builder()
                .location_id(1)
                .location_name("L0001")
                .sku_limit(0)
                .build();
    }
}
