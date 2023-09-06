package com.api.stock;

import com.api.config.exception.NoSuchDataException;
import com.api.config.http.ResMsg;
import com.api.config.http.ResponseUtils;
import com.api.config.message.Message;
import com.api.location.dto.Location;
import com.api.location.service.LocationService;
import com.api.product.dto.Product;
import com.api.product.service.ProductService;
import com.api.stock.dto.Stock;
import com.api.stock.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * fileName       : StockController
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
@RestController
public class StockController {
    private final StockService stockService;
    private final ProductService productService;
    private final LocationService locationService;

    public StockController(StockService stockService, ProductService productService, LocationService locationService){
        this.stockService = stockService;
        this.productService = productService;
        this.locationService = locationService;
    }
    @PostMapping("/inbound")
    public ResponseEntity<ResMsg> inbound(@RequestBody Map<String, Object> params){
        HashMap<String,Object> data = new HashMap<>();
        String msg;
        Stock stock;
        try{
            int productId = (int) params.get("productId");
            int quantity = (int) params.get("quantity");
            String location_name =  params.get("location_name") == null ? null : (String)  params.get("location_name");
            if (productId == 0 || quantity == 0) {
                throw new NoSuchDataException(Message.NO_PARAMETER_PRODUCT_QTY.getMessage());
            }

            stock = stockService.inBound(productId,location_name,quantity);
            Product product = productService.findById(stock.getShipping_product_id());
            Location location = locationService.findById(stock.getLocation_id());

            data.put("stock", stock );
            data.put("product", product );
            data.put("location",location);

            msg  = Message.DONE_INBOUND_PRODUCT.getMessage();
        }catch (NoSuchDataException e){
            msg  = e.getMessage();
        }

        return ResponseUtils.ResEntity(msg,data);
    }
}
