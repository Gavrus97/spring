import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;

public class Application {

    public static void main(String[] args) {

        MongoClient mongoConnection = getMongoConnection();
        MongoDatabase database = mongoConnection.getDatabase("local");
        MongoCollection<Document> music = database.getCollection("music");
        FindIterable<Document> documents = music.find();
        documents.forEach((Block<? super Document> document) -> {
            System.out.println(document);
        } );

        MongoCursor<String> cursor = mongoConnection.listDatabaseNames().iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }

    }

    private static MongoClient getMongoConnection(){
        return new MongoClient();
    }
}
