package ua.com.iot.model;

public class TourClient {
    private Integer clientId;
    private Integer tourId;

    public TourClient(Integer clientId, Integer tourId) {
        this.clientId = clientId;
        this.tourId = tourId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    @Override
    public String toString() {
        return "TourClient{" +
                "clientId=" + clientId +
                ", tourId=" + tourId +
                '}';
    }
}
