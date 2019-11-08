package ua.lviv.iot.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "tour", schema = "mostova_lab1")
public class Tour {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Integer routeId;
    private Double price;
    private Route routeByRouteId;
    private Collection<TourClient> tourClientsById;

    public Tour() {
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
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "route_id")
    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (id != null ? !id.equals(tour.id) : tour.id != null) return false;
        if (startDate != null ? !startDate.equals(tour.startDate) : tour.startDate != null) return false;
        if (endDate != null ? !endDate.equals(tour.endDate) : tour.endDate != null) return false;
        if (routeId != null ? !routeId.equals(tour.routeId) : tour.routeId != null) return false;
        if (price != null ? !price.equals(tour.price) : tour.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
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

    @OneToMany(mappedBy = "tourByTourId")
    public Collection<TourClient> getTourClientsById() {
        return tourClientsById;
    }

    public void setTourClientsById(Collection<TourClient> tourClientsById) {
        this.tourClientsById = tourClientsById;
    }

    public Tour(Integer id, Date startDate, Date endDate, Integer routeId, Double price) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.routeId = routeId;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", routeId=" + routeId +
                ", price=" + price +
                '}';
    }
}
