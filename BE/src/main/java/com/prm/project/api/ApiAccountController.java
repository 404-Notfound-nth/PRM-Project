package com.prm.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prm.project.dto.AccountDTO;
import com.prm.project.service.AccountService;

@RestController
@RequestMapping("api/account")
public class ApiAccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("register")
	public ResponseEntity<Object> registerAccount(@RequestBody AccountDTO accountDTO){
		try {
			accountService.registerAccount(accountDTO);
			return new ResponseEntity<Object>("Register Successfull !!!", HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
