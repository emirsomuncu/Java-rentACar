package com.example.rentACar.Business.responses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor


public class GetAllModelsResponse {
  
	private int id ;
	private String name ;
	private String brandName; // brand_id de alabilirdin  //mapper sayesinde çevirme işlemini yaparken 
	 						  // yine mapper sayesinde brandName alanını için brandin nameine gider ve alır değeri
}							  // join coloumn anotasyonu sayesinde
 