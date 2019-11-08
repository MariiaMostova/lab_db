package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "route", schema = "mostova_lab1")
public class Route {
    private Integer id;
    private String description;
    private Integer routeTypeId;
    private RouteType routeTypeByRouteTypeId;
    private Collection<RouteGuide> routeGuidesById;
    private Collection<RouteStopPoint> routeStopPointsById;
    private Collection<Tour> toursById;

    public Route() {
    }

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "route_type_id")
    public Integer getRouteTypeId() {
        return routeTypeId;
    }

    public void setRouteTypeId(Integer routeTypeId) {
        this.routeTypeId = routeTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != null ? !id.equals(route.id) : route.id != null) return false;
        if (description != null ? !description.equals(route.description) : route.description != null) return false;
        if (routeTypeId != null ? !routeTypeId.equals(route.routeTypeId) : route.routeTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (routeTypeId != null ? routeTypeId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "route_type_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public RouteType getRouteTypeByRouteTypeId() {
        return routeTypeByRouteTypeId;
    }

    public void setRouteTypeByRouteTypeId(RouteType routeTypeByRouteTypeId) {
        this.routeTypeByRouteTypeId = routeTypeByRouteTypeId;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<RouteGuide> getRouteGuidesById() {
        return routeGuidesById;
    }

    public void setRouteGuidesById(Collection<RouteGuide> routeGuidesById) {
        this.routeGuidesById = routeGuidesById;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<RouteStopPoint> getRouteStopPointsById() {
        return routeStopPointsById;
    }

    public void setRouteStopPointsById(Collection<RouteStopPoint> routeStopPointsById) {
        this.routeStopPointsById = routeStopPointsById;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<Tour> getToursById() {
        return toursById;
    }

    public void setToursById(Collection<Tour> toursById) {
        this.toursById = toursById;
    }

    public Route(Integer id, String description, Integer routeTypeId) {
        this.id = id;
        this.description = description;
        this.routeTypeId = routeTypeId;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", routeTypeId=" + routeTypeId +
                '}';
    }
}
