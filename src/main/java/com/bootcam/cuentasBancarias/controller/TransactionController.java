package com.bootcam.cuentasBancarias.controller;

import org.springframework.stereotype.Controller;

import com.bootcam.cuentasBancarias.service.TransactionService;

import io.netty.handler.codec.http.HttpResponse;

@Controller ("/api/v1/transactions")
public class TransactionController {
	private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @Post("/withdraw")
    public HttpResponse<String> withdraw(@Valid @Body TransactionDto transactionDto) {
        try {
            return HttpResponse.created(transactionService.withdraw(transactionDto));
        } catch (NoAccountExistsException | InsufficientBalanceException | CustomerDoesNotExistException | ErrorValidatingBankAccountException | ErrorValidatingCustomerException e) {
            return HttpResponse.badRequest(e.getMessage());
        } catch (AccountUpdateException e) {
            return HttpResponse.serverError();
        }
    }


    @Post("/deposit")
    public HttpResponse<String> deposit(@Valid @Body TransactionDto transactionDto) {
        try {
            return HttpResponse.created(transactionService.deposit(transactionDto));
        } catch (NoAccountExistsException | CustomerDoesNotExistException | ErrorValidatingBankAccountException | ErrorValidatingCustomerException e) {
            return HttpResponse.badRequest(e.getMessage());
        } catch (AccountUpdateException e) {
            return HttpResponse.serverError();
        }
    }

    @Post("/transfer")
    public HttpResponse<String> transfer(@Body TransferTransactionDto transactionDto) {
        try {
            return HttpResponse.created(transactionService.transfer(transactionDto));
        } catch (NoAccountExistsException | InsufficientBalanceException | CustomerDoesNotExistException | ErrorValidatingBankAccountException | ErrorValidatingCustomerException e) {
            return HttpResponse.badRequest(e.getMessage());
        } catch (AccountUpdateException e) {
            return HttpResponse.serverError();
        }
    }

    @Get("/id/{id}")
    public Transaction getTransaction(String id) {
        Transaction bankTransaction = this.transactionService.getTransaction(id);
        if (bankTransaction != null) {
            return bankTransaction;
        }
        return null;
    }
	
	

}
