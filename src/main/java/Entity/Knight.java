package Entity;

public class Knight extends Character{

    //Base Health Points Variable
    private static final int knightHealthPointsBase = 150;

    //Base Attack Points Variable
    private static final int knightAttackBase = 10;

    //Base Defense Points Variable
    private static final int knightDefenseBase = 20;

    //Base Movement Points Variable
    private static final int knightMovementBase = 2;

    //Base Attack Range Variable
    private static final int knightAttackRangeBase = 1;


    public Knight()
    {
        setMax_hp(knightHealthPointsBase);
        setCurrent_hp(knightHealthPointsBase);
        setAttack(knightAttackBase);
        setDefense(knightDefenseBase);
        setMovement(knightMovementBase);
        setAttackRange(knightAttackRangeBase);
    }
}
