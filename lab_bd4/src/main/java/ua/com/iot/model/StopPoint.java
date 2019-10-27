package ua.com.iot.model;

public class StopPoint {
    private Integer stopPointId;
    private String stopPointDescription;
    private Integer stopPointCityId;
    private Integer stopPointHotelId;

    public StopPoint(Integer stopPointId, String stopPointDescription, Integer stopPointCityId,
                     Integer stopPointHotelId) {
        this.stopPointId = stopPointId;
        this.stopPointDescription = stopPointDescription;
        this.stopPointCityId = stopPointCityId;
        this.stopPointHotelId = stopPointHotelId;
    }

    public Integer getStopPointId() {
        return stopPointId;
    }

    public void setStopPointId(Integer stopPointId) {
        this.stopPointId = stopPointId;
    }

    public String getStopPointDescription() {
        return stopPointDescription;
    }

    public void setStopPointDescription(String stopPointDescription) {
        this.stopPointDescription = stopPointDescription;
    }

    public Integer getStopPointCityId() {
        return stopPointCityId;
    }

    public void setStopPointCityId(Integer stopPointCityId) {
        this.stopPointCityId = stopPointCityId;
    }

    public Integer getStopPointHotelId() {
        return stopPointHotelId;
    }

    public void setStopPointHotelId(Integer stopPointHotelId) {
        this.stopPointHotelId = stopPointHotelId;
    }

    @Override
    public String toString() {
        return "StopPoint{" +
                "stopPointId=" + stopPointId +
                ", stopPointDescription='" + stopPointDescription + '\'' +
                ", stopPointCityId=" + stopPointCityId +
                ", stopPointHotelId=" + stopPointHotelId +
                '}';
    }
}
