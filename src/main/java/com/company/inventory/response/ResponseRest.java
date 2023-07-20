package com.company.inventory.response;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseRest {
	private ArrayList<HashMap<String, String >> metadata = new ArrayList<> ();
/*Crear los metodos Getmetadata y Setmetadata
 * clic derecho source genetateGetters and Setters
 * 
 * */
	public ArrayList<HashMap<String, String>> getMetadata() {
		return metadata;
	}

	
	public void setMetadata (String type,String code,String date) {
		/* ES LA LINEA SIGUIENTE SE CREA UN MAPA QUE ES MAP*/
		HashMap<String,String> map = new HashMap<String, String>();
		
		/* se setea el mapa con el metodo put  */
		
		map.put("type", type);
		map.put("code", code);
		map.put("date", date);
		
		metadata.add(map); // se le agrega al metadata el mapa
		

	} 
	
	
}
