package br.com.victor.aula_ci.controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victor.aula_ci.service.SaldoService;

@RestController
public class IndexController {
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	private AtomicLong uid = new AtomicLong(1);
	private SaldoService saldoService;
	
	public IndexController(SaldoService saldoService) {
		this.saldoService = saldoService;
	}
	
	@GetMapping
	public ResponseEntity<Map<String, Long>> request(){
		logger.info("[uid:{}]", uid);		
		return saldoService.get();		
	}
	
}
