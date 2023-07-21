package com.company.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
import com.company.inventory.services.ICategoryService;

/*para identificar esta clase como restcontroller,debe tener el decorador*/

@RestController
/*"" ahi indica mi uri a nivel general*/
@RequestMapping("/api/v1")
public class CategoryRestController {
	
	/*se inyecta un objeto de tipo de interfas,importando el servicio creado 
	 * en las clases anteriores  */
	
	@Autowired // con esta inyeccion tengo acceso a toda la dependecia de la interfas
	
	/* el metodo ICategoryService es el que inyecta la clase de servicio o la interfas  
	 * de servicio que va al metodo search que esta implementado
	 * en la clase categoryServicios y es le que me devuelve las categorias de la base de datos */
	private ICategoryService service;
	/**
	 * get all the categories
	 */
	
	/*le indico que el metodo va a ser de tipo get */
	
	// en el servidor de localhost:8080 eslach categories
	@GetMapping ("/categories")
	//ingresa en este metodo para consumir el codigo siguiente 
	public ResponseEntity<CategoryResponseRest> searchCategories (){
		
		// este metodo es para buscar las categorias 
		ResponseEntity<CategoryResponseRest> response = service.search();
		return response;
	}
	/**
	 * Get categories by id
	 * @param id
	 * @return
	 */
	
	
	/*la uri de este metodo recibe un id atra vez de las {}
	 * de esa forma paso el id por la uri y recupera como una variavre atravez del path
	 * como tipo long 
	 * de esta forma se resive la peticion cuando llame un cliente */
		@GetMapping ("/categories/{id}")
		
		public ResponseEntity<CategoryResponseRest> searchCategoriesById (@PathVariable Long id){
			
			/*esta respuesta es la que se le devuelve al cliente*/
			ResponseEntity<CategoryResponseRest> response = service.searchById(id);
			return response;
			
	}

/**
 * Get categories by id
 * @param category 
 * @return
 * este metodo guarda las categorias , el decorador ResquesBody 
 */


	@PostMapping ("/categories")
	
	public ResponseEntity<CategoryResponseRest> save (@RequestBody Category category){
		
		ResponseEntity<CategoryResponseRest> response = service.save(category);
		return response;
		
}
}
