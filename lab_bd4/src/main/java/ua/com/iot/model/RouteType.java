package ua.com.iot.model;

public class RouteType {
    private Integer routeTypeId;
    private String routeTypeName;

    public RouteType(Integer routeTypeId, String routeTypeName) {
        this.routeTypeId = routeTypeId;
        this.routeTypeName = routeTypeName;
    }

    public Integer getRouteTypeId() {
        return routeTypeId;
    }

    public void setRouteTypeId(Integer routeTypeId) {
        this.routeTypeId = routeTypeId;
    }

    public String getRouteTypeName() {
        return routeTypeName;
    }

    public void setRouteTypeName(String routeTypeName) {
        this.routeTypeName = routeTypeName;
    }

    @Override
    public String toString() {
        return "RouteType{" +
                "routeTypeId=" + routeTypeId +
                ", routeTypeName='" + routeTypeName + '\'' +
                '}';
    }
}
