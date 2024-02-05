package view;

import controller.Main;
import librerias.IO;

public class Vista_Instrumentos {

	
	/**
	 * Imprime un menú general con CRUD
	 */
	public void menuGeneral() {
		IO.println("1. Add Instrumento\n"
				+ "2. Buscar Instrumento\n"
				+ "3. Modificar instrumento existente\n"
				+ "4. Eliminar instrumento\n");
	}
	
	/**
	 * Imprime un menú con los datos a añadir
	 */
	public void menuAdd() {
		IO.println("Introduce los campos deseados. Pulsa -1 para guardar el instrumento y salir al menu principal o -2 para salir sin guardar\n"+
				"1. Nombre\n" +
				"2. Familia\n" +
				"3. Año de fabricación\n" +
				"4. Fabricante\n" +
				"5. Precio\n" +
				"6. Elemento necesario para tocar\n" +
				"7. Arista\n" +
				"8. Tonalidad\n" +
				"9. Número de cuerdas\n" +
				"10. Número de teclas\n" +
				"11. Número de tambores\n" +
				"12. Número de pedales\n" +
				"13. Material\n" +
				"14. Clasificación\n" +
				"15. Salida\n" +
				"-1. Guardar y salir al menú principal\n" +
				"-2. Salir sin guardar al menú principal\n");
	}
	
	/**
	 * Imprime que el input del usuario no es válido
	 */
	public void opcionNoVálida() {
		IO.println("Opción no válida!");
	}
	
	/**
	 * Imprime que falta un elemento
	 */
	public void faltaElemento() {
		IO.println("Falta uno o varios elementos para guardar el instrumento");
	}
	
	/**
	 * Imprime las opciones a la hora de escribir el nombre
	 */
	public void escribirNombre() {
		if(Main.nombre != null) {
			IO.println("El nombre actual es: " + Main.nombre + "Introduzca uno nuevo para cambiarlo o -1 para volver al menú anterior");
		}else {
			IO.println("Introduzca el nombre");
		}
		
	}
	
	/**
	 * Imprime las opciones a la hora de escribir la familia
	 */
	public void escribirFamilia() {
		if(Main.familia != null ) {
			IO.println("La familia actual es: " + Main.familia + "Introduzca una nueva para cambiarla o -1 para volver al menú anterior");
		}else {
			IO.println("Introduzca la familia");
		}
		
	}
	
	/**
	 * Imprime las opciones a la hora de escribir el año de fabricación
	 */
	public void escribirAgnoFabricacion() {
		if(Main.productionYear != null ) {
			IO.println("El año de fabricación actual es: " + Main.productionYear + "Introduzca uno nuevo para cambiarlo o -1 para volver al menú anterior");
		}else {
			IO.println("Introduzca el nombre");
		}
		
	}
	
	/**
	 * Imprime las opciones a la hora de escribir el fabricante
	 */
	public void escribirFabricante() {
		if(Main.fabricante != null ) {
			IO.println("El fabricante actual es: " + Main.fabricante + "Introduzca uno nuevo para cambiarlo o -1 para volver al menú anterior");
		}else {
			IO.println("Introduzca el fabricante");
		}
		
	}
	
	/**
	 * Imprime las opciones a la hora de escribir el precio
	 */
	public void escribirPrecio() {
		if(Main.precio != null ) {
			IO.println("El precio actual es: " + Main.precio + "Introduzca uno nuevo para cambiarlo o -1 para volver al menú anterior");
		}else {
			IO.println("Introduzca el precio");
		}
		
	}
	
	/**
	 * Imprime las opciones a la hora de escribir el elemento necesario para tocar
	 */
	public void escribirElementoTocar() {
		if(Main.AccesorioInstrumental != null) {
			IO.println("El elemento necesario para tocar el instrumento actual es: " + Main.AccesorioInstrumental + "Introduzca uno nuevo para cambiarlo o -1 para volver al menú anterior");
		}else {
			IO.println("Introduzca el elemento necesario para tocar");
		}
		
	}
}
