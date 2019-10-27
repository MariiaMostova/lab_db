package ua.com.iot.model;

import java.sql.Date;

public class RouteGuide {
    private Integer routeGuideId;
    private Integer guideId;
    private Integer routeId;
    private Date startDate;
    private Date endDate;

    public RouteGuide(Integer routeGuideId, Integer guideId, Integer routeId, Date startDate, Date endDate) {
        this.routeGuideId = routeGuideId;
        this.guideId = guideId;
        this.routeId = routeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getRouteGuideId() {
        return routeGuideId;
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public void setRouteGuideId(Integer routeGuideId) {
        this.routeGuideId = routeGuideId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "RouteGuide{" +
                "routeGuideId=" + routeGuideId +
                ", guideId=" + guideId +
                ", routeId=" + routeId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
