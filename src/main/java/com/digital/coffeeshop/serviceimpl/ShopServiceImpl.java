package com.digital.coffeeshop.serviceimpl;

import com.digital.coffeeshop.entity.Shop;
import com.digital.coffeeshop.exceptions.ResourceNotFoundException;
import com.digital.coffeeshop.model.BaseResponse;
import com.digital.coffeeshop.repository.ShopRepository;
import com.digital.coffeeshop.service.ShopService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ShopServiceImpl implements ShopService {

    private ShopRepository shopRepository;

    @Override
    public ResponseEntity<BaseResponse> fetchShopDetails(Long shopId) {
        log.info("Inside method: fetchShopDetails of class: ShopServiceImpl with shopId : {} ", shopId);
        BaseResponse baseResponse = new BaseResponse();
        Optional<Shop> shop = shopRepository.findById(shopId);
        if (!shop.isPresent()) {
            throw new ResourceNotFoundException("No shop found with id " + shopId);
        }
        baseResponse.setMessage("Shop details fetched successfully!");
        baseResponse.setData(shop.get());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }


}
