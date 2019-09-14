package br.com.victor.aula_ci.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.micrometer.core.annotation.Timed;

@Service
public class SaldoService {
	Logger logger = LoggerFactory.getLogger(SaldoService.class);
	AtomicLong uid = new AtomicLong(1L);
	
	@Timed(
	value = "ufscar_service_saldo",
	histogram = false,
	description = "Metodo de obtenção de saldo",
	extraTags = "Versão 1",
	percentiles = {0.25, 0.5, 0.95, 0.99})
	public ResponseEntity<Map<String, Long>> get(){
		Long saldo = 1200L;
		logger.info("[UID: {}] Saldo {}", uid, saldo);		
		HashMap<String, Long> response = new HashMap<>();
		response.put("saldo",saldo);
		
		try {
			throw new IllegalArgumentException("Saldo inválido");
		}catch(IllegalArgumentException e) {
			logger.error("[UID: {}] Error: {}", uid, e.getMessage());
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
