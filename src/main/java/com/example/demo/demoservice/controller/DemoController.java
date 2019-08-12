package com.example.demo.demoservice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demoservice.model.Name;

@RequestMapping(produces = APPLICATION_JSON_VALUE)
@RestController
public class DemoController {

	@GetMapping(value = "/names")
	@ResponseStatus(HttpStatus.OK)
	public Name getNames() {

		System.out.println("DemoController::getNames()");

		return new Name("Venkatesan", "Mahendran");

	}
}
