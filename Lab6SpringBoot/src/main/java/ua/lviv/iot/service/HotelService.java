package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Hotel;
import ua.lviv.iot.exception.ExistHotelForStopPointException;
import ua.lviv.iot.exception.NoSuchHotelException;
import ua.lviv.iot.repository.HotelRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    public Hotel getHotel(Integer hotel_id) throws NoSuchHotelException {
        Hotel hotel = hotelRepository.findById(hotel_id).get();
        if (hotel == null) throw new NoSuchHotelException();
        return hotel;
    }

    @Transactional
    public void createHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Transactional
    public void updateHotel(Hotel uHotel, Integer hotel_id) throws NoSuchHotelException {
        Hotel hotel = hotelRepository.findById(hotel_id).get();
        if (hotel == null) throw new NoSuchHotelException();
        hotel.setName(hotel.getName());
        hotel.setCityId(hotel.getCityId());
        hotelRepository.save(hotel);
    }

    @Transactional
    public void deleteHotel(Integer hotel_id) throws NoSuchHotelException, ExistHotelForStopPointException {
        Hotel hotel = hotelRepository.findById(hotel_id).get();
        if (hotel == null) throw new NoSuchHotelException();
        if (hotel.getStopPointsById().size() != 0) throw new ExistHotelForStopPointException();
        hotelRepository.delete(hotel);
    }

}
