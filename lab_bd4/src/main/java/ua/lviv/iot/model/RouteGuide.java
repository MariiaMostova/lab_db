package ua.lviv.iot.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "route_guide", schema = "mostova_lab1")
public class RouteGuide {
    private Integer id;
    private Integer guideId;
    private Integer routeId;
    private Date startDate;
    private Date endDate;
    private Guide guideByGuideId;
    private Route routeByRouteId;

    public RouteGuide() {
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
    @Column(name = "guide_id")
    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteGuide that = (RouteGuide) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (guideId != null ? !guideId.equals(that.guideId) : that.guideId != null) return false;
        if (routeId != null ? !routeId.equals(that.routeId) : that.routeId != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (guideId != null ? guideId.hashCode() : 0);
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "guide_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Guide getGuideByGuideId() {
        return guideByGuideId;
    }

    public void setGuideByGuideId(Guide guideByGuideId) {
        this.guideByGuideId = guideByGuideId;
    }

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Route getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(Route routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }

    public RouteGuide(Integer id, Integer guideId, Integer routeId, Date startDate, Date endDate) {
        this.id = id;
        this.guideId = guideId;
        this.routeId = routeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "RouteGuide{" +
                "id=" + id +
                ", guideId=" + guideId +
                ", routeId=" + routeId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
