package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Guide;
import ua.lviv.iot.exception.NoSuchGuideException;
import ua.lviv.iot.repository.GuideRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GuideService {
    @Autowired
    GuideRepository guideRepository;

    public List<Guide> getAllGuide() {
        return guideRepository.findAll();
    }

    public Guide getGuide(Integer guide_id) throws NoSuchGuideException {
        Guide guide = guideRepository.findById(guide_id).get();
        if (guide == null) throw new NoSuchGuideException();
        return guide;
    }

    @Transactional
    public void createGuide(Guide guide) {
        guideRepository.save(guide);
    }

    @Transactional
    public void updateGuide(Guide uGuide, Integer guide_id) throws NoSuchGuideException {
        Guide guide = guideRepository.findById(guide_id).get();
        if (guide == null) throw new NoSuchGuideException();
        guide.setFirstName(guide.getFirstName());
        guide.setLastName(guide.getLastName());
        guide.setBirthday(guide.getBirthday());
        guide.setSex(guide.getSex());
        guideRepository.save(guide);
    }

    @Transactional
    public void deleteGuide(Integer guide_id) throws NoSuchGuideException {
        Guide guide = guideRepository.findById(guide_id).get();
        if (guide == null) throw new NoSuchGuideException();
        guideRepository.delete(guide);
    }

}
