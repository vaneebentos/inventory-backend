package com.company.inventory.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.inventory.dao.ICategoryDao;
import com.company.inventory.model.Category;
import com.company.inventory.response.CategoryResponseRest;
// a esta clase se debe decorar con la etiqueta sprint que se llama Service
@Service // con esto le indico que esta clase es de servicios 

/*se debe agregar los metodos implementados */
public class CategoryServiceImpl implements ICategoryService{
	
	
/*hay que inyectar la dependecia a la clase servicio para eso se crea 
 * propiedad de tipo privado, se declara la interfas dao */	
	@Autowired // esta anotacion se encarga de inyectar categoryDao al array de String
	private ICategoryDao categoryDao;
	
	/*agrega el metodo search con su estructura base */
	@Override
	@Transactional (readOnly= true)
	public ResponseEntity<CategoryResponseRest> search() {
		
		// declaro el objeto (CAtegoryResponseRest)
		CategoryResponseRest response = new CategoryResponseRest ();
		
		try {
			/*llamo al metodo FindAll usando el categoryDao que inyecte arriba
			 *y uso un cast para que mi metodo FindAll devuelva una lista de categorias
			 **/
			List<Category> category = (List<Category>) categoryDao.findAll();
			
			/* la respuesta es response,lleno el metodo categoria con toda la lista que me dio de las categoryas  */
			response.getCategoryResponse ().setCategory (category);
			
			/*lleno el metada
			 * le paso un tipo,le damos un codigo,y un cometario */
			response.setMetadata("Rspuesta ok","00","Respuesta exitosa");
		}catch (Exception e) {
			response.setMetadata("Rspuesta nok","-1","Error al consultar ");
			/*para dar mensajes de loc imprimimos con get */
			e.getStackTrace();
			
			// devolvemos un responseEntity
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
		
		// retorno mi respuesta que va a ser una clase responseEntity (respuesta, y el codigo hhtp que devuelve ok)
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> searchById(Long id) {

		CategoryResponseRest response = new CategoryResponseRest ();
		List<Category>List = new ArrayList<>();
		try {
			
			/*el metodo faindById busca la base d e datos con el id que le pase  */
			
			/*el metodo optional devuelve un objeto opcional */
			Optional<Category> category = categoryDao.findById(id);
			
			/**
			 * si el objeto encuentra con el metodo isPresent y le agrega la categoria a la vista 
			 */
			if(category.isPresent()) {
				List.add(category.get());
				response.getCategoryResponse().setCategory(List);
				
				response.setMetadata("Rspuesta ok","00","Categoria  encontrada ");
				
				/**
				 * si no encuentra la categoria muestra un error 
				 */
			}else {
				response.setMetadata("Rspuesta nok","-1","Categoria no encontrada ");
				
				/**
				 * si no encuentra el id solicitado devuelve que no encuentra,es con 
				 * un not faund que es el 404 en lugar del error 505
				 */
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
				
			}
		}catch (Exception e) {
			response.setMetadata("Rspuesta nok","-1","Error al consultar por id ");
			e.getStackTrace();
			
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
		
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResponseRest> save(Category category) {
		CategoryResponseRest response = new CategoryResponseRest ();
		List<Category>List = new ArrayList<>();
		try {
			Category categorySaved = categoryDao.save(category);
			if (categorySaved != null) {
				List.add(categorySaved);
				response.getCategoryResponse().setCategory(List);
				response.setMetadata("Rspuesta nok","00","Categoria guardada ");
			}else {
				response.setMetadata("Rspuesta nok","-1","Categoria no guardada ");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			response.setMetadata("Rspuesta nok","-1","Error al guardar la categoria ");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
		
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional 
	public ResponseEntity<CategoryResponseRest> update(Category category, Long id) {
		CategoryResponseRest response = new CategoryResponseRest ();
		List<Category>List = new ArrayList<>();
		try {
			Optional <Category>categorySearch = categoryDao.findById(id);
			
			if(categorySearch.isPresent()) {
				
				// se prosederà a actualizar el registro
				
			
				categorySearch.get().setName(category.getName());
				categorySearch.get().setDescription(category.getDescription());
				/**
				 * este es para actualizar la variable
				 */
				
				Category categoryToUpdate = categoryDao.save(categorySearch.get());
				
				if(categoryToUpdate != null) {
					List.add(categoryToUpdate);
					response.getCategoryResponse().setCategory(List);
					response.setMetadata("Rspuesta nok","00","Categoria actualizada ");
				}else {
					response.setMetadata("Rspuesta nok","-1","Categoria no actualizada ");
					return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
				}
				
			}else {
				response.setMetadata("Rspuesta nok","-1","Categoria no encontrada ");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			response.setMetadata("Rspuesta nok","-1","Error al actualizar la categoria ");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
		
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}
}
	



