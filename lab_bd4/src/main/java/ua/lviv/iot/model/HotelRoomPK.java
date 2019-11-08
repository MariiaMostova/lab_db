package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class HotelRoomPK implements Serializable {
    private Integer hotelId;
    private Integer roomTypeId;

    @Column(name = "hotel_id")
    @Id
    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Column(name = "room_type_id")
    @Id
    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelRoomPK that = (HotelRoomPK) o;

        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (roomTypeId != null ? !roomTypeId.equals(that.roomTypeId) : that.roomTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotelId != null ? hotelId.hashCode() : 0;
        result = 31 * result + (roomTypeId != null ? roomTypeId.hashCode() : 0);
        return result;
    }
}
