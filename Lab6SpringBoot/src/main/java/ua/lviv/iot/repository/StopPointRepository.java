package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.StopPoint;

@Repository
public interface StopPointRepository  extends JpaRepository<StopPoint, Integer> {
}
