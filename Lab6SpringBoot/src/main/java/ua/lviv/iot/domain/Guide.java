package ua.lviv.iot.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "guide", schema = "mostova_lab1")
public class Guide {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String sex;
    private Collection<RouteGuide> routeGuidesById;

    public Guide() {
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
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guide guide = (Guide) o;

        if (id != null ? !id.equals(guide.id) : guide.id != null) return false;
        if (firstName != null ? !firstName.equals(guide.firstName) : guide.firstName != null) return false;
        if (lastName != null ? !lastName.equals(guide.lastName) : guide.lastName != null) return false;
        if (birthday != null ? !birthday.equals(guide.birthday) : guide.birthday != null) return false;
        if (sex != null ? !sex.equals(guide.sex) : guide.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "guideByGuideId")
    public Collection<RouteGuide> getRouteGuidesById() {
        return routeGuidesById;
    }

    public void setRouteGuidesById(Collection<RouteGuide> routeGuidesById) {
        this.routeGuidesById = routeGuidesById;
    }

    public Guide(Integer id, String firstName, String lastName, Date birthday, String sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                '}';
    }
}
