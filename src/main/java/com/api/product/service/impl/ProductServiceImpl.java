package com.api.product.service.impl;

import com.api.config.exception.NoSuchDataException;
import com.api.config.message.Message;
import com.api.product.dto.Product;
import com.api.product.mapper.ProductMapper;
import com.api.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * fileName       : ProductServiceImpl
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    public ProductServiceImpl(ProductMapper productMapper){
        this.productMapper = productMapper;
    }
    @Override
    public Product findByCode(String product_code)  throws NoSuchDataException{
        Product product = productMapper.findByCode(product_code);
        if( product == null ){
            throw new NoSuchDataException(Message.NO_SUCH_PRODUCT_CODE.getMessage());
        }
        return product;
    }

    @Override
    public Product findById(int shipping_product_id) throws NoSuchDataException {
        Product product = productMapper.findById(shipping_product_id);
        if( product == null ){
            throw new NoSuchDataException(Message.NO_SUCH_PRODUCT_ID.getMessage());
        }
        return product;
    }
}
