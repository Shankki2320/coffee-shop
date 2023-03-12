package com.digital.coffeeshop.controller;

import com.digital.coffeeshop.exceptions.BadRequestException;
import com.digital.coffeeshop.model.BaseResponse;
import com.digital.coffeeshop.service.ShopService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/shop")
public class ShopController {

    private ShopService shopService;


    @GetMapping(value = "/v1/shops/{shopId}")
    public ResponseEntity<BaseResponse> fetchShopDetails(@PathVariable Long shopId) {
        log.info("Inside method: fetchShopDetails of class: ShopController with shopId : {} ", shopId);
        if (shopId == null) {
            throw new BadRequestException("shopId cannot be Null or Empty");
        }
        return shopService.fetchShopDetails(shopId);
    }


}
