package ua.com.iot.model;

public class RoomType {
    private Integer roomTypeId;
    private String roomTypeName;
    private Integer person;

    public RoomType(Integer roomTypeId, String roomTypeName, Integer person) {
        this.roomTypeId = roomTypeId;
        this.roomTypeName = roomTypeName;
        this.person = person;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "roomTypeId=" + roomTypeId +
                ", roomTypeName='" + roomTypeName + '\'' +
                ", person=" + person +
                '}';
    }
}
