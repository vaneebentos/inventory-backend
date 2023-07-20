package com.company.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;

/*para identificar esta clase como restcontroller,debe tener el decorador*/

@RestController
/*"" ahi indica i uri a nivel general*/
@RequestMapping("/api/v1")
public class CategoryRestCon {
	
	
	/*se inyecta un objeto de tipo de interfas,importando el servicio creado 
	 * en las clases anteriores  */
	
	@Autowired // con esta inyeccion tengo acceso a toda la dependecia de la interfas
	
	/* el metodo ICategoryService es el que inyecta la clase de servicio o la interfas  
	 * de servicio que va al metodo search que esta implementado
	 * en la clase categoryServicios y es le que me devuelve las categorias de la base de datos */
	private ICategoryService service;
	
	
	/*le indico que el metodo va a ser de tipo get */
	
	// en el servidor de localhost:8080 eslach categories
	@GetMapping ("/categories")
	//ingresa en este metodo para consumir el codigo siguiente 
	public ResponseEntity<CategoryResponseRest> searchCategories (){
		
		ResponseEntity<CategoryResponseRest> response = service.search();
		return response;
	}
}
