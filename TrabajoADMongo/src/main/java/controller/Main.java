package controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import bd.AccesoBdInstrumentos;
import connection.MongoDB;
import view.VtnPrincipal;

public class Main {

	// Para mostrar
	public static String nombre, familia, fabricante, accesorioInstrumental, material, tonalidad, formato, conexion;
	public static Integer productionYear, numCuerdas, numTeclas, numTambores, numPedales;
	public static Double precio, rating;

//	static Vista_Instrumentos vi = new Vista_Instrumentos(); // Para usar la vista

	// Buscar forma de hacer esto una sola vez sin static!
	// Establece la conexion a la BD
	static MongoClient mongoClient = MongoDB.getClient();
	static MongoDatabase database = mongoClient.getDatabase("EjMongo"); // NOMBRE DE LA BD
	static MongoCollection<Document> collection = database.getCollection("Instrumentos"); // NOMBRE DE LA COLECCION
	static AccesoBdInstrumentos accessDB = new AccesoBdInstrumentos(collection); // Instancia del acceso a datos

//	static int opcion = 0;

	static Document documentoBD = new Document(); // Documento a escribir
	static Document salidaBD = new Document(); // Documento para crear la salida{formato, conexion}

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

//		menuPpal(bd);

		new VtnPrincipal().setVisible(true);

	}

	public static void obtenerNombre(String nombre) {
		// Validar el nombre con la expresión regular
		String regex = "[\\p{L}&&[^\u2000-\u206F\u2E00-\u2E7F\\s]]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nombre);

		if (matcher.matches() && nombre != null) {
			// El nombre cumple con la expresión regular, puedes guardarlo
			Main.nombre = nombre;
			System.out.println("Nombre válido: " + nombre);
		} else {
			// El nombre no cumple con la expresión regular, puedes manejarlo de alguna
			// manera
			System.out.println("Nombre no válido: " + nombre);
		}
	}

	public static void obtenerFamilia(String familia) {

		Main.familia = familia;
	}

	public static void obtenerFabricante(String fabricante) {

		Main.fabricante = fabricante;
	}

	public static void obtenerAccesorioTocar(String accesorio) {

		Main.accesorioInstrumental = accesorio;
	}

	public static void obtenerMaterial(String material) {

		Main.material = material;
	}

	public static void obtenerTonalidad(String tonalidad) {

		Main.tonalidad = tonalidad;
	}

	public static void obtenerAgnoFabricacion(String agnoFabricancion) {

		Main.productionYear = Integer.parseInt(agnoFabricancion);
	}

	public static void obtenerNumCuerdas(String cuerdas) {

		Main.numCuerdas = Integer.parseInt(cuerdas);
	}

	public static void obtenerNumTeclas(String teclas) {

		Main.numTeclas = Integer.parseInt(teclas);
	}

	public static void obtenerNumPedales(String pedales) {

		Main.numPedales = Integer.parseInt(pedales);
	}

	public static void obtenerNumTambores(String tambores) {

		Main.numTambores = Integer.parseInt(tambores);
	}

	public static void obtenerPrecio(String precio) {

		Main.precio = Double.parseDouble(precio);

	}

	public static void obtenerClasificacion(String clasificacion) {

		Main.rating = Double.parseDouble(clasificacion);
	}

	public static void obtenerFormato(String formato) {

		Main.formato = formato;
	}

	public static void obtenerConexion(String conexion) {

		Main.conexion = conexion;
	}

	/**
	 * Crea la consulta que genera la vista y la mandao al dao
	 * 
	 * @param clave
	 * @param valor
	 * @return el texto a escribir en la ventana de resultados
	 */
	// 1 - ¿PASAR TODOS LOS DATOS A STRING?
	public static String obtenerConsulta(String clave, Object valor) {
		StringBuilder texto = new StringBuilder();
		MongoCursor<Document> cursor = accessDB.leerInstrumento(clave, valor);

		while (cursor.hasNext()) {
			texto.append(pretty(cursor.next().toJson()));
		}

		cursor.close();
		return texto.toString();
	}

	public static String deleteInstrument(String clave, Object valor) {
		String resultado;
		DeleteResult result = accessDB.eliminarInstrumento(clave, valor);
		if (result.wasAcknowledged() && result.getDeletedCount() > 0) {
			resultado = "Instrumento borrado con exito";
			return resultado;
		} else {
			resultado = "No se ha borrado ningun instrumento";
			return resultado;
		}
	}

	public static String deleteManyInstruments(String campo, String valor) {
		String resultado;
		DeleteResult result;
		Double valorDouble;
		Integer valorInteger;

		if (campo.equalsIgnoreCase("Precio") || campo.equalsIgnoreCase("Número de cuerdas")
				|| campo.equalsIgnoreCase("Número de teclas") || campo.equalsIgnoreCase("Número de tambores") ||

				campo.equalsIgnoreCase("Número de pedales")) {

			valorInteger = Integer.valueOf(valor);

			result = accessDB.eliminarVariosInstrumentos(campo, valorInteger);

		} else if (campo.equalsIgnoreCase("Precio") || campo.equalsIgnoreCase("Clasificación")) {

			valorDouble = Double.valueOf(valor);

			result = accessDB.eliminarVariosInstrumentos(campo, valorDouble);

		} else {

			result = accessDB.eliminarVariosInstrumentos(campo, valor);

		}
		if (result.wasAcknowledged() && result.getDeletedCount() > 0) {
			resultado = "Instrumento borrado con exito";
			return resultado;
		} else {
			resultado = "No se ha borrado ningun instrumento";
			return resultado;
		}
	}

//	public static void modificarDocumento(String clave, Object valorActual, Object valorNuevo) {
//		Document docActualizar = accessDB.leerUnoInstrumento(clave, valorActual);
//		//VAS A LA VTN BUSCAR AL METODO QUE ABRE ABRE LA VENTANA A PARTIR DEL IF DE MODIFICAR
//		System.out.println("Entrando en el método...");
//		System.out.println(valorNuevo);
//		if(docActualizar != null) {  // Cambiado de == a !=
//			System.out.println("Se comprueba que no está vacío");
//			
//			Document updateDocument = new Document("$set", new Document(clave, valorNuevo));  // Usar $set para actualizar
//			
//			System.out.println("Se crea el nuevo documento");
//			
//			//ESTA ACCION QUE PUSISTE ES COSA DEL DAO Y LO QUE HE HECHO HA SIDO PASARLA AL DAO NADA MAS :))
//			
//			
//			System.out.println("Actualizado");
//		} else {
//			System.err.println("Error, documento no encontrado para actualización.");
//		}
//	}

	public static String modifyOne(String clave, Object valorActual, Object valorNuevo) {
		String resultado;
		UpdateResult result = accessDB.modificarInstrumento(clave, valorActual, clave, valorNuevo);

		if (result.wasAcknowledged() && result.getModifiedCount() > 0) {
			resultado = "La modificación ha sido exitosa";
			return resultado;
		} else {
			resultado = "La modificacion ha sido imposible de realizar";
			return resultado;
		}
	}

	/**
	 * Manda al dao los datos a escribir y limpia todo tras hacerlo.
	 */
	public static void addDocument() {

		toDocument();
		accessDB.addInstrumento(documentoBD);
		limpiarCampos();
		documentoBD.clear();
		salidaBD.clear();
	}

	/**
	 * Crea el documento a escribir en la base de datos
	 */
	private static void toDocument() {
		if (Main.nombre != null && !Main.nombre.isEmpty() && Main.familia != null && !Main.familia.isEmpty()
				&& Main.fabricante != null && !Main.fabricante.isEmpty() && Main.precio != null) {
			// Realizar la inserción en la base de datos solo si todas las variables no
			// están vacías
			documentoBD.append("Nombre", Main.nombre).append("Familia", Main.familia)
					.append("Fabricante", Main.fabricante).append("Precio", Main.precio);
		} else {
			// Manejar el caso en el que alguna variable está vacía
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
	 * Limpia las variables
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
