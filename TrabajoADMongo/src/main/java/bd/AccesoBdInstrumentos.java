package bd;

import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class AccesoBdInstrumentos {

	private MongoCollection<Document> coleccion;

	public AccesoBdInstrumentos(MongoCollection<Document> coleccion) {
		this.coleccion = coleccion;
	}

	/**
	 * Inserta un instrumento
	 * 
	 * @param documento
	 */
	public void addInstrumento(Document documento) {
		coleccion.insertOne(documento);

	}
	
	
	/**
	 * Transforma la clave y el valor en una consulta
	 * @param clave
	 * @param valor
	 * @return
	 */
	public MongoCursor<Document> leerInstrumento(String clave, String valor) {

		MongoCursor<Document> cursor = coleccion.find(eq(clave, valor)).iterator();

		return cursor;
	}

	/**
	 * Transforma la clave y el valor en una consulta
	 * @param clave
	 * @param valor
	 * @return
	 */
	public MongoCursor<Document> leerInstrumento(String clave, Double valor) {

		MongoCursor<Document> cursor = coleccion.find(eq(clave, valor)).iterator();

		return cursor;
	}

	/**
	 * Transforma la clave y el valor en una consulta
	 * @param clave
	 * @param valor
	 * @return
	 */
	public MongoCursor<Document> leerInstrumento(String clave, Integer valor) {

		MongoCursor<Document> cursor = coleccion.find(eq(clave, valor)).iterator();

		return cursor;
	}

}
