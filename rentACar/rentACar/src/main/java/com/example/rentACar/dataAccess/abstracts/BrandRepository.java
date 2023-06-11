package com.example.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rentACar.entities.concretes.Brand;

//repository veri tabanı işlerini yapacak sınıflardır        primary key türü
public interface BrandRepository extends JpaRepository<Brand,Integer> {
	//JpaRepository getall ve benzeri temel metodları zaten içerir 
	//JpaRepository sayesinde brandin concretesi spring tarafından bellekte oto hazırlanıyor

	boolean existsByName(String name) ;
	//spring jpa keywordleri ile bunun concretes kısmıda otamatik oluşuyor .
	// List<Brand> findByName(String name);
	// Brand findByName(String name);
}
 