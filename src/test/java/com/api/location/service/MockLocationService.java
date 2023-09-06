package com.api.location.service;

import com.api.config.exception.NoSuchDataException;
import com.api.location.dto.Location;

/**
 * fileName       : MockLocationService
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
public class MockLocationService implements LocationService{

    @Override
    public Location findById(int location_id) throws NoSuchDataException {
        if( location_id == 1){
            return Location.builder()
                    .location_name("L00001")
                    .location_id(1)
                    .build();
        }
        return null;
    }
}
