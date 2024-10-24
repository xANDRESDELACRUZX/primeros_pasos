package gm.zona_fit;

import gm.zona_fit.controller.ApiController;
import gm.zona_fit.controller.ConsolaController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	private final ConsolaController consolaController;
	private final ApiController apicontroller;
	
	@Autowired
	public ZonaFitApplication(ConsolaController consolaController, ApiController apicontroller) {
		this.consolaController = consolaController;
		this.apicontroller = apicontroller;
	}
	private  static  final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	public static void main(String[] args) throws Exception {
		logger.info("iniciando app");
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("cerrando app");
	}

	@Override
	public void run(String... args) throws Exception {
		consolaController.zonaFit();
	}


}
