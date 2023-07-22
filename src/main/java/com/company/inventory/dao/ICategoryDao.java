package com.company.inventory.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.company.inventory.model.Category;

/* el primer paso es extender de una clase que se llame CrudRepository*/
/*<Category> es una clase */
/*en esta interfas esta todos los metodos para acceder a los 
 *pasch y generar un crud (crear,acceder,actualizar,eliminar)*/
public interface ICategoryDao extends CrudRepository<Category, Long> {

	
/*DAO significa data access object */
}
/*la clase que implementa el crud repositor es Category y el tipo de dato del ID de la clase es  long*/