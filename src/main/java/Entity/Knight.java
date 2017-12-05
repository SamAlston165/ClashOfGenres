package Entity;

public class Knight extends Character{

    //no magic numbers
    private static final int knightHPBase = 150;
    private static final int knightAttackBase = 40;
    private static final int knightMovementBase = 160;
    private static final int knightRangeBase = 40;


    public Knight(){
        super();
        this.setMax_hp(knightHPBase);
        this.setCurrent_hp(knightHPBase);
        this.setAttack(knightAttackBase + 15);
        this.setMovement(knightMovementBase);
        this.setAttackRange(knightRangeBase);
    }
    public Knight(String fof)
    {
        super();
        this.setMax_hp(knightHPBase);
        this.setCurrent_hp(knightHPBase);
        this.setAttack(knightAttackBase);
        this.setMovement(knightMovementBase);
        this.setAttackRange(knightRangeBase);

        if(fof.compareToIgnoreCase("friend") == 0)
        {
            this.setImageString("Res/Fren_Knight.png");
        }
        else
        {
            this.setImageString("Res/Enemy_Knight.png");
        }
    }
}