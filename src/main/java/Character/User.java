package Character;

import org.newdawn.slick.*;

public class User extends BasicGame {

    //Animation variable
    private Animation a;

    //Animation x coordinate
    public float x = 194;

    //Animation y coordinate
    public float y = 243;

    //User Image
    private Image i;

    //Default Constructor
    public User() {
        super("");
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public void setX(float x) {
        this.x = (int) x;
    }

    public void setY(float y) {
        this.y = (int) y;
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {

        //User reference
        i = new Image("Res/Animation.png");
        a = getAnimation(i, 7, 4, 130, 150, 27, 100);

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

        if (kbd.isKeyDown(Input.KEY_RIGHT)) {
            x += 1;
        }
        if (kbd.isKeyDown(Input.KEY_DOWN)) {
            y += 1;
        }
        if (kbd.isKeyDown(Input.KEY_UP)) {
            y -= 1;
        }
        if (kbd.isKeyDown(Input.KEY_LEFT)) {
            x -= 1;
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