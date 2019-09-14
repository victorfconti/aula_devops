package br.com.victor.aula_ci.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
	
	@RequestMapping
	public ResponseEntity<String> request(){
		return new ResponseEntity<>("Olá Mundo", HttpStatus.OK);
	}
	
}
