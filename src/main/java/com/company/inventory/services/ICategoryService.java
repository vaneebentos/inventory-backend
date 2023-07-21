package com.company.inventory.services;

import org.springframework.http.ResponseEntity;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;

public interface ICategoryService {
/*creo un metodo de tipo publico que usa la interfas ResponseEntity
 * que da una respuesta  http con un codigo respectivo 
 * y en global una respuesta cuson que engloba lo que esta en <> el metodo search*/
	public ResponseEntity<CategoryResponseRest> search ();
	
	public ResponseEntity<CategoryResponseRest> searchById (Long id);
	
	// esta es la interfas 
	public ResponseEntity<CategoryResponseRest> save (Category category);
	
}
