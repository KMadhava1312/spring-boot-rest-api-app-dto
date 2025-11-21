package com.mad.je.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_info")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accNo;
	private String accType;
	private LocalDate openingDt;
	private String openingBal;
	private String ifscCode;
	private String accStatus;

	public Account() {
		super();
	}

	public Account(Long accNo, String accType, LocalDate openingDt, String openingBal, String ifscCode,
			String accStatus) {
		super();
		this.accNo = accNo;
		this.accType = accType;
		this.openingDt = openingDt;
		this.openingBal = openingBal;
		this.ifscCode = ifscCode;
		this.accStatus = accStatus;
	}

	public Long getAccNo() {
		return accNo;
	}

	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public LocalDate getOpeningDt() {
		return openingDt;
	}

	public void setOpeningDt(LocalDate openingDt) {
		this.openingDt = openingDt;
	}

	public String getOpeningBal() {
		return openingBal;
	}

	public void setOpeningBal(String openingBal) {
		this.openingBal = openingBal;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accNo, accStatus, accType, ifscCode, openingBal, openingDt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accNo, other.accNo) && Objects.equals(accStatus, other.accStatus)
				&& Objects.equals(accType, other.accType) && Objects.equals(ifscCode, other.ifscCode)
				&& Objects.equals(openingBal, other.openingBal) && Objects.equals(openingDt, other.openingDt);
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accType=" + accType + ", openingDt=" + openingDt + ", openingBal="
				+ openingBal + ", ifscCode=" + ifscCode + ", accStatus=" + accStatus + "]";
	}

}
