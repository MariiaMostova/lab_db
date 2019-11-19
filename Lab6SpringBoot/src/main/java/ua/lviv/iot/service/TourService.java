package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Tour;
import ua.lviv.iot.exception.NoSuchTourException;
import ua.lviv.iot.repository.TourRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TourService {
    @Autowired
    TourRepository tourRepository;

    public List<Tour> getAllTour() {
        return tourRepository.findAll();
    }

    public Tour getTour(Integer tour_id) throws NoSuchTourException {
        Tour tour = tourRepository.findById(tour_id).get();
        if (tour == null) throw new NoSuchTourException();
        return tour;
    }

    @Transactional
    public void createTour(Tour tour) {
        tourRepository.save(tour);
    }

    @Transactional
    public void updateTour(Tour uTour, Integer tour_id) throws NoSuchTourException {
        Tour tour = tourRepository.findById(tour_id).get();
        if (tour == null) throw new NoSuchTourException();
        tour.setStartDate(tour.getStartDate());
        tour.setEndDate(tour.getEndDate());
        tour.setRouteId(tour.getRouteId());
        tour.setPrice(tour.getPrice());
        tourRepository.save(tour);
    }

    @Transactional
    public void deleteTour(Integer tour_id) throws NoSuchTourException {
        Tour tour = tourRepository.findById(tour_id).get();
        if (tour == null) throw new NoSuchTourException();
        tourRepository.delete(tour);
    }

}
