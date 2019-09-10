package com.example.demo.demoservice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demoservice.model.Name;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@RequestMapping(produces = APPLICATION_JSON_VALUE)
@RestController
public class DemoController {

	@GetMapping(value = "/names")
	@ResponseStatus(HttpStatus.OK)
	public Name getNames() {

		System.out.println("DemoController::getNames()");

		return new Name("Venkatesan", "Mahendran");

	}

	@GetMapping(path = "/ships/{shipName}/names")
	@ResponseStatus(HttpStatus.OK)
	public String getCaptainName(@PathVariable("shipName") String shipName) {
		System.err.println(shipName);

		OkHttpClient client = new OkHttpClient();
		
		String hostUrl = System.getProperty("outgoing.connection.url");
		
		System.out.println(hostUrl);

		String url = hostUrl + "/names";
		
		System.out.println(url);

		Request request = new Request.Builder().url(url).build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}

	}
}
