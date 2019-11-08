package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "route_type", schema = "mostova_lab1")
public class RouteType {
    private Integer id;
    private String name;
    private Collection<Route> routesById;

    public RouteType() {
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteType routeType = (RouteType) o;

        if (id != null ? !id.equals(routeType.id) : routeType.id != null) return false;
        if (name != null ? !name.equals(routeType.name) : routeType.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "routeTypeByRouteTypeId")
    public Collection<Route> getRoutesById() {
        return routesById;
    }

    public void setRoutesById(Collection<Route> routesById) {
        this.routesById = routesById;
    }

    public RouteType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "RouteType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
