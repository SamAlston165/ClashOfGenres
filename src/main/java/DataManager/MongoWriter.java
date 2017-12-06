package DataManager;

import Entity.Party;
import com.mongodb.*;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

//CLASS FOR SAVING A GAME STATE
public class MongoWriter extends MongoTool {


    //CONSTRUCTOR CONNECTS TO THE DATABASE AND APPROPRIATE CONNECTION
    public MongoWriter(){

    }

    //SAVE THE DOCUMENT TO THE COLLECTION
    public void saveGame(Party activeGroup){

        //TURN PARTY OBJECT INTO A MONGO DOCUMENT
        Document gameToSave = createSave(activeGroup);

        //SAVE THE GAME
        super.collection.insertOne(gameToSave);

    }

}
