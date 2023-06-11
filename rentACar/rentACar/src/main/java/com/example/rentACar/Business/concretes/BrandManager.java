package com.example.rentACar.Business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rentACar.Business.abstracts.BrandService;
import com.example.rentACar.Business.requests.CreateBrandsRequest;
import com.example.rentACar.Business.requests.UpdateBrandRequest;
import com.example.rentACar.Business.responses.GetAllBrandsResponse;
import com.example.rentACar.Business.responses.GetByIdBrandResponse;
import com.example.rentACar.Business.rules.BrandBusinessRules;
import com.example.rentACar.core.utilities.mappers.ModelMapperService;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;
import com.example.rentACar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service // bu sınıf bir business nesnesidir
@AllArgsConstructor //injectionlar bunla otamatik oldu
public class BrandManager implements BrandService {

	private BrandRepository brandRepository ;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	
	
	
	@Override
	public List<GetAllBrandsResponse> getAll() {
		// iş kuralları
		
		List<Brand> brands = brandRepository.findAll();
		
	/* 	List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		
	  	for(Brand brand : brands) {
		GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
		responseItem.setId(brand.getId());
		responseItem.setName(brand.getName());
		brandsResponse.add(responseItem);
		}
		
	*/		
		List<GetAllBrandsResponse> brandsResponse = brands.stream().
				map(brand -> this.modelMapperService.forResponse(). 
					map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList())	;
		return brandsResponse ;
	}

	@Override
	public void add(CreateBrandsRequest createBrandsRequest) {
		
	//	Brand brand = new Brand();
	//  brand.setName(createBrandsRequest.getName();
		// mapping böyle bir sürü set işlemden kurtarır 
	
	this.brandBusinessRules.checkIfBrandNameExists(createBrandsRequest.getName());	
	
	Brand brand = this.modelMapperService.forRequest().map(createBrandsRequest,Brand.class);	
	
	this.brandRepository.save(brand);
		
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		 GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		 return response;
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}


	
}
