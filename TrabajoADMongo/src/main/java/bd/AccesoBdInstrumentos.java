package bd;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

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
	 * @param campo
	 * @param valor
	 * @return
	 */
	public MongoCursor<Document> leerInstrumento(String campo, Object valor) {
		MongoCursor<Document> cursor = coleccion.find(eq(campo, valor)).iterator();
		return cursor;
	}

	/**
	 * Elimina un registro
	 * @param campo
	 * @param valor
	 * @return
	 */
	public DeleteResult eliminarInstrumento(String campo, Object valor) {
	    Bson filtro = Filters.eq(campo, valor);
	    DeleteResult resultado = coleccion.deleteOne(filtro);
	    return resultado;
	}

	public DeleteResult eliminarVariosInstrumentos(String campo, Object valor) {
	    Bson filtro = Filters.eq(campo, valor);
	    DeleteResult resultado = coleccion.deleteMany(filtro);
	    return resultado;
	}
}
