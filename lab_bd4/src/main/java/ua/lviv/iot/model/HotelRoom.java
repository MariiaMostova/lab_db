package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "hotel_room", schema = "mostova_lab1")
@IdClass(HotelRoomPK.class)
public class HotelRoom {
    private Integer hotelId;
    private Integer roomTypeId;
    private Hotel hotelByHotelId;
    private RoomType roomTypeByRoomTypeId;

    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "hotel_id")
    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Id
    @Column(name = "room_type_id")
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

        HotelRoom hotelRoom = (HotelRoom) o;

        if (hotelId != null ? !hotelId.equals(hotelRoom.hotelId) : hotelRoom.hotelId != null) return false;
        if (roomTypeId != null ? !roomTypeId.equals(hotelRoom.roomTypeId) : hotelRoom.roomTypeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotelId != null ? hotelId.hashCode() : 0;
        result = 31 * result + (roomTypeId != null ? roomTypeId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    @ManyToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "id", nullable = false, insertable=false, updatable=false)
    public RoomType getRoomTypeByRoomTypeId() {
        return roomTypeByRoomTypeId;
    }

    public void setRoomTypeByRoomTypeId(RoomType roomTypeByRoomTypeId) {
        this.roomTypeByRoomTypeId = roomTypeByRoomTypeId;
    }
}
