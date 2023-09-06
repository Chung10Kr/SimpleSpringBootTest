package com.api.location.mapper;

import com.api.location.dto.Location;
import com.api.product.dto.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

/**
 * fileName       : LocationMapperTest
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LocationMapperTest {
    @Autowired
    LocationMapper locationMapper;

    @Test
    @DisplayName("findByName() - exist Location Name")
    void findByName(){
        String name = "L0001";
        Location location = locationMapper.findByName(name);
        Assertions.assertThat( location.getLocation_name() ).isEqualTo( "L0001" );
    }
    @Test
    @DisplayName("findByName() - not exist Location Name")
    void findByNameNot(){
        String name = "LNot1";
        Location location = locationMapper.findByName(name);
        Assertions.assertThat( location ).isNull();
    }
    @Test
    @DisplayName("findEmpty() - 비어있는 로케이션")
    void findEmpty(){
        try{
            locationMapper.findEmpty();
            Assertions.assertThat( true ).isTrue();
        }catch (Exception e){
            Assertions.assertThat( false ).isTrue();
        }
    }
    @Test
    @DisplayName("findUnlimit() - SKU Limit 0인 로케이션")
    void findUnlimit(){
        Location location = locationMapper.findUnLimit();
        Assertions.assertThat( location.getSku_limit() ).isEqualTo( 0 );
    }
    @Test
    @DisplayName("findById()")
    void findById(){
        Location location = locationMapper.findById(1);
        Assertions.assertThat( location.getLocation_id() ).isEqualTo( 1 );
    }
}
