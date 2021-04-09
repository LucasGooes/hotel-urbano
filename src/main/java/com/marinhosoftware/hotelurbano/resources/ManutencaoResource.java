package com.marinhosoftware.hotelurbano.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marinhosoftware.hotelurbano.domain.Manutencao;
import com.marinhosoftware.hotelurbano.services.ManutencaoService;

@RestController
@RequestMapping(value = "/manutencoes")
public class ManutencaoResource {
	
	@Autowired
	private ManutencaoService service;
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Manutencao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Manutencao obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Manutencao/*DTO*/>> findAll() {
		List<Manutencao> list = service.findAll();
		/*List<ManutencaoDTO> listDto = list.stream()
				.map(obj -> new ManutencaoDTO(obj))
				.collect(Collectors.toList());*/
		return ResponseEntity.ok().body(list/*Dto*/);
	}
}
