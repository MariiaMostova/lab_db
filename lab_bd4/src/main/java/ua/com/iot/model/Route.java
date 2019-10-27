package ua.com.iot.model;

public class Route {
    private Integer routeId;
    private String description;
    private Integer routeTypeId;

    public Route(Integer routeId, String description, Integer routeTypeId) {
        this.routeId = routeId;
        this.description = description;
        this.routeTypeId = routeTypeId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRouteTypeId() {
        return routeTypeId;
    }

    public void setRouteTypeId(Integer routeTypeId) {
        this.routeTypeId = routeTypeId;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", description='" + description + '\'' +
                ", routeTypeId=" + routeTypeId +
                '}';
    }
}
