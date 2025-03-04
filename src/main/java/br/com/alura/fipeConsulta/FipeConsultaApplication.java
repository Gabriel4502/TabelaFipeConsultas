package br.com.alura.fipeConsulta;

import br.com.alura.fipeConsulta.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeConsultaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeConsultaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var principal = new Principal();
		principal.menu();
	}
}
