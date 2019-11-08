package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TourClientPK implements Serializable {
    private Integer clientId;
    private Integer tourId;

    @Column(name = "client_id")
    @Id
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Column(name = "tour_id")
    @Id
    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TourClientPK that = (TourClientPK) o;

        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;
        if (tourId != null ? !tourId.equals(that.tourId) : that.tourId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (tourId != null ? tourId.hashCode() : 0);
        return result;
    }
}
