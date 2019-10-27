package ua.com.iot.model;

public class RouteStopPoint {
    private Integer routeId;
    private Integer stopPointId;

    public RouteStopPoint(Integer routeId, Integer stopPointId) {
        this.routeId = routeId;
        this.stopPointId = stopPointId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getStopPointId() {
        return stopPointId;
    }

    public void setStopPointId(Integer stopPointId) {
        this.stopPointId = stopPointId;
    }

    @Override
    public String toString() {
        return "RouteStopPoint{" +
                "routeId=" + routeId +
                ", stopPointId=" + stopPointId +
                '}';
    }
}
