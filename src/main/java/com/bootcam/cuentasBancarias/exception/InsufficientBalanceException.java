package com.bootcam.cuentasBancarias.exception;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
