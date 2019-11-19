package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.RoomType;

@Repository
public interface RoomTypeRepository  extends JpaRepository<RoomType, Integer> {
}