package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.RouteGuide;

@Repository
public interface RouteGuideRepository  extends JpaRepository<RouteGuide, Integer> {
}