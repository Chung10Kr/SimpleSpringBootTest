package com.api.product.service;

import com.api.config.exception.NoSuchDataException;
import com.api.product.dto.Product;

/**
 * fileName       : ProductService
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
public interface ProductService {
    public Product findByCode(String product_code) throws NoSuchDataException;
    public Product findById(int shipping_product_id) throws NoSuchDataException;
}
