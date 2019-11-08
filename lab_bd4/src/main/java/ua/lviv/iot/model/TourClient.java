package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "tour_client", schema = "mostova_lab1")
@IdClass(TourClientPK.class)
public class TourClient {
    private Integer clientId;
    private Integer tourId;
    private Client clientByClientId;
    private Tour tourByTourId;

    @Id
    @Column(name = "client_id")
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Id
    @Column(name = "tour_id")
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

        TourClient that = (TourClient) o;

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

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Client getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(Client clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Tour getTourByTourId() {
        return tourByTourId;
    }

    public void setTourByTourId(Tour tourByTourId) {
        this.tourByTourId = tourByTourId;
    }
}
