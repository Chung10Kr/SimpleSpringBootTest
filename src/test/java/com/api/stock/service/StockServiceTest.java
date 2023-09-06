package com.api.stock.service;

import com.api.config.exception.NoSuchDataException;
import com.api.config.message.Message;
import com.api.location.mapper.MockLocationMapper;
import com.api.product.mapper.MockProductMapper;
import com.api.product.service.impl.ProductServiceImpl;
import com.api.stock.dto.Stock;
import com.api.stock.mapper.MockStockMapper;
import com.api.stock.service.impl.StockServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * fileName       : StockServiceTest
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@TestInstance(TestInstance. Lifecycle.PER_CLASS)
public class StockServiceTest {

    StockService stockService;

    @BeforeAll
    void init(){
        stockService = new StockServiceImpl( new MockLocationMapper() , new MockStockMapper() );
    }


    @Test
    @DisplayName("입고 - 로케이션 직접 입력 (존재하지 않는 로케이션)")
    void inBount_LocationName(){
        String locationName = "LNOT1";
        try {
            stockService.inBound(1,locationName,3);
        }catch (NoSuchDataException e){
            Assertions.assertThat( e.getMessage() ).isEqualTo(Message.NO_SUCH_LOCATION.getMessage());
        };
    }
    @Test
    @DisplayName("입고 - 로케이션 직접 입력 (존재 하는 로케이션, 스큐제한 로케이션)")
    void inBount_LocationName2(){
        String locationName = "L0001";
        try {
            stockService.inBound(4,locationName,3);
        }catch (NoSuchDataException e){
            Assertions.assertThat( e.getMessage() ).isEqualTo(Message.SKU_LIMIT_LOCATION.getMessage());
        };
    }
    @Test
    @DisplayName("입고 - 추천 로케이션")
    void inBount_LocationName3(){

        try {
            Stock stock = stockService.inBound(1,null,3);
        }catch (NoSuchDataException e){
            Assertions.assertThat( true ).isFalse();
        };
    }
}
