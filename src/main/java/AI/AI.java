package AI;

import Entity.Character;

import java.util.ArrayList;
import java.util.List;


public class AI {
    public static final int BUFFER_SPACE = 10;
    public static final int GRID_SIZE = 40;

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
        int i = 0;
        int x = 0;

        //RUN THROUGH EACH USER IN THE TARGET GROUP TO COLLECT RELEVANT INFO
        for(Character target : targets) {
            distance = getDistance(enemy, target);
            range = inRange(enemy, distance);
            threat = determineThreat(enemy, target);

            //ADD ALL INFO TO THE LIST
            info.add(new AInfo(range, threat, distance));

        }

        //FIND CLOSEST CHAR, BECAUSE AI WAS NEVER FINISHED
        Character finalTar = targets.get(0);
        for(i = 0; i < info.size(); i++)
        {
            if((info.get(i).getDistance() < info.get(x).getDistance()) && !(targets.get(i).getDead()))
            {
                x = i;
                finalTar = targets.get(x);
            }
        }

        moveEnemy(enemy, finalTar, info.get(x));
        if(info.get(x).getRange())
        {
            attack(enemy, finalTar);
        }

    }

    //FUNCTION FOR MOVING ENEMY
    public static void moveEnemy(Character enemy, Character target, AInfo tInfo)
    {
        if(tInfo.getRange())
        {
            if(target.getX() > enemy.getX())
            {
                if(target.getY() > enemy.getY())
                {

                }
                else
                {

                }
            }
            else
            {
                if(target.getY() > enemy.getY())
                {

                }
                else
                {

                }
            }
        }
        else
        {
            if(target.getX() > enemy.getX())
            {
                if(target.getY() > enemy.getY())
                {

                }
                else
                {

                }
            }
            else
            {
                if(target.getY() > enemy.getY())
                {

                }
                else
                {

                }
            }
        }

        enemy.setX((enemy.getX() ));
        enemy.setY((enemy.getY() ));
    }

    //FUNCTION FOR CHECKING TARGETS WITHIN ATTACK RANGE
    public static boolean inRange(Character enemy, double distance){
        boolean attackRange = false;
        if(enemy.getAttackRange() >= distance)
            attackRange = true;

        return attackRange;

    }

    public static void attack(Character enemy, Character target){
        enemy.attackChar(target);

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
