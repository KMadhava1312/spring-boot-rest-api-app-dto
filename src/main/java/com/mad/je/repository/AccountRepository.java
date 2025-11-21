package com.mad.je.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mad.je.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	public List<Account> findByIfscCode(String ifscCode);

}
