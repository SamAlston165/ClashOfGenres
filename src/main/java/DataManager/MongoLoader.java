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

        //RETRIEVE THE SAVED GAME
        FindIterable<Document> doc = collection.find();

        /************************************************************************
         *
         * PARSE THE DOCUMENT SOMEHOW INTO A PARTY OBJECT AND RETURN PARTY OBJECT
         *
         ************************************************************************/



        Party history = new Party();

        return history;
    }
}
