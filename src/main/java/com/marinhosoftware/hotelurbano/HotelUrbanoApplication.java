package com.marinhosoftware.hotelurbano;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marinhosoftware.hotelurbano.domain.Cliente;
import com.marinhosoftware.hotelurbano.domain.Manutencao;
import com.marinhosoftware.hotelurbano.domain.Quarto;
import com.marinhosoftware.hotelurbano.domain.Reserva;
import com.marinhosoftware.hotelurbano.domain.Servico;
import com.marinhosoftware.hotelurbano.domain.enums.Sexo;
import com.marinhosoftware.hotelurbano.domain.enums.StatusQuarto;
import com.marinhosoftware.hotelurbano.domain.enums.TipoQuarto;
import com.marinhosoftware.hotelurbano.repositories.ClienteRepository;
import com.marinhosoftware.hotelurbano.repositories.ManutencaoRepository;
import com.marinhosoftware.hotelurbano.repositories.QuartoRepository;
import com.marinhosoftware.hotelurbano.repositories.ReservaRepository;
import com.marinhosoftware.hotelurbano.repositories.ServicoRepository;

@SpringBootApplication
public class HotelUrbanoApplication implements CommandLineRunner {
	
	@Autowired
	private QuartoRepository quartoRepository;
	@Autowired
	private ManutencaoRepository manutencaoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private ServicoRepository servicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HotelUrbanoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cliente1 = new Cliente(1, "Felipe Gonçalves", "234918378", "38996139297", "fabio34@gmail.com", Sexo.MASCULINO);
		Cliente cliente2 = new Cliente(2, "Lucas Marcos", "384723524", "86618957826", "luquinha@gmail.com", Sexo.MASCULINO);
		Cliente cliente3 = new Cliente(3, "Eduarda Guimaraes", "316639862", "09840910337", "eduarda_gui@gmail.com", Sexo.FEMININO);
		
		cliente1.getTelefones().addAll(Arrays.asList("3155409088"));
		cliente2.getTelefones().addAll(Arrays.asList("3282904799", "045752991"));
		cliente3.getTelefones().addAll(Arrays.asList("8307088493"));
		
		Quarto qto1 = new Quarto(1, "11", "01", TipoQuarto.STANDARD, StatusQuarto.DISPONIVEL);
		Quarto qto2 = new Quarto(2, "12", "01", TipoQuarto.DELUXE, StatusQuarto.OCUPADO);
		Quarto qto3 = new Quarto(3, "21", "02", TipoQuarto.STANDARD, StatusQuarto.OCUPADO);
		Quarto qto4 = new Quarto(4, "22", "02", TipoQuarto.MASTER, StatusQuarto.MANUTENCAO);
		
		Manutencao manutencao1 = new Manutencao(1, "Concerto de encanamento", 120.00, qto4);
		Manutencao manutencao2 = new Manutencao(2, "Concerto de Arcondicionado", 80.00, qto3);
		Manutencao manutencao3 = new Manutencao(3, "Reforma Janela", 65.00, qto4);
		
		qto4.getManutencoes().addAll(Arrays.asList(manutencao1, manutencao3));
		qto3.getManutencoes().addAll(Arrays.asList(manutencao2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Reserva reserva1 = new Reserva(1, sdf.parse("14/02/2021 18:35"), sdf.parse("24/02/2021 18:35"), 635.00, 10, 60.00, cliente1);
		Reserva reserva2 = new Reserva(2, sdf.parse("02/03/2021 20:00"), sdf.parse("10/03/2021 18:45"), 1513.00, 8, 180.00, cliente2);
		Reserva reserva3 = new Reserva(3, sdf.parse("10/03/2021 07:32"), null, 0.00, 16, 260.00, cliente3);
		
		Servico servico1 = new Servico(1, "Almoço", "Carne Cozida", 35.00, reserva1);
		Servico servico2 = new Servico(2, "Limpeza", "Limpeza a nível médio", 20.00, reserva2);
		Servico servico3 = new Servico(3, "Bebidas", "1 vinho, 2 coca=cola 2L", 53.00, reserva2);
		Servico servico4 = new Servico(4, "Jantar", "2 Porções de Frango ao molho", 50.00, reserva3);
		
		reserva1.getServicos().addAll(Arrays.asList(servico1));
		reserva2.getServicos().addAll(Arrays.asList(servico2, servico3));
		reserva3.getServicos().addAll(Arrays.asList(servico4));
		
		reserva1.getQuartos().addAll(Arrays.asList(qto1));
		reserva2.getQuartos().addAll(Arrays.asList(qto1, qto4));
		reserva3.getQuartos().addAll(Arrays.asList(qto3, qto4));
		
		cliente1.getReservas().addAll(Arrays.asList(reserva1));
		cliente2.getReservas().addAll(Arrays.asList(reserva2));
		cliente3.getReservas().addAll(Arrays.asList(reserva3));
		
		quartoRepository.saveAll(Arrays.asList(qto1, qto2, qto3, qto4));
		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
		manutencaoRepository.saveAll(Arrays.asList(manutencao1, manutencao2, manutencao3));
		reservaRepository.saveAll(Arrays.asList(reserva1, reserva2, reserva3));
		servicoRepository.saveAll(Arrays.asList(servico1, servico2, servico3, servico4));
	}

}
