package ua.com.iot.model;

public class Hotel {
    private Integer hotelId;
    private String hotelName;
    private Integer hotelCityId;

    public Hotel(Integer hotelId, String hotelName, Integer hotelCityId) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelCityId = hotelCityId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getHotelCityId() {
        return hotelCityId;
    }

    public void setHotelCityId(Integer hotelCityId) {
        this.hotelCityId = hotelCityId;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", hotelCityId=" + hotelCityId +
                '}';
    }
}
