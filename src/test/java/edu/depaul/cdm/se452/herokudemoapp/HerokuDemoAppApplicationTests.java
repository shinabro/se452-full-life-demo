package edu.depaul.cdm.se452.herokudemoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.depaul.cdm.se452.herokudemoapp.student.StudentNote;
import edu.depaul.cdm.se452.herokudemoapp.student.StudentNoteRepository;

@SpringBootTest
class HerokuDemoAppApplicationTests {

	@Autowired
	private StudentNoteRepository repo;
	
	@Test
	void contextLoads() {
	}

}
