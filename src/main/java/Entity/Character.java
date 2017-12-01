package Entity;


public class Character {
    //no magic numbers
    private static final int death = 0;
    private static final int baseHealth = 100;
    private static final int baseLvlAndRange = 1;
    private static final int baseAttack = 4;
    private static final int baseDefenseAndMovement = 2;
    private static final int startTurn = 111;

    private String race;
    private int max_hp;
    private int current_hp;
    private int lvl;
    private int attack;
    private int defense;
    private Weapons weapon;
    private Equipment arrmor;
    private int movement;
    private int attackRange;
    private int avalible; // each place can be a different check  1's 10's etc

    //makes base character without a race
    public Character(){
        max_hp = baseHealth;
        current_hp = max_hp;
        lvl = 1;
        attack = baseAttack;
        defense = baseDefenseAndMovement;
        movement = baseDefenseAndMovement;
        attackRange = baseLvlAndRange;
        avalible = startTurn;
    }

    //makes base character with race
    public Character(String r){
        race = r;
        max_hp = baseHealth;
        current_hp = max_hp;
        lvl = 1;
        attack = baseAttack;
        defense = baseDefenseAndMovement;
        movement = baseDefenseAndMovement;
        attackRange = baseLvlAndRange;
        avalible = startTurn;


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
