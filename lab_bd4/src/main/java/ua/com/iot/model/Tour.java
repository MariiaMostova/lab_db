package ua.com.iot.model;

import java.sql.Date;

public class Tour {
    private Integer tourId;
    private Date startDate;
    private Date endDate;
    private Integer routeId;
    private Double price;

    public Tour(Integer tourId, Date startDate, Date endDate, Integer routeId, Double price) {
        this.tourId = tourId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.routeId = routeId;
        this.price = price;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
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

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", routeId=" + routeId +
                ", price=" + price +
                '}';
    }
}
