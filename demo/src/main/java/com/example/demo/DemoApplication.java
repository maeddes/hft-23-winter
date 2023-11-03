package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	private List<String> stringList = new ArrayList<>();

	//@GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(){

		return "Hallo, Stuttgart (GET Call)";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String postHello(){

		return "Hallo, Stuttgart (POST Call)";

	}

	@PostMapping("/api")
	public String sayHelloAgain(){

		// test
		return "Hallo, Stuttgart from another REST endpoint";

	}


	// GET method changes state of the server
	// clearing the whole is dangerous
	// static return null
	// not using resources
	// using own descriptive verbs in the call

	@GetMapping("/doOrMakeOrCreateorWhateverBlblaresource")
	public String doWhatever(){

		this.stringList.clear();
		return null;
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
