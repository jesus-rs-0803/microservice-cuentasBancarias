package com.bootcam.cuentasBancarias.exception;

public class NoAccountExistsException extends Exception {
    public NoAccountExistsException(String msg) {
        super(msg);
    }
}
