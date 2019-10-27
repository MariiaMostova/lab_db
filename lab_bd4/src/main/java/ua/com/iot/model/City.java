package ua.com.iot.model;

public class City {
    private Integer cityId;
    private String cityName;
    private Integer cityCountryId;

    public City(Integer cityId, String cityName, Integer cityCountryId) {
        this.cityName = cityName;
        this.cityId = cityId;
        this.cityCountryId = cityCountryId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityCountryId() {
        return cityCountryId;
    }

    public void setCityCountryId(Integer cityCountryId) {
        this.cityCountryId = cityCountryId;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", cityCountryId=" + cityCountryId +
                '}';
    }
}
