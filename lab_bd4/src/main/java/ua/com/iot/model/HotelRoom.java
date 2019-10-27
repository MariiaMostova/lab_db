package ua.com.iot.model;

public class HotelRoom {
    private Integer hotelRoomId;
    private Integer hotelRoomTypeId;

    public HotelRoom(Integer hotelRoomId, Integer hotelRoomTypeId) {
        this.hotelRoomId = hotelRoomId;
        this.hotelRoomTypeId = hotelRoomTypeId;
    }

    public Integer getHotelRoomId() {
        return hotelRoomId;
    }

    public void setHotelRoomId(Integer hotelRoomId) {
        this.hotelRoomId = hotelRoomId;
    }

    public Integer getHotelRoomTypeId() {
        return hotelRoomTypeId;
    }

    public void setHotelRoomTypeId(Integer hotelRoomTypeId) {
        this.hotelRoomTypeId = hotelRoomTypeId;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "hotelRoomId=" + hotelRoomId +
                ", hotelRoomTypeId=" + hotelRoomTypeId +
                '}';
    }
}
