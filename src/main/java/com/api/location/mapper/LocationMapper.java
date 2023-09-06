package com.api.location.mapper;

import com.api.location.dto.Location;
import org.apache.ibatis.annotations.Mapper;

/**
 * fileName       : LocationMapper
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@Mapper
public interface LocationMapper {

    public Location findById(int location_id);
    public Location findByName(String location_name);
    public Location findEmpty();
    public Location findUnLimit();
}
