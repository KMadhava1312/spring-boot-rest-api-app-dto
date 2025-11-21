package com.mad.je.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mad.je.dto.AccountDto;
import com.mad.je.entity.Account;
import com.mad.je.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/create")
	public ResponseEntity<AccountDto> saveAccount(@RequestBody AccountDto accountDto) {
		AccountDto saveAccount = accountService.addAccount(accountDto);
		return new ResponseEntity<>(saveAccount, HttpStatus.CREATED);
	}

	@PostMapping("/bulk-create")
	public ResponseEntity<List<AccountDto>> saveAccounts(@RequestBody List<AccountDto> accountsDto) {
		List<AccountDto> saveAccounts = accountService.addAccounts(accountsDto);
		return new ResponseEntity<>(saveAccounts, HttpStatus.CREATED);
	}

	@GetMapping("/{accNo}")
	public ResponseEntity<AccountDto> getAccountByAccNo(@PathVariable Long accNo) {
		AccountDto accountDto = accountService.getAccountByAccNo(accNo);
		if (accountDto != null) {
			return new ResponseEntity<>(accountDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/ifsc/{ifscCode}")
	public ResponseEntity<List<AccountDto>> getAccountByIfscCode(@PathVariable String ifscCode) {
		List<AccountDto> list = accountService.getAccountsByIfscCode(ifscCode);
		if (!list.isEmpty()) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/{accNo}")
	public ResponseEntity<AccountDto> updateAccount(@PathVariable Long accNo, @RequestBody AccountDto account) {
		AccountDto updatedAccount = accountService.updateAccount(account);
		return ResponseEntity.ok(updatedAccount);
	}

	@DeleteMapping("/delete/{accNo}")
	public ResponseEntity<String> deleteAccountByAccNo(@PathVariable Long accNo) {
		String result = accountService.deleteAccountByAccNo(accNo);
		if (result.contains("deleted")) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	}
}
