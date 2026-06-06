package com.crudo;
import com.crudo.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CrudoApplication implements CommandLineRunner {

	//private final DataService dataService;

	@Value("${my.variable}")
	private String myVariable;

	public static void main(String[] args) {
		SpringApplication.run(CrudoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("my varisble "+myVariable);
		//System.out.println("The Data Is:"+dataService.getData());
	}
}
