package ua.lviv.iot.domain;

import javax.persistence.*;

@Entity
@Table(name = "room_type", schema = "mostova_lab1")
public class RoomType {
    private Integer id;
    private String name;
    private Integer person;

    public RoomType() {
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "person")
    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomType roomType = (RoomType) o;

        if (id != null ? !id.equals(roomType.id) : roomType.id != null) return false;
        if (name != null ? !name.equals(roomType.name) : roomType.name != null) return false;
        if (person != null ? !person.equals(roomType.person) : roomType.person != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        return result;
    }

    public RoomType(Integer id, String name, Integer person) {
        this.id = id;
        this.name = name;
        this.person = person;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
