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


import connection.MongoDB;

public class Main {

	public static String pretty(String json) {
		JsonElement je = JsonParser.parseString(json);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(je);
	}
	
	public static void main(String[] args) {	
		//Establece la conexion a la BD
		MongoClient mongoClient = MongoDB.getClient();
		MongoDatabase database = mongoClient.getDatabase("EjMongo"); //NOMBRE DE LA BD
        MongoCollection<Document> collection = database.getCollection("Instrumentos"); //NOMBRE DE LA COLECCION
        
        //Busqueda de prueba 
        Document doc = collection.find(eq("material", "plastico")).first();
        if (doc == null) {
            System.out.println("No matching documents found.");
        } else {
//        	System.out.println(doc.toJson());
        	System.out.println(pretty(doc.toJson()));            
        }
	}

}

