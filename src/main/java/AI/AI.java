package AI;

import Entity.Character;

import java.util.ArrayList;
import java.util.List;

public class AI {

    private static List<AInfo> info;

    public static void decide(Character enemy, List<Character> targets){
        collect(enemy, targets);
    }


    //FUNCTION TO COLLECT RELEVANT INFO FROM ALL TARGETS
    public static void collect(Character enemy, List<Character> targets){

        info = new ArrayList<AInfo>();
        double distance;
        int threat;
        boolean range;

        //RUN THROUGH EACH USER IN THE TARGET GROUP TO COLLECT RELEVANT INFO
        for(Character target : targets) {
            distance = getDistance(enemy, target);
            range = inRange(enemy, distance);
            threat = determineThreat(enemy, target);

            //ADD ALL INFO TO THE LIST
            info.add(new AInfo(range, threat, distance));

        }


    }

    //FUNCTION FOR CHECKING TARGETS WITHIN ATTACK RANGE
    public static boolean inRange(Character enemy, double distance){
        boolean attackRange = false;
        if(enemy.getAttackRange() < distance)
            attackRange = true;

        return attackRange;

    }

    public static void attack(Character enemy, Character target){

    }

    //FUNCTION FOR CALCULATING DISTANCE BETWEEN ENEMY AND TARGET
    public static double getDistance(Character enemy, Character target){
        double X = Math.pow((enemy.getX() - target.getX()), 2.0);
        double Y = Math.pow((enemy.getY()- target.getY()), 2.0);

        return Math.sqrt(X+Y);
    }

    public static int determineThreat(Character enemy, Character target){
        int threat = 0;

        return threat;

    }


}
