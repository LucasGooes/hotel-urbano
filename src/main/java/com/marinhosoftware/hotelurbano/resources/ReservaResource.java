package com.marinhosoftware.hotelurbano.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marinhosoftware.hotelurbano.domain.Reserva;
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

}
