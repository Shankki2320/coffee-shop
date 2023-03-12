package com.digital.coffeeshop.service;

import com.digital.coffeeshop.model.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface ShopService {


    ResponseEntity<BaseResponse> fetchShopDetails(Long shopId);

}
