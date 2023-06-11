package com.example.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forResponse(); //Bunlar stratejiledir . 
	ModelMapper forRequest(); //Mapp yapmak istedkilerini için oluşturursun
	
}
