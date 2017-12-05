package Entity;

public class Archer extends Character {


    //no magic numbers
    private static final int archerHPBase = 90;
    private static final int archerAttackBase = 20;
    private static final int archerMovementBase = 80;
    private static final int archerRangeBase = 120;


    public Archer(){
        super();
        this.setMax_hp(archerHPBase);
        this.setCurrent_hp(archerHPBase);
        this.setAttack(archerAttackBase);
        this.setMovement(archerMovementBase);
        this.setAttackRange(archerRangeBase);
    }
    public Archer(String fof)
    {
        super();
        this.setMax_hp(archerHPBase);
        this.setCurrent_hp(archerHPBase);
        this.setAttack(archerAttackBase);
        this.setMovement(archerMovementBase);
        this.setAttackRange(archerRangeBase);

        if(fof.compareToIgnoreCase("friend") == 0)
        {
            this.setImageString("Res/Fren_Archer.png");
        }
        else
        {
            this.setImageString("Res/Enemy_Archer.png");
        }
    }
}