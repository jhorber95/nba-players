
package com.soft.maceight.service.error;


public class BadRequestAlertException extends RuntimeException {

    public BadRequestAlertException(String mensaje) {
        super(mensaje);
    }
}

