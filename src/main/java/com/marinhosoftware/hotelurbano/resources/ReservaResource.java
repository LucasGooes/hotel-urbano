package com.marinhosoftware.hotelurbano.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marinhosoftware.hotelurbano.domain.Reserva;
import com.marinhosoftware.hotelurbano.dto.NovaReservaDTO;
import com.marinhosoftware.hotelurbano.services.ReservaService;

@RestController
@RequestMapping(value = "/reservas")
public class ReservaResource {

	@Autowired
	private ReservaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Reserva obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody NovaReservaDTO objDto) {
		Reserva obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	/*
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ReservaDTO objDto, @PathVariable Integer id) {
		Reserva obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Reserva> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	/*
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ReservaDTO>> findAll() {
		List<Reserva> list = service.findAll();
		List<ReservaDTO> listDto = list.stream()
				.map(obj -> new ReservaDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}*/

}
