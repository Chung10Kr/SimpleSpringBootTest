package com.api.location.service;

import com.api.config.exception.NoSuchDataException;
import com.api.config.message.Message;
import com.api.location.dto.Location;
import com.api.location.mapper.MockLocationMapper;
import com.api.location.service.impl.LocationServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * fileName       : LocationServiceTest
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@TestInstance(TestInstance. Lifecycle.PER_CLASS)
public class LocationServiceTest {

    LocationService locationService;
    @BeforeAll
    void init(){
        locationService = new LocationServiceImpl( new MockLocationMapper() );
    }
    @Test
    void findById(){
        try {
            Location location =  locationService.findById(1);
            Assertions.assertThat( location.getLocation_id() ).isEqualTo( 1 );
        }catch (NoSuchDataException e ){
            Assertions.assertThat( true ).isFalse();
        }
    }
    @Test
    void findById_err(){
        try {
            locationService.findById(0);
        }catch (NoSuchDataException e ){
            Assertions.assertThat( e.getMessage() ).isEqualTo(Message.NO_SUCH_LOCATION_ID.getMessage());
        }
    }
}
