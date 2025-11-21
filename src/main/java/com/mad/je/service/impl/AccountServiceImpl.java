package com.mad.je.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mad.je.dto.AccountDto;
import com.mad.je.entity.Account;
import com.mad.je.mapper.AccountMapper;
import com.mad.je.repository.AccountRepository;
import com.mad.je.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public AccountDto addAccount(AccountDto accountDto) {

		/*
		 * // Convert DTO into JPA Entity Account account = new
		 * Account(accountDto.getAccNo(), accountDto.getAccType(),
		 * accountDto.getOpeningDt(),accountDto.getOpeningBal(),
		 * accountDto.getIfscCode(), accountDto.getAccStatus());
		 */

		Account account = AccountMapper.mapToAccount(accountDto);

		Account savedAccount = accountRepository.save(account);

		/*
		 * // Convert JPA Entity into DTO AccountDto savedAccountDto = new
		 * AccountDto(savedAccount.getAccNo(), savedAccount.getAccType(),
		 * savedAccount.getOpeningDt(), savedAccount.getOpeningBal(),
		 * savedAccount.getIfscCode(), savedAccount.getAccStatus());
		 */

		AccountDto savedAccountDto = AccountMapper.mapToAccountDto(savedAccount);

		return savedAccountDto;
	}

	@Override
	public List<AccountDto> addAccounts(List<AccountDto> accountDtolist) {

		// Convert DTO → Entity
		List<Account> list = new ArrayList<>();
		for (AccountDto accountDto : accountDtolist) {
			Account account = AccountMapper.mapToAccount(accountDto);
			list.add(account);
		}

		// Save all accounts
		List<Account> savedAccountlist = accountRepository.saveAll(list);

		// Convert Entity → DTO
		List<AccountDto> savedAccountDtolist = new ArrayList<>();
		for (Account account : savedAccountlist) {
			AccountDto accountDto = AccountMapper.mapToAccountDto(account);
			savedAccountDtolist.add(accountDto);
		}

		return savedAccountDtolist;
	}

	@Override
	public AccountDto getAccountByAccNo(Long accNo) {
		Account account = accountRepository.findById(accNo).orElse(null);
		AccountDto accountDto = AccountMapper.mapToAccountDto(account);
		return accountDto;
	}

	@Override
	public List<AccountDto> getAccountsByIfscCode(String ifscCode) {
		List<Account> accountList = accountRepository.findByIfscCode(ifscCode);
		List<AccountDto> savedAccountDtolist = new ArrayList<>();
		for (Account account : accountList) {
			AccountDto accountDto = AccountMapper.mapToAccountDto(account);
			savedAccountDtolist.add(accountDto);
		}
		return savedAccountDtolist;

	}

	@Override
	public AccountDto updateAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account existAccountInfo = accountRepository.findById(account.getAccNo()).orElse(null);
		existAccountInfo.setAccType(account.getAccType());
		existAccountInfo.setOpeningDt(account.getOpeningDt());
		existAccountInfo.setOpeningBal(account.getOpeningBal());
		existAccountInfo.setAccStatus(account.getAccStatus());
		Account savedAccount=accountRepository.save(existAccountInfo);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public String deleteAccountByAccNo(Long accNo) {
		if (accountRepository.existsById(accNo)) {
			accountRepository.deleteById(accNo);
			return "Account number " + accNo + " deleted successfully..";
		} else {
			return "Account number " + accNo + " not found..";
		}
	}

}
