package AI;

public class AInfo {

    private double distance;
    private boolean range;
    private int threat;


    public AInfo(boolean range, int threat, double distance){
        this.setDistance(distance);
        this.range = range;
        this.threat = threat;
    }

    public AInfo(boolean range){
        this.range = range;
        this.threat = 0;
        this.setDistance(0.0);
    }

    public AInfo(int threat){
        this.threat = threat;
        this.range = false;
        this.setDistance(0.0);
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

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
