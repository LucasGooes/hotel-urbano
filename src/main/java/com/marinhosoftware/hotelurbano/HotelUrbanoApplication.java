package com.marinhosoftware.hotelurbano;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marinhosoftware.hotelurbano.domain.Manutencao;
import com.marinhosoftware.hotelurbano.domain.Quarto;
import com.marinhosoftware.hotelurbano.domain.enums.StatusQuarto;
import com.marinhosoftware.hotelurbano.domain.enums.TipoQuarto;
import com.marinhosoftware.hotelurbano.repositories.ManutencaoRepository;
import com.marinhosoftware.hotelurbano.repositories.QuartoRepository;

@SpringBootApplication
public class HotelUrbanoApplication implements CommandLineRunner {
	
	@Autowired
	private QuartoRepository quartoRepository;
	@Autowired
	private ManutencaoRepository manutencaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HotelUrbanoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Quarto qto1 = new Quarto(1, "11", "01", TipoQuarto.STANDARD, StatusQuarto.DISPONIVEL);
		Quarto qto2 = new Quarto(2, "12", "01", TipoQuarto.DELUXE, StatusQuarto.OCUPADO);
		
		Manutencao manutencao1 = new Manutencao(1, "Concerto de encanamento", 120.00, qto1);
		
		qto1.getManutencoes().addAll(Arrays.asList(manutencao1));
		
		quartoRepository.saveAll(Arrays.asList(qto1, qto2));
		manutencaoRepository.saveAll(Arrays.asList(manutencao1));
	}

}
