package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RouteStopPointPK implements Serializable {
    private Integer routeId;
    private Integer stopPointId;

    @Column(name = "route_id")
    @Id
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Column(name = "stop_point_id")
    @Id
    public Integer getStopPointId() {
        return stopPointId;
    }

    public void setStopPointId(Integer stopPointId) {
        this.stopPointId = stopPointId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteStopPointPK that = (RouteStopPointPK) o;

        if (routeId != null ? !routeId.equals(that.routeId) : that.routeId != null) return false;
        if (stopPointId != null ? !stopPointId.equals(that.stopPointId) : that.stopPointId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId != null ? routeId.hashCode() : 0;
        result = 31 * result + (stopPointId != null ? stopPointId.hashCode() : 0);
        return result;
    }
}
