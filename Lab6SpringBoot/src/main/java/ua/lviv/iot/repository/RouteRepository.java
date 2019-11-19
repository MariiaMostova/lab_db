package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Route;

@Repository
public interface RouteRepository  extends JpaRepository<Route, Integer> {
}