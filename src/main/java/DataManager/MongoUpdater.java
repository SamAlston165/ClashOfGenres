package DataManager;

import Entity.Party;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import com.mongodb.client.MongoCollection;

import java.util.Iterator;

public class MongoUpdater extends MongoTool {

    public MongoUpdater(){

    }

    public void update(Party activeGroup){

        //DELETE THE PREVIOUS GAME STATE (EASIEST WAY TO DO THIS)
        FindIterable<Document> oldGame = super.collection.find();

        Iterator it = oldGame.iterator();

        super.collection.deleteOne(it.next());

        //TURN PARTY OBJECT INTO A MONGO DOCUMENT
        Document gameToSave = createSave(activeGroup);

        //SAVE THE GAME
        super.collection.insertOne(gameToSave);


    }


}
