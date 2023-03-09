package com.digital.coffeeshop.exceptions;

import lombok.Data;

/**
 * @author Shankar Katkade
 * @since 10/03/2023
 * @version 1.0
 *
 * This class contains common parameters for an Error/Exception scenario
 */

@Data
public class ExceptionResponse {

    private String errorMessage;
    private String requestedURI;

}
