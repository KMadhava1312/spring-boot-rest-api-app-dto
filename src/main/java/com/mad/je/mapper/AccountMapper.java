package com.mad.je.mapper;

import com.mad.je.dto.AccountDto;
import com.mad.je.entity.Account;

public class AccountMapper {

	// Convert Account JPA Entity into Account DTO
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(account.getAccNo(), account.getAccType(), account.getOpeningDt(),
				account.getOpeningBal(), account.getIfscCode(), account.getAccStatus());
		return accountDto;
	}

	// Convert Account DTO into Account JPA Entity
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(accountDto.getAccNo(), accountDto.getAccType(), accountDto.getOpeningDt(),
				accountDto.getOpeningBal(), accountDto.getIfscCode(), accountDto.getAccStatus());
		return account;
	}

}
