package com.example.rentACar.webApı.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.Business.abstracts.ModelService;
import com.example.rentACar.Business.requests.CreateModelRequest;
import com.example.rentACar.Business.responses.GetAllModelsResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
	
	private ModelService modelService ;
	
	@GetMapping()
	public List<GetAllModelsResponse> getAll() {
		return modelService.getAll();
	}

	 
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid() CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
}
