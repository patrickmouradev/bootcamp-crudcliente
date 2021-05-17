package com.patrickmoura.crudcliente.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patrickmoura.crudcliente.dto.ClientDTO;
import com.patrickmoura.crudcliente.services.ClientService;



@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	ClientService service;
	
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findall (
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy
			 ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		Page<ClientDTO> list = service.findAllPaged(pageRequest);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}

}
