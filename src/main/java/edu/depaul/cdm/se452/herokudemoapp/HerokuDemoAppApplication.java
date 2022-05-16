package edu.depaul.cdm.se452.herokudemoapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.herokudemoapp.student.StudentNote;
import edu.depaul.cdm.se452.herokudemoapp.student.StudentNoteRepository;
import edu.depaul.cdm.se452.herokudemoapp.student.StudentRepository;
import lombok.extern.java.Log;

@SpringBootApplication
public class HerokuDemoAppApplication {

	@Value( "${spring.profiles.active:none set}" )
    private String profile;
		
	public static void main(String[] args) {
		SpringApplication.run(HerokuDemoAppApplication.class, args);
	}

//	@Bean
	public void sayToConsole() {
		System.out.println("Hello: " + profile);
	}

//	@Bean
	public CommandLineRunner showStudents(StudentRepository repository) {
	  return (args) -> {
		
		// fetch all Students
		System.out.println("Students found with findAll():");
		System.out.println("-------------------------------");
		repository.findAll().forEach((student) -> {
			System.out.println(student.toString());
		});
		System.out.println("-------------------------------");
	  };
	}

	//@Bean
	public CommandLineRunner addStudentNote(StudentNoteRepository repository) {
	  return (args) -> {
		
		// fetch all Students
		System.out.println("adding Student Note:");
		long before = repository.count();
		StudentNote note = new StudentNote();
		note.setNote("SE352/452 rocks!");
		note.setStudentId("1234");
		repository.save(note);
		long after = repository.count();
		System.out.println(before + " " + after);
	  };
	}

	@Bean
	public CommandLineRunner showStudentNote(StudentNoteRepository repository) {
		return (args) -> {
		  
		  // fetch all Students
		  System.out.println("Students found with findAll():");
		  System.out.println("-------------------------------");
		  repository.findAll().forEach((student) -> {
			  System.out.println(student.toString());
		  });
		  System.out.println("-------------------------------");
		  };
  
	}

}
