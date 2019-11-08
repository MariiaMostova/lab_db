package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "city", schema = "mostova_lab1")
public class City {
    private Integer id;
    private String name;
    private Integer countryId;
    private Country countryByCountryId;
    private Collection<Hotel> hotelsById;
    private Collection<StopPoint> stopPointsById;

    public City() {
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "country_id")
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != null ? !id.equals(city.id) : city.id != null) return false;
        if (name != null ? !name.equals(city.name) : city.name != null) return false;
        if (countryId != null ? !countryId.equals(city.countryId) : city.countryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Country getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(Country countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<Hotel> getHotelsById() {
        return hotelsById;
    }

    public void setHotelsById(Collection<Hotel> hotelsById) {
        this.hotelsById = hotelsById;
    }

    @OneToMany(mappedBy = "cityByCityId")
    public Collection<StopPoint> getStopPointsById() {
        return stopPointsById;
    }

    public void setStopPointsById(Collection<StopPoint> stopPointsById) {
        this.stopPointsById = stopPointsById;
    }

    public City(Integer id, String name, Integer countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
