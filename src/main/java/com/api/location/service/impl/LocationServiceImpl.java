package com.api.location.service.impl;

import com.api.config.exception.NoSuchDataException;
import com.api.config.message.Message;
import com.api.location.dto.Location;
import com.api.location.mapper.LocationMapper;
import com.api.location.service.LocationService;
import org.springframework.stereotype.Service;

/**
 * fileName       : LocationServiceImpl
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@Service
public class LocationServiceImpl implements LocationService {
    private final LocationMapper locationMapper;
    public LocationServiceImpl(LocationMapper locationMapper){
        this.locationMapper = locationMapper;
    }
    @Override
    public Location findById(int location_id) throws NoSuchDataException {
        Location location = locationMapper.findById(location_id);
        if(location == null){
            throw new NoSuchDataException(Message.NO_SUCH_LOCATION_ID.getMessage());
        }
        return location;
    }
}
