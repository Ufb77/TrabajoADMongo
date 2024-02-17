package controller;

import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import bd.AccesoBdInstrumentos;
import connection.MongoDB;
import view.VtnPrincipal;

public class Main {

	public static String nombre, familia, fabricante, accesorioInstrumental, material, tonalidad, formato, conexion;
	public static Integer productionYear, numCuerdas, numTeclas, numTambores, numPedales;
	public static Double precio, rating;

	static MongoClient mongoClient = MongoDB.getClient();
	static MongoDatabase database = mongoClient.getDatabase("EjMongo"); 
	static MongoCollection<Document> collection = database.getCollection("Instrumentos"); 

	static AccesoBdInstrumentos accessDB = new AccesoBdInstrumentos(collection); 
	static Document documentoBD = new Document(); 
	static Document salidaBD = new Document(); 

	/**
	 * Imprime de forma legible el json
	 * 
	 * @param json
	 * @return
	 */
	public static String pretty(String json) {
		JsonElement je = JsonParser.parseString(json);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(je);
	}

	public static void main(String[] args) {
		new VtnPrincipal().setVisible(true);
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param nombre
	 */
	public static void obtenerNombre(String nombre) {
		Main.nombre = nombre;
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param familia
	 */
	public static void obtenerFamilia(String familia) {

		Main.familia = familia;
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param fabricante
	 */
	public static void obtenerFabricante(String fabricante) {

		Main.fabricante = fabricante;
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param accesorio
	 */
	public static void obtenerAccesorioTocar(String accesorio) {

		Main.accesorioInstrumental = accesorio;
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param material
	 */
	public static void obtenerMaterial(String material) {

		Main.material = material;
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param tonalidad
	 */
	public static void obtenerTonalidad(String tonalidad) {

		Main.tonalidad = tonalidad;
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param agnoFabricancion
	 */
	public static void obtenerAgnoFabricacion(String agnoFabricancion) {

		Main.productionYear = Integer.parseInt(agnoFabricancion);
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param cuerdas
	 */
	public static void obtenerNumCuerdas(String cuerdas) {

		Main.numCuerdas = Integer.parseInt(cuerdas);
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param teclas
	 */
	public static void obtenerNumTeclas(String teclas) {

		Main.numTeclas = Integer.parseInt(teclas);
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param pedales
	 */
	public static void obtenerNumPedales(String pedales) {

		Main.numPedales = Integer.parseInt(pedales);
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param tambores
	 */
	public static void obtenerNumTambores(String tambores) {

		Main.numTambores = Integer.parseInt(tambores);
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param precio
	 */
	public static void obtenerPrecio(String precio) {

		Main.precio = Double.parseDouble(precio);

	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param clasificacion
	 */
	public static void obtenerClasificacion(String clasificacion) {

		Main.rating = Double.parseDouble(clasificacion);
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param formato
	 */
	public static void obtenerFormato(String formato) {

		Main.formato = formato;
	}

	/**
	 * Método auxiliar que reocoge los datos para enviarlos a la vista y añadirlos a la colección
	 * @param conexion
	 */
	public static void obtenerConexion(String conexion) {

		Main.conexion = conexion;
	}

	/**
	 * Crea la consulta que genera la vista y la manda al DAO
	 * @param clave
	 * @param valor
	 * @return el texto a escribir en la ventana de resultados
	 */
	
	public static String obtenerConsulta(String clave, String valor) {
	    StringBuilder texto = new StringBuilder();

	    try {
	        if (isInteger(valor)) {
	            // Para búsqueda de tipo Integer
	            Integer valorInteger = Integer.parseInt(valor);
	            MongoCursor<Document> cursor = accessDB.leerInstrumento(clave, valorInteger);

	            while (cursor.hasNext()) {
	                texto.append(pretty(cursor.next().toJson()));
	            }

	            cursor.close();
	        } else if (isDouble(valor)) {
	            // Para búsqueda de tipo Double
	            Double valorDouble = Double.parseDouble(valor);
	            MongoCursor<Document> cursor = accessDB.leerInstrumento(clave, valorDouble);

	            while (cursor.hasNext()) {
	                texto.append(pretty(cursor.next().toJson()));
	            }

	            cursor.close();
	        } else {
	            // Para búsqueda de tipo String
	            MongoCursor<Document> cursor = accessDB.leerInstrumento(clave, valor);

	            while (cursor.hasNext()) {
	                texto.append(pretty(cursor.next().toJson()));
	            }

	            cursor.close();
	        }
	    } catch (Exception e) {
	        texto.append("Error al realizar la consulta: " + e.getMessage());
	    }

	    return texto.toString();
	}

	/**
	 * Método que elimina un elemento de la colección al cumplir la condición campo - valor
	 * @param campo
	 * @param valor
	 * @return el resultado de la acción
	 */
	public static String deleteInstrument(String campo, String valor) {
	    String resultado;

	    try {
	        DeleteResult result;

	        if (isInteger(valor)) {
	            Integer valorInteger = Integer.valueOf(valor);
	            result = accessDB.eliminarInstrumento(campo, valorInteger);
	        } else if (isDouble(valor)) {
	            Double valorDouble = Double.valueOf(valor);
	            result = accessDB.eliminarInstrumento(campo, valorDouble);
	        } else {
	            result = accessDB.eliminarInstrumento(campo, valor);
	        }

	        if (result.wasAcknowledged() && result.getDeletedCount() > 0) {
	            resultado = "Instrumento eliminado con éxito";
	        } else {
	            resultado = "No se ha eliminado ningún instrumento";
	        }
	    } catch (NumberFormatException e) {
	        resultado = "Error: El valor no es un número válido";
	    }

	    return resultado;
	}

	/**
	 * Método que elimina todos los elementos de la colección al cumplir la condicion campo - valor 
	 * @param campo
	 * @param valor
	 * @return el resultado de la acción
	 */
	public static String deleteManyInstruments(String campo, String valor) {
	    String resultado;
	    DeleteResult result;

	    try {
	        if (isInteger(valor)) {
	            Integer valorInteger = Integer.valueOf(valor);
	            result = accessDB.eliminarVariosInstrumentos(campo, valorInteger);
	        } else if (isDouble(valor)) {
	            Double valorDouble = Double.valueOf(valor);
	            result = accessDB.eliminarVariosInstrumentos(campo, valorDouble);
	        } else {
	            result = accessDB.eliminarVariosInstrumentos(campo, valor);
	        }

	        if (result.wasAcknowledged() && result.getDeletedCount() > 0) {
	            resultado = "Instrumento borrado con éxito";
	        } else {
	            resultado = "No se ha borrado ningún instrumento";
	        }
	    } catch (NumberFormatException e) {
	        resultado = "Error: El valor no es un número válido";
	    }

	    return resultado;
	}
	
	/**
	 * Metodo que modifica un elemento del documento recogido de la coleccion 
	 * @param clave
	 * @param valorActual
	 * @param nuevoValor
	 * @return el resultado de la acción
	 */
	public static String modifyOne(String clave, String valorActual, String nuevoValor) {
	    String resultado;

	    try {
	        Object valorActualConvertido;
	        Object nuevoValorConvertido;

	        if (isInteger(valorActual)) {
	            valorActualConvertido = Integer.parseInt(valorActual);
	        } else if (isDouble(valorActual)) {
	            valorActualConvertido = Double.parseDouble(valorActual);
	        } else {
	            valorActualConvertido = valorActual;
	        }

	        if (isInteger(nuevoValor)) {
	            nuevoValorConvertido = Integer.parseInt(nuevoValor);
	        } else if (isDouble(nuevoValor)) {
	            nuevoValorConvertido = Double.parseDouble(nuevoValor);
	        } else {
	            nuevoValorConvertido = nuevoValor;
	        }

	        UpdateResult result = accessDB.modificarInstrumento(clave, valorActualConvertido, clave, nuevoValorConvertido);

	        if (result.wasAcknowledged() && result.getModifiedCount() > 0) {
	            resultado = "La modificación ha sido exitosa";
	        } else {
	            resultado = "La modificación ha sido imposible de realizar";
	        }
	    } catch (Exception e) {
	        resultado = "Error durante la modificación: " + e.getMessage();
	    }

	    return resultado;
	}
	
	/**
	 * Método auxiliar para verificar si una cadena representa un número entero
	 * @param str
	 * @return
	 */
	private static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Método auxiliar para verificar si una cadena representa un número decima (double)
	 * @param str
	 * @return
	 */
	private static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}




	/**
	 * Método que manda al DAO los datos a escribir y limpia todo tras hacerlo.
	 */
	public static void addDocument() {

		toDocument();
		accessDB.addInstrumento(documentoBD);
		limpiarCampos();
		documentoBD.clear();
		salidaBD.clear();
	}

	/**
	 * Método que crea el documento a escribir en la base de datos
	 */
	private static void toDocument() {
		if (Main.nombre != null && !Main.nombre.isEmpty() && Main.familia != null && !Main.familia.isEmpty()
				&& Main.fabricante != null && !Main.fabricante.isEmpty() && Main.precio != null) {
			documentoBD.append("Nombre", Main.nombre).append("Familia", Main.familia)
					.append("Fabricante", Main.fabricante).append("Precio", Main.precio);
		} else {
			System.out.println("No se pueden añadir datos con campos vacíos");
			documentoBD.remove("_id");
			return;
		}

		if (tonalidad != null) {
			documentoBD.append("Tonalidad", Main.tonalidad);
		}

		if (numCuerdas != null) {
			documentoBD.append("Número de cuerdas", Main.numCuerdas);
		}

		if (numTambores != null) {
			documentoBD.append("Número de tambores", Main.numTambores);
		}

		if (numTeclas != null) {
			documentoBD.append("Número de teclas", Main.numTeclas);
		}

		if (numPedales != null) {
			documentoBD.append("Número de pedales", Main.numPedales);
		}

		if (material != null) {
			documentoBD.append("Material", Main.material);
		}

		if (rating != null) {
			documentoBD.append("Clasificación", Main.rating);
		}

		if (accesorioInstrumental != null) {
			documentoBD.append("Accesorio para tocar", Main.accesorioInstrumental);
		}

		if (formato != null && conexion != null) {
			documentoBD.append("Salida", new Document("Formato", Main.formato).append("Conexion", Main.conexion));
		} else if (formato == null) {
			documentoBD.append("Salida", new Document("Conexion", Main.conexion));
		} else if (conexion == null) {
			documentoBD.append("Salida", new Document("Formato", Main.formato));
		}
	}

	/**
	 * Método que limpia las variables
	 */
	public static void limpiarCampos() {

		ArrayList<Object> lista = new ArrayList<>();

		lista.add(nombre);
		lista.add(familia);
		lista.add(fabricante);
		lista.add(accesorioInstrumental);
		lista.add(material);
		lista.add(tonalidad);
		lista.add(formato);
		lista.add(conexion);
		lista.add(productionYear);
		lista.add(numCuerdas);
		lista.add(numTeclas);
		lista.add(numTambores);
		lista.add(numPedales);
		lista.add(precio);
		lista.add(rating);

		for (Object object : lista) {
			object = null;
		}
	}
}
