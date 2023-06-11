package com.example.rentACar.Business.rules;

import org.springframework.stereotype.Service;

import com.example.rentACar.core.utilities.exceptions.BusinessException;
import com.example.rentACar.dataAccess.abstracts.BrandRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class BrandBusinessRules {
	
	private BrandRepository brandRepository ; 
	//veri tabanına bağlanıp brand var mı yok mu kontrol edecğimiz için yazdık

	public void checkIfBrandNameExists(String name) {
		if ( this.brandRepository.existsByName(name));
			throw new BusinessException("Brand name already exists");
	}
}
