package com.api.product;

import com.api.config.exception.NoSuchDataException;
import com.api.config.http.ResMsg;
import com.api.config.http.ResponseUtils;
import com.api.config.message.Message;
import com.api.product.dto.Product;
import com.api.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * fileName       : ProductController
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@RestController
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product/{code}")
    public ResponseEntity<ResMsg> getProduct(@PathVariable String code){

        HashMap<String,Object> data = new HashMap<>();
        String msg = null;
        Product product = null;
        try{
            product = productService.findByCode(code);
            msg  = Message.DONE_SEARCH_PRODUCT.getMessage();
        }catch (NoSuchDataException e){
            msg  = e.getMessage();
        }
        data.put("product",product);

        return ResponseUtils.ResEntity(msg,data);
    }
}
