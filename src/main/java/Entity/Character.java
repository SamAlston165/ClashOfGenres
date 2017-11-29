package Entity;


public class Character {
    //no magic numbers
    private static final int death = 0;

    private String race;
    private int max_hp;
    private int current_hp;
    private int lvl;
    private int attack;
    private int defense;
    private Weapons weapon;
    private int movement;
    private int attackRange;
    private int avalible; // each place can be a different check  1's 10's etc

    //makes empty character
    public Character(){

    }


    public Character(String r, String ct){

    }

    //get avalible actions for character
    public int getAvalible(){
        return avalible;
    }

    public void setAvalible(int a){
        avalible = a;
        return;
    }

    //get movement for character
    public int getMovement(){
        return movement;
    }

    //get attack range
    public int getAttackRange(){
        return attackRange;
    }

    //change health (attacked'-' or healed'+')
    public void changeHealth(int num){
        current_hp = current_hp + num;
        //check if dead
        if(current_hp<=death){
            setAvalible(death);
            return;
        }
        //prevent hp going above max
        else if(current_hp>max_hp){
            current_hp = max_hp;
            return;
        }
        return;
    }

}
