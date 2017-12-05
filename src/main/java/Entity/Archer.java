package Entity;

public class Archer extends Character
{
    //Base Health Points Variable
    private static final int archerHealthPointsBase = 100;

    //Base Attack Points Variable
    private static final int archerAttackBase = 20;

    //Base Defense Points Variable
    private static final int archerDefenseBase = 12;

    //Base Movement Points Variable
    private static final int archerMovementBase = 4;

    //Base Attack Range Variable
    private static final int archerAttackRangeBase = 3;

    public Archer()
    {
        setMax_hp(archerHealthPointsBase);
        setCurrent_hp(archerHealthPointsBase);
        setAttack(archerAttackBase);
        setDefense(archerDefenseBase);
        setMovement(archerMovementBase);
        setAttackRange(archerAttackRangeBase);
    }
}
