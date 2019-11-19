package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.StopPoint;
import ua.lviv.iot.exception.NoSuchStopPointException;
import ua.lviv.iot.repository.StopPointRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StopPointService {
    @Autowired
    StopPointRepository stopPointRepository;

    public List<StopPoint> getAllStopPoint() {
        return stopPointRepository.findAll();
    }

    public StopPoint getStopPoint(Integer stopPoint_id) throws NoSuchStopPointException {
        StopPoint stopPoint = stopPointRepository.findById(stopPoint_id).get();
        if (stopPoint == null) throw new NoSuchStopPointException();
        return stopPoint;
    }

    @Transactional
    public void createStopPoint(StopPoint stopPoint) {
        stopPointRepository.save(stopPoint);
    }

    @Transactional
    public void updateStopPoint(StopPoint uStopPoint, Integer stopPoint_id) throws NoSuchStopPointException {
        StopPoint stopPoint = stopPointRepository.findById(stopPoint_id).get();
        if (stopPoint == null) throw new NoSuchStopPointException();
        stopPoint.setDescription(stopPoint.getDescription());
        stopPoint.setCityId(stopPoint.getCityId());
        stopPoint.setHotelId(stopPoint.getHotelId());
        stopPointRepository.save(stopPoint);
    }

    @Transactional
    public void deleteStopPoint(Integer stopPoint_id) throws NoSuchStopPointException {
        StopPoint stopPoint = stopPointRepository.findById(stopPoint_id).get();
        if (stopPoint == null) throw new NoSuchStopPointException();
        stopPointRepository.delete(stopPoint);
    }

}
