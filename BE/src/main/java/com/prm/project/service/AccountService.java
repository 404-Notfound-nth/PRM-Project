package com.prm.project.service;

import java.util.List;

import com.prm.project.dto.AccountDTO;

public interface AccountService {
	void registerAccount(AccountDTO accountDTO);
	void updateToken(String phone,String token);
	List<AccountDTO> getListAccount(String phone);
}
