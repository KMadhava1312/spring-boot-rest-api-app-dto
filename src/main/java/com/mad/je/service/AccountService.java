package com.mad.je.service;

import java.util.List;

import com.mad.je.dto.AccountDto;
import com.mad.je.entity.Account;

public interface AccountService {

	public AccountDto addAccount(AccountDto account);

	public List<AccountDto> addAccounts(List<AccountDto> list);

	public AccountDto getAccountByAccNo(Long accNo);

	public List<AccountDto> getAccountsByIfscCode(String ifscCode);

	public AccountDto updateAccount(AccountDto account);

	public String deleteAccountByAccNo(Long accNo);

}
