package ua.lviv.iot.domain;

import javax.persistence.*;

@Entity
@Table(name = "stop_point", schema = "mostova_lab1")
public class StopPoint {
    private Integer id;
    private String description;
    private Integer cityId;
    private Integer hotelId;
    private City cityByCityId;
    private Hotel hotelByHotelId;

    public StopPoint() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
    @Column(name = "city_id")
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "hotel_id")
    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StopPoint stopPoint = (StopPoint) o;

        if (id != null ? !id.equals(stopPoint.id) : stopPoint.id != null) return false;
        if (description != null ? !description.equals(stopPoint.description) : stopPoint.description != null)
            return false;
        if (cityId != null ? !cityId.equals(stopPoint.cityId) : stopPoint.cityId != null) return false;
        if (hotelId != null ? !hotelId.equals(stopPoint.hotelId) : stopPoint.hotelId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public City getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(City cityByCityId) {
        this.cityByCityId = cityByCityId;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    public StopPoint(Integer id, String description, Integer cityId, Integer hotelId) {
        this.id = id;
        this.description = description;
        this.cityId = cityId;
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "StopPoint{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cityId=" + cityId +
                ", hotelId=" + hotelId +
                '}';
    }
}
