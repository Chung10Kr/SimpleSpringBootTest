package com.api.stock.mapper;

import com.api.product.mapper.ProductMapper;
import com.api.stock.dto.Stock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import java.util.List;

/**
 * fileName       : StockMapperTest
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
@Rollback(value = true)
public class StockMapperTest {

    @Autowired
    private StockMapper stockMapper;

    @Test
    void findByLocation(){
        int location_id = 1;
        List<Stock> list = stockMapper.findByLocation(location_id);
        Assertions.assertThat( list.get(0).getLocation_id() ).isEqualTo( location_id );
    }
    @Test
    void findByProduct(){
        int product_id = 1;
        Stock stock = stockMapper.findByProduct(product_id);
        Assertions.assertThat( stock.getShipping_product_id() ).isEqualTo(product_id);
    }
    @Test
    void save(){
        Stock stock = Stock.builder()
                .quantity(3)
                .shipping_product_id(1)
                .location_id(1)
                .build();
        stockMapper.save( stock );
        Assertions.assertThat( stock.getStock_id() ).isNotEqualTo(0);
    }
}
