package com.company.inventory.response;

import lombok.Getter;
import lombok.Setter;

/*ResponseRest es la clase que 
 *se encarga de resetear toda la  metadata 
 *que se le este informando al usuario*/


@Getter
@Setter
public class CategoryResponseRest extends ResponseRest{

	// nuevamente declaro un atributo privado
	/*tipo categoryResponse
	 * instancandole el objeto categoryResponseRest*/
	
	private CategoryResponse categoryResponse = new CategoryResponse (); 
	

	
	
	
}
