package bd;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.model.Updates;

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
	
	
	/**
	 * Transforma el campo y el valor en una consulta
	 * @param campo
	 * @param valor
	 * @return
	 */
	public MongoCursor<Document> leerInstrumento(String campo, Object valor) {
		MongoCursor<Document> cursor = coleccion.find(eq(campo, valor)).iterator();
		System.out.println(valor);
		return cursor;
	}
	
	public Document leerUnoInstrumento(String campo, Object valor) {
	    MongoCursor<Document> cursor = coleccion.find(eq(campo, valor)).limit(1).iterator();
	    
	    Document resultado = null;
	    
	    try {
	        if (cursor.hasNext()) {
	            resultado = cursor.next();
	        }
	    } finally {
	        cursor.close();
	    }

	    return resultado;
	}
	
	
	
	/**
	 * Modifica un documento en relacion a la condicion campo - valor
	 * @param clave
	 * @param valor
	 * @param campoAModificar
	 * @param nuevoValor
	 * @return
	 */
    public UpdateResult modificarInstrumento(String clave, Object valor, String campoAModificar, Object nuevoValor) {
        Bson filtro = eq(clave, valor);
        Bson actualizacion = Updates.set(campoAModificar, nuevoValor);
        return coleccion.updateOne(filtro, actualizacion);
    }
	
	/**
	 * Elimina un documento que cumpla la condicion campo - valor 
	 * @param campo
	 * @param valor
	 * @return
	 */
	public DeleteResult eliminarInstrumento(String campo, Object valor) {
	    Bson filtro = Filters.eq(campo, valor);
	    DeleteResult resultado = coleccion.deleteOne(filtro);
	    return resultado;
	}

	/**
	 * Elimina todos los documentos que cumplan la condicion campo - valor 
	 * @param campo
	 * @param valor
	 * @return
	 */
	public DeleteResult eliminarVariosInstrumentos(String campo, Object valor) {
	    Bson filtro = Filters.eq(campo, valor);
	    DeleteResult resultado = coleccion.deleteMany(filtro);
	    return resultado;
	}
}
