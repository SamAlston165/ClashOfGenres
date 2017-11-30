package Entity;

import org.newdawn.slick.*;

public class User extends BasicGame {

    private static final int death = 0;
    //Animation x coordinate
    public float x = 194;
    //Animation y coordinate
    public float y = 243;
    //private String race;
    //private ClassType classType;
    private int max_hp = 100;
    private int current_hp;
    private int lvl;
    private int maxLvl = 50;
    private int attack;
    private int defense;
    //private Weapons weapon;
    private int movement;
    private int attackRange;
    private int available;
    //Animation variable
    private Animation a;
    //User Image
    private Image i;

    //Default Constructor
    public User() {
        super("");
    }

    public int getX() {
        return (int) x;
    }

    public void setX(float x) {
        this.x = (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public void setY(float y) {
        this.y = (int) y;
    }

    public int getMovement() { return movement; }

    public void setMovement(int movement) { this.movement = movement; }

    public int getAttackRange() { return attackRange; }

    public void setAttackRange(int attackRange) { this.attackRange = attackRange; }

    public int getAvalible() { return available; }

    public void setAvalible(int a) {
        available = a;
        return;
    }

    public int getDefense() { return defense; }

    public void setDefense(int defense) { this.defense = defense; }

    public int getAttack() { return attack; }

    public void setAttack(int attack) { this.attack = attack; }

    public int getMax_hp() { return max_hp; }

    public void setMax_hp(int max_hp) { this.max_hp = max_hp; }

    public int getCurrent_hp() { return current_hp; }

    public void setCurrent_hp(int current_hp) { this.current_hp = current_hp; }

    //change health (attacked'-' or healed'+')
    public void changeHealth(int num) {
        current_hp = current_hp + num;

        //check if dead
        if (current_hp <= death) {
            setAvalible(death);
            return;
        }
        //Prevents hp going above max
        else if (current_hp > max_hp) {
            current_hp = max_hp;
            return;
        }
        return;
    }

    public int getLvl() { return lvl; }

    public void setLvl(int lvl) { this.lvl = lvl; }

    public int getDeath() { return death; }

    public void setDeath(int death) { this.getDeath(); }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        //User reference
        i = new Image("Res/Mario.png");
        a = getAnimation(i, 20, 20, 20, 20, 27, 100);

        //Gets coordinates of User
        x = getX();
        y = getY();
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        //Draws Character
        a.draw(x, y);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

        Input kbd = gameContainer.getInput();

       // System.out.println("X: " + getX() + "Y:" + getY());

        if (kbd.isKeyDown(Input.KEY_RIGHT)) {
            x += 1;

            //Detects collision on outer bounds
            if(getX() == 482)
            {
                x -= 1;
            }
        }

        if (kbd.isKeyDown(Input.KEY_DOWN)) {
            y += 1;

            //Detects collision on outer bounds
            if(getY() == 469)
            {
                y -= 1;
            }
        }

        if (kbd.isKeyDown(Input.KEY_UP)) {
            y -= 1;

            //Detects collision on outer bounds
            if(getY() == 21)
            {
                y += 1;
            }
        }

        if (kbd.isKeyDown(Input.KEY_LEFT)) {
            x -= 1;

            //Detects collision on outer bounds
            if(getX() == 23)
            {
                x += 1;
            }
        }

        a.update(i);
    }

    public Animation getAnimation(Image i, int spritesX, int spritesY, int spriteWidth, int spriteHeight, int frames, int duration) {

        //Creates animation based off location
        Animation a = new Animation(false);

        int c = 0;
        for (int y = 0; y < spritesY; y++) {
            for (int x = 0; x < spritesX; x++) {
                if (c < frames)
                    a.addFrame(i.getSubImage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight), duration);
                c++;
            }
        }
        return a;
    }
}