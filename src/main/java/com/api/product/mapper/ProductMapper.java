package com.api.product.mapper;

import com.api.product.dto.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * fileName       : ProductMapper
 * author         : crlee
 * date           : 2023/08/21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/21        crlee       최초 생성
 */
@Mapper
public interface ProductMapper {

    public Product findByCode(String product_code);
    public Product findById(int shipping_product_id);
}
