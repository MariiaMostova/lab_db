package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "hotel", schema = "mostova_lab1")
public class Hotel {
    private Integer id;
    private String name;
    private Integer cityId;
    private City cityByCityId;
    private Collection<HotelRoom> hotelRoomsById;
    private Collection<StopPoint> stopPointsById;

    public Hotel() {
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

    @Basic
    @Column(name = "city_id")
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (id != null ? !id.equals(hotel.id) : hotel.id != null) return false;
        if (name != null ? !name.equals(hotel.name) : hotel.name != null) return false;
        if (cityId != null ? !cityId.equals(hotel.cityId) : hotel.cityId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
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

    @OneToMany(mappedBy = "hotelByHotelId")
    public Collection<HotelRoom> getHotelRoomsById() {
        return hotelRoomsById;
    }

    public void setHotelRoomsById(Collection<HotelRoom> hotelRoomsById) {
        this.hotelRoomsById = hotelRoomsById;
    }

    @OneToMany(mappedBy = "hotelByHotelId")
    public Collection<StopPoint> getStopPointsById() {
        return stopPointsById;
    }

    public void setStopPointsById(Collection<StopPoint> stopPointsById) {
        this.stopPointsById = stopPointsById;
    }

    public Hotel(Integer id, String name, Integer cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
