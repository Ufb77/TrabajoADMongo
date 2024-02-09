package controller;

import org.bson.Document;
import static com.mongodb.client.model.Filters.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import bd.AccesoBdInstrumentos;
import connection.MongoDB;
import librerias.IO;
import view.CrearGeneral;
import view.Vista_Instrumentos;

public class Main {

	// Para mostrar
	public static String nombre, familia, fabricante, AccesorioInstrumental, material, tonalidad;
	public static Integer productionYear, numCuerdas, numTeclas, numTambores, numPedales;
	public static Double precio, rating;

//	static Vista_Instrumentos vi = new Vista_Instrumentos(); // Para usar la vista

	static int opcion = 0;

	static Document documentoBD = new Document(); // Documento a escribir

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

		CrearGeneral vcg = new CrearGeneral();
		
		vcg.setVisible(true);
		
		
	}

	public static void obtenerNombre(String nombre) {

		Main.nombre = nombre;
	}

	public static void obtenerFamilia(String familia) {

		Main.familia = familia;
	}

	public static void obtenerFabricante(String fabricante) {

		Main.fabricante = fabricante;
	}

	public static void obtenerAccesorioTocar(String accesorio) {

		Main.AccesorioInstrumental = accesorio;
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

	public static void obtenerTambores(String tambores) {

		Main.numTambores = Integer.parseInt(tambores);
	}

	public static void obtenerPrecio(String precio) {

		Main.precio = Double.parseDouble(precio);
	}

	public static void obtenerClasificacion(String clasificacion) {

		Main.rating = Double.parseDouble(clasificacion);
	}
	
	public static void addDocument() {
		
		
		//Buscar forma de hacer esto una sola vez!
		// Establece la conexion a la BD
				MongoClient mongoClient = MongoDB.getClient();
				MongoDatabase database = mongoClient.getDatabase("EjMongo"); // NOMBRE DE LA BD
				MongoCollection<Document> collection = database.getCollection("Instrumentos"); // NOMBRE DE LA COLECCION
				AccesoBdInstrumentos bd = new AccesoBdInstrumentos(collection); // Instancia del acceso a datos
				
				
				
				
				
				documentoBD.put("Nombre: ", Main.nombre);
				documentoBD.put("Familia: ", Main.familia);
				documentoBD.put("Fabricante: ", Main.fabricante);
				documentoBD.put("Precio: ", Main.precio);
				bd.addInstrumento(documentoBD);
				documentoBD.clear();
	}

//	/**
//	 * Opciones CRUD
//	 * @param bd
//	 */
//	public static void menuPpal(AccesoBdInstrumentos bd) {
//		vi.menuGeneral();
//		opcion = IO.readInt();
//
//		while (opcion != -1) {
//
//			switch (opcion) {
//			case 1:
//				menuAdd(bd);
//				vi.menuGeneral();
//				opcion = IO.readInt();
//				break;
//			case 2:
//				break;
//			case 3:
//				break;
//			case 4:
//				break;
//			default:
//				vi.opcionNoVálida();
//				break;
//			}
//		}
//
//	}
//
//	/**
//	 * Opciones a la hora de añadir un instrumento. Funciona mal revisar
//	 * @param bd
//	 */
//	public static void menuAdd(AccesoBdInstrumentos bd) {
//		vi.menuAdd();
//		opcion = IO.readInt();
//
//		while (opcion != -1 || opcion != -2) {
//
//			switch (opcion) {
//
//			case 1:
//				vi.escribirNombre();
//				nombre = IO.readString();
//				documentoBD.put("Nombre", nombre); // put en vez de append porque sustituye si se encuentra en el
//													// documento y no se van a hacer varios seguidos
//				break;
//			case 2:
//				vi.escribirFamilia();
//				familia = IO.readString();
//				documentoBD.put("Familia", familia);
//				break;
//			case 3:
//				vi.escribirAgnoFabricacion();
//				productionYear = IO.readInt();
//				documentoBD.put("Anyo fabricacion", productionYear);
//				break;
//			case 4:
//				vi.escribirFabricante();
//				fabricante = IO.readString();
//				documentoBD.put("Fabricante", fabricante);
//				break;
//			case 5:
//				vi.escribirPrecio();
//				precio = IO.readDouble();
//				documentoBD.put("Precio", precio);
//				break;
//			case 6:
//				vi.escribirElementoTocar();
//				AccesorioInstrumental = IO.readString();
//				documentoBD.put("Elemento para tocar", AccesorioInstrumental);
//				break;
//			case 7:
//				break;
//			case 8:
//				break;
//			case 9:
//				break;
//			case 10:
//				break;
//			case 11:
//				break;
//			case 12:
//				break;
//			case 13:
//				break;
//			case 14:
//				break;
//			case 15:
//				break;
//			case -1:
//				// Guarda el documento en la bd. Revisa que tenga lo mínimo imprescindible (los atributos generales)
//
//				if (documentoBD.containsKey("Nombre") && documentoBD.containsKey("Familia")
//						&& documentoBD.containsKey("Anyo fabricacion") && documentoBD.containsKey("Fabricante")
//						&& documentoBD.containsKey("Precio") && documentoBD.containsKey("Elemento para tocar")) {
//
//					bd.addInstrumento(documentoBD);
//					break;
//
//				} else {
//					vi.faltaElemento();
//				}
//				break;
//			case -2:
//				// Sale sin guardar
//				break;
//			default:
//				vi.opcionNoVálida();
//				break;
//
//			}
//
//			//Modificar esto para usar un do while
//			vi.menuAdd();
//			opcion = IO.readInt();
//
//		}
//
//	}

}
