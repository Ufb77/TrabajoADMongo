package models;

import lombok.*;

@AllArgsConstructor
@Data

public class Instruments {
	
	String nombre ,familia, fabricante, AccesorioInstrumental, material, tonalidad;
	Integer productionYear, numCuerdas, numTeclas, numTambores, numPedales;
	Double precio, rating;
	

}



