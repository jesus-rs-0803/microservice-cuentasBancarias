package com.bootcam.cuentasBancarias.exception;

public class CustomerDoesNotExistException extends Exception {
    public CustomerDoesNotExistException(String msg) {
        super(msg);
    }
}
