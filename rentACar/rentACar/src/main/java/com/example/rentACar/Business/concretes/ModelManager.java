package com.example.rentACar.Business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentACar.Business.abstracts.ModelService;
import com.example.rentACar.Business.requests.CreateModelRequest;
import com.example.rentACar.Business.responses.GetAllModelsResponse;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.ModelRepository;
import com.example.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		
		List<Model> models = modelRepository.findAll();	
		List<GetAllModelsResponse> modelsResponse = models.stream().
				map(model -> this.modelMapperService.forResponse(). 
						map(model,GetAllModelsResponse.class)).collect(Collectors.toList())	;
			return modelsResponse ;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);	
		this.modelRepository.save(model);
		
	}

}
