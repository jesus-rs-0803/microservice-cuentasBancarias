package com.bootcam.cuentasBancarias.client;

import com.bootcam.cuentasBancarias.dto.BankAccountDto;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Maybe;

@Client(value = "account-query", path = "/api/v1/accounts")
public interface BankAccountQueryClient {
    @Get("/{id}")
    Maybe<BankAccountDto> get(String id);
}
