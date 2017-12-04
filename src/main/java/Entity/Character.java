package Entity;

import org.newdawn.slick.*;

public class Character extends BasicGame {

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
    //Character Image
    private Image i;

    //Default Constructor
    public Character() {
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

        //Character reference
        i = new Image("Res/Mario.png");
        a = getAnimation(i, 20, 20, 20, 20, 27, 100);

        //Gets coordinates of Character
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

        //All Right boundaries
        if (kbd.isKeyDown(Input.KEY_RIGHT)) {

            x += 1;

            //Detects collision on outer bounds
            if(getX() == 585)
            {
                x -= 1;
            }

            //Left fence boundary
            if((getX() == 54 && getY() <= 572) && (getX() == 54 && getY() >= 433))
            {
                x -= 1;
            }

            //Middle fence boundary
            if((getX() == 215 && getY() <= 507) && (getX() == 215 && getY() >= 369))
            {
                x -= 1;
            }


            //Right fence boundary
            if((getX() == 471 && getY() <= 586) && (getX() == 471 && getY() >= 462))
            {
                x -= 1;
            }

            //Left house boundary
            if((getX() == 44 && getY() <= 228) && (getX() == 44 && getY() >= 103))
            {
                x -= 1;
            }

            //Right house boundary
            if((getX() == 394 && getY() <= 228) && (getX() == 394 && getY() >= 105))
            {
                x -= 1;
            }

        }

        //All Bottom boundaries
        if (kbd.isKeyDown(Input.KEY_DOWN)) {

            y += 1;

            //Detects collision on outer bounds
            if(getY() == 587)
            {
                y -= 1;
            }

            //Left fence boundary
            if ((getY() == 427 && getX() <= 179) && (getY() == 427 && getX() >= 60))
            {
                y -=1;
            }

            //Middle fence boundary
            if ((getY() == 360 && getX() <= 436) && (getY() == 360 && getX() >= 221))
            {
                y -=1;
            }

            //Right fence boundary
            if ((getY() == 459 && getX() <= 584) && (getY() == 459 && getX() >= 473))
            {
                y -=1;
            }

            //Left house boundary
            if ((getY() == 42 && getX() <= 194) && (getY() == 42 && getX() >= 42))
            {
                y -=1;
            }

            //Right house boundary
            if ((getY() == 42 && getX() <= 547) && (getY() == 42 && getX() >= 389))
            {
                y -=1;
            }
        }

        //All top boundaries (Right fence does not contain boundaries)
        if (kbd.isKeyDown(Input.KEY_UP)) {

            y -= 1;

            //Detects collision on outer bounds
            if(getY() == 31)
            {
                y += 1;
            }

            //Left fence boundary
            if((getY() == 576 && getX() <= 179) && (getY() == 576 && getX() >= 60))
            {
                y += 1;
            }

            //Middle fence boundary
            if((getY() == 513 && getX() <= 434) && (getY() == 513 && getX() >= 220))
            {
                y += 1;
            }

            //Left house boundary
            if((getY() == 256 && getX() <= 163) && (getY() == 256 && getX() >= 70))
            {
                y += 1;
            }

            //Right house boundary
            if((getY() == 256 && getX() <= 518) && (getY() == 256 && getX() >= 420))
            {
                y += 1;
            }
        }

        //All left boundaries (Right fence does not contain boundaries)
        if (kbd.isKeyDown(Input.KEY_LEFT)) {

            x -= 1;

            //Detects collision on outer bounds
            if(getX() == 33)
            {
                x += 1;
            }

            //Left fence boundary
            if((getX() == 183 && getY() <= 572) && (getX() == 183 && getY() >= 433))
            {
                x +=1;
            }

            //Middle fence boundary
            if((getX() == 440 && getY() <= 505) && (getX() == 440 && getY() >= 368))
            {
                x +=1;
            }

            //Left house boundary
            if((getX() == 191 && getY() <= 230) && (getX() == 191 && getY() >= 106))
            {
                x +=1;
            }

            //Right house boundary
            if((getX() == 543 && getY() <= 230) && (getX() == 543 && getY() >= 106))
            {
                x +=1;
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