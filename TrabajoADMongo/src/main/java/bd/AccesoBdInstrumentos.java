package bd;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AccesoBdInstrumentos {
	
	
	private MongoCollection<Document> coleccion;
	
	
	public AccesoBdInstrumentos(MongoCollection<Document> coleccion) {
		this.coleccion = coleccion;
	}
	
	/**
	 * Inserta un instrumento
	 * @param documento
	 */
	public void addInstrumento(Document documento) {
		coleccion.insertOne(documento);
		
	}

}
