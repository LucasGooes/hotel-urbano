package com.marinhosoftware.hotelurbano.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marinhosoftware.hotelurbano.domain.Quarto;
import com.marinhosoftware.hotelurbano.domain.enums.StatusQuarto;
import com.marinhosoftware.hotelurbano.domain.enums.TipoQuarto;

@RestController
@RequestMapping(value = "/quartos")
public class QuartoResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Quarto> listar() {
		
		Quarto qto1 = new Quarto( 1, "11", "01", TipoQuarto.STANDARD, StatusQuarto.DISPONIVEL);
		Quarto qto2 = new Quarto( 2, "12", "01", TipoQuarto.DELUXE, StatusQuarto.OCUPADO);
		
		List<Quarto> lista = new ArrayList<>();
		lista.add(qto1);
		lista.add(qto2);
		
		
		return lista;
	}
	

}
