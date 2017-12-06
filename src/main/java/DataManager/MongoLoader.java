package DataManager;

import Entity.Party;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;


//CLASS FOR LOADING A SAVED GAME
public class MongoLoader extends MongoTool {

    public MongoLoader(){

    }

    public Party loadGame(){

        FindIterable<Document> doc = collection.find();




        return history;
    }
}
