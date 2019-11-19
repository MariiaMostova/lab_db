package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.RoomType;
import ua.lviv.iot.exception.NoSuchRoomTypeException;

public class RoomTypeDTO extends ResourceSupport{
    RoomType roomType;
    public RoomTypeDTO(RoomType roomType, Link selfLink) throws NoSuchRoomTypeException {
        this.roomType=roomType;
        add(selfLink);
    }

    public Integer getRoomTypeId() {
        return roomType.getId(); }

    public String getRoomTypeName() {
        return roomType.getName();
    }

    public Integer getRoomTypePersonAmount() {
        return roomType.getPerson();
    }

}