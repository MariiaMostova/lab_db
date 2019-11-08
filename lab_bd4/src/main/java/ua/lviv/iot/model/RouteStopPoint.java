package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "route_stop_point", schema = "mostova_lab1")
@IdClass(RouteStopPointPK.class)
public class RouteStopPoint {
    private Integer routeId;
    private Integer stopPointId;
    private Route routeByRouteId;
    private StopPoint stopPointByStopPointId;

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "route_id")
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Id
    @Column(name = "stop_point_id")
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

        RouteStopPoint that = (RouteStopPoint) o;

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

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Route getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(Route routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }

    @ManyToOne
    @JoinColumn(name = "stop_point_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public StopPoint getStopPointByStopPointId() {
        return stopPointByStopPointId;
    }

    public void setStopPointByStopPointId(StopPoint stopPointByStopPointId) {
        this.stopPointByStopPointId = stopPointByStopPointId;
    }
}
