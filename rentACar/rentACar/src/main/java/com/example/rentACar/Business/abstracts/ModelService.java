package com.example.rentACar.Business.abstracts;

import java.util.List;

import com.example.rentACar.Business.requests.CreateModelRequest;
import com.example.rentACar.Business.responses.GetAllModelsResponse;

public interface ModelService {

	List<GetAllModelsResponse> getAll() ;
	void add (CreateModelRequest createModelRequest);
}

