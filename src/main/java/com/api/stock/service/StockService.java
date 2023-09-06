package com.api.stock.service;

import com.api.config.exception.NoSuchDataException;
import com.api.stock.dto.Stock;

/**
 * fileName       : StockService
 * author         : crlee
 * date           : 2023/08/22
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/08/22        crlee       최초 생성
 */
public interface StockService {
    public Stock inBound(int productId, String location_name, int qty) throws NoSuchDataException;
}
