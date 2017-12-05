package DataManager;

import Entity.Party;
import com.mongodb.*;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

//public class MongoWriter {
//
//    public MongoWriter(Party activeGroup){
//
//        //GET DATABASE
//        MongoDatabase database = connect();
//
//        //GET SAVED GAMES
//        MongoCollection<Document> collection = database.getCollection("Saved Games");
//
//        //TURN PARTY OBJECT INTO A MONGO DOCUMENT
//        Document gametToSave = createSave(activeGroup);
//
//        //SAVE THE GAME
//        collection.insertOne(gametToSave);
//
//    }
//
//
//    //METHOD FOR CONNECTING TO AND RETURNING A DATABASE
//    public static MongoDatabase connect() {
//
//        MongoDatabase database = null;
//        try {
//            MongoClient mongo = new MongoClient("ds119585.mlab.com", 19585);
//            MongoCredential credential = MongoCredential.createCredential("jayz2053", "test123", "fine832^fluid".toCharArray());
//
//            database = mongo.getDatabase("test123");
//
//
//        } catch (Exception e) {
//            System.out.println("Could not connect to the database");
//            System.exit(1);
//        }
//
//        return database;
//    }
//
////    //METHOD FOR TURNING A PARTY OBJECT INTO A MONGO DOCUMENT
////    public static Document createSave(Party activeParty){
////
////        BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
////        docBuilder.append("Money", activeParty.getMoney());
////        //docBuilder.append("Items", activeParty.);
////
////        return gameState;
////
////    }
//
//
//
//}
