package com.api.location.service;

import com.api.config.exception.NoSuchDataException;
import com.api.location.dto.Location;

/**
 * fileName       : LocationService
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
public interface LocationService {
    public Location findById(int location_id) throws NoSuchDataException;
}
