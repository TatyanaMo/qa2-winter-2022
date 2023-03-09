package hw2transport;

public class Routes {
    private String routeName;
    private String startPoint;
    private String endPoint;
    private double distance;


    public Routes() {

    }
    public Routes(String routeName, String startPoint, String endPoint, double distance) {
        this.routeName = routeName;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
