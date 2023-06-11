package com.example.rentACar.Business.abstracts;

import java.util.List;

import com.example.rentACar.Business.requests.CreateBrandsRequest;
import com.example.rentACar.Business.requests.UpdateBrandRequest;
import com.example.rentACar.Business.responses.GetAllBrandsResponse;
import com.example.rentACar.Business.responses.GetByIdBrandResponse;

public interface BrandService {
	
	List<GetAllBrandsResponse> getAll() ;
	GetByIdBrandResponse getById(int id);
	void add (CreateBrandsRequest createBrandsRequest);
	void update (UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}
