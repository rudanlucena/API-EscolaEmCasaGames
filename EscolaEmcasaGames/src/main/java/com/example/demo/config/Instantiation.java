package com.example.demo.config;

import java.util.Arrays;

import com.example.demo.domain.*;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.GameRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private GameService gameService;

	@Autowired
	private DisciplinaService disciplinaservice;

	@Autowired
	private AdminService adminService;

	@Autowired
	private LMSService lmsService;

	@Autowired
	private CursoService cursoService;
	
	@Override
	public void run(String... args) throws Exception {
		
		//gameService.deleteAll();
		//disciplinaservice.deleteAll();
		//adminService.deleteAll();
		//lmsService.deleteAll();
		//cursoService.deleteAll();

//		//Save Disciplina
//		Disciplina disciplina = new Disciplina("4 ano", "matematica");
//		disciplinaservice.save(disciplina);
//
//
//		//Save Game
//		String gameplay = "https://www.youtube.com";
//
//		String resumo = "is simply dummy text of the printing and typesetting industry." +
//				" Lorem Ipsum has been the industry's standard dummy text ever since the " +
//				"1500s, when an unknown printer took a galley of type and scrambled it to " +
//				"make a type specimen book.";
//
//		Game g1 = new Game("Tiro ao Alvo",  disciplina, resumo, gameplay);
//		gameService.save(g1);
//		Game g2 = new Game("Tabuada",  disciplina, resumo, gameplay);
//		gameService.save(g2);
//		Game g3 = new Game("Quiz", disciplina, resumo, gameplay);
//		gameService.save(g3);
//		Game g4 = new Game("Show do Milhão", disciplina, resumo, gameplay);
//		gameService.save(g4);
//		Game g5 = new Game("Mario cart", disciplina, resumo, gameplay);
//		gameService.save(g5);
//		Game g6 = new Game("Mario world", disciplina, resumo, gameplay);
//		gameService.save(g6);
		
		//service.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6));


		//Save Admin
//		Admin admin1= new Admin("rudan", "rudanlucena@gmail.com", "hvlk");
//		Admin admin2 = new Admin("alexa", "alexa@gmail.com", "hvlk");
//		adminService.save(admin1);
//		adminService.save(admin2);

//		//Save LMS
//		LMS lms1 = new LMS("escolaemcasa.com", "escolaemcasa");
//		lmsService.save(lms1);
//		LMS lms2 = new LMS("iescolar.com", "iescolar");
//		lmsService.save(lms2);
//		LMS lms3 = new LMS("ifpb.com", "ifpb");
//		lmsService.save(lms3);



	}

}
