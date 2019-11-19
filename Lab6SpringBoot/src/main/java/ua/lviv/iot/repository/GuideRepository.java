package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Guide;

@Repository
public interface GuideRepository  extends JpaRepository<Guide, Integer> {
}