package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.RoomType;
import ua.lviv.iot.exception.NoSuchRoomTypeException;
import ua.lviv.iot.repository.RoomTypeRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoomTypeService {
    @Autowired
    RoomTypeRepository roomTypeRepository;

    public List<RoomType> getAllRoomType() {
        return roomTypeRepository.findAll();
    }

    public RoomType getRoomType(Integer roomType_id) throws NoSuchRoomTypeException {
        RoomType roomType = roomTypeRepository.findById(roomType_id).get();
        if (roomType == null) throw new NoSuchRoomTypeException();
        return roomType;
    }

    @Transactional
    public void createRoomType(RoomType roomType) {
        roomTypeRepository.save(roomType);
    }

    @Transactional
    public void updateRoomType(RoomType uRoomType, Integer roomType_id) throws NoSuchRoomTypeException {
        RoomType roomType = roomTypeRepository.findById(roomType_id).get();
        if (roomType == null) throw new NoSuchRoomTypeException();
        roomType.setName(roomType.getName());
        roomType.setPerson(roomType.getPerson());
        roomTypeRepository.save(roomType);
    }

    @Transactional
    public void deleteRoomType(Integer roomType_id) throws NoSuchRoomTypeException {
        RoomType roomType = roomTypeRepository.findById(roomType_id).get();
        if (roomType == null) throw new NoSuchRoomTypeException();
        roomTypeRepository.delete(roomType);
    }

}
