package DataManager;

import Entity.Party;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;
import org.bson.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;


//CLASS FOR LOADING A SAVED GAME
public class MongoLoader extends MongoTool {

    public MongoLoader(){

    }

    public Party loadGame(){

        //RETRIEVE THE SAVED GAME
        Document doc = collection.findOneAndDelete(new Document());

        String parseable = doc.toJson();

        //MAKING THIS UP AS I GO ALONG

        try {
            Object partyOBJ = new JSONParser().parse(parseable);

            JSONObject partyJSON = (JSONObject) partyOBJ;

            int money = Integer.parseInt((String) partyJSON.get("money"));
            JSONArray inventory = (JSONArray) partyJSON.get("inventory");   //ITEMS: HEALTH POTION NOT SHIT ELSE MAY NEED TO CYCLE THROUGH AS MAP USING KEY VALUES
            JSONArray team = (JSONArray) partyJSON.get("party");    //MAY NEED TO USE KEY VALUES HERE AS WELL


        }catch(Exception e){
            System.out.println(e);
            System.exit(1);
        }




        Party history = new Party();

        return history;
    }
}
