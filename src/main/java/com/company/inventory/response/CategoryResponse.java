package com.company.inventory.response;

import java.util.List;

import com.company.inventory.model.Category;

import lombok.Data;


@Data //para utilizar lombok uso el decorador Data para los getters y setters
public class CategoryResponse {
	
	/* declaramos un atributo privado
	 * con una lista de categorias */
	
	
	private List<Category> category;

}
