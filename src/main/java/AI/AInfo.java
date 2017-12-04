package AI;

public class AInfo {

    private double distance;
    private boolean range;
    private int threat;


    public AInfo(boolean range, int threat, double distance){
        this.distance = distance;
        this.range = range;
        this.threat = threat;
    }

    public AInfo(boolean range){
        this.range = range;
        this.threat = 0;
        this.distance = 0.0;
    }

    public AInfo(int threat){
        this.threat = threat;
        this.range = false;
        this.distance = 0.0;
    }

    public boolean getRange() {
        return this.range;
    }

    public void setRange(boolean range) {
        this.range = range;
    }

    public int getThreat() {
        return this.threat;
    }

    public void setThreat(int threat) {
        this.threat = threat;
    }
}
