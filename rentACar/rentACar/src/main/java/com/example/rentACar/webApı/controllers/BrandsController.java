package com.example.rentACar.webApı.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentACar.Business.abstracts.BrandService;
import com.example.rentACar.Business.requests.CreateBrandsRequest;
import com.example.rentACar.Business.requests.UpdateBrandRequest;
import com.example.rentACar.Business.responses.GetAllBrandsResponse;
import com.example.rentACar.Business.responses.GetByIdBrandResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	
	private BrandService brandService;
	
	@Autowired //önceki constructora gider .Bean yapısıdır
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll() {
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	 
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid() CreateBrandsRequest createBrandsRequest) {
		this.brandService.add(createBrandsRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
}
