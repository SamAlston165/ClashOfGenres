package DataManager;

import Entity.Party;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


//MONGOTOOL IS A SUPER CLASS THAT WILL HANDLE CONNECTING TO THE DATABASE AND
//APPROPRIATE COLLECTION ALL OTHER CLASSES INHERIT FROM IT HANDLE CRUD OPERATIONS
public class MongoTool {

    protected MongoDatabase database;
    protected MongoCollection<Document> collection;


    public MongoTool(){
        this.database = connect();
        this.collection = this.database.getCollection("Saved Games");


    }


    //METHOD FOR CONNECTING TO AND RETURNING A DATABASE
    public static MongoDatabase connect() {

        MongoDatabase database = null;
        try {
            MongoClient mongo = new MongoClient("ds119585.mlab.com", 19585);
            MongoCredential credential = MongoCredential.createCredential("jayz2053", "test123", "fine832^fluid".toCharArray());

            database = mongo.getDatabase("test123");


        } catch (Exception e) {
            System.out.println("Could not connect to the database");
            System.exit(1);
        }

        return database;
    }

    //METHOD FOR TURNING A PARTY OBJECT INTO A MONGO DOCUMENT
    public static Document createSave(Party activeParty){

        Document gameState = new Document("game", activeParty);
        return gameState;

    }


    //WORKING ON THIS IN LOADER SOME REFACTORING WILL SURELY BE NEEDED
    public static Party parseDoc(String){

    }


}
