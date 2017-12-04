package Entity;

public class Knight extends Character{

    //no magic numbers
    private static final int knightHPBase = 150;
    private static final int knightAttackBase = 10;
    private static final int knightDefenseBase = 20;
    private static final int knightMovementBase = 2;
    private static final int knightRangeBase = 1;


    public Knight(){
        super();
        this.setMax_hp(knightHPBase);
        this.setCurrent_hp(knightHPBase);
        this.setAttack(knightAttackBase);
        this.setDefense(knightDefenseBase);
        this.setMovement(knightMovementBase);
        this.setAttackRange(knightRangeBase);



    }
}
