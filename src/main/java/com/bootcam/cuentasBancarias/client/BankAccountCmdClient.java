package com.bootcam.cuentasBancarias.client;

import org.springframework.web.bind.annotation.PutMapping;

import com.bootcam.cuentasBancarias.dto.MessageDto;
import com.bootcam.cuentasBancarias.dto.Transaction;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client(value = "account-cmd", path = "/api/v1/accounts")
public interface BankAccountCmdClient {
	@Put("/credit")
    Flowable<MessageDto> credit(Transaction transaction);
    @Put("/debit")
    Flowable<MessageDto> debit(Transaction transaction);
    @Put("/transfer")
    Flowable<MessageDto> transfer(Transaction transaction);
}
