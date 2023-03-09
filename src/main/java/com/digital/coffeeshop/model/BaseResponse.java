package com.digital.coffeeshop.model;

import lombok.Data;

/**
 * @author Shankar Katkade
 * @version 1.0
 * @since 10/03/2023
 *
 * This class has common response parameters
 */

@Data
public class BaseResponse {

    private String message;
    private Object data;

}
