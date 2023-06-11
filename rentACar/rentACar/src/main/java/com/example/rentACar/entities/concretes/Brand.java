package com.example.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//concretes --> somut olan şeyler , abstarct interface gibi değil


@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="brands")
@Entity

public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id ; //veriyi diğer verilereden ayırmak için kullanırız 
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "brand")  // bir markanın birden çok modeli var
	private List<Model> models; // markanın modelleri var
}
 
//Brand ---> id , name , quantity 
//GetAllBrandsResponse ---> id , name 
//mapping 


