package ua.lviv.iot.DTO;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.iot.domain.Guide;
import ua.lviv.iot.exception.NoSuchGuideException;

import java.sql.Date;

public class GuideDTO extends ResourceSupport{
    Guide guide;
    public GuideDTO(Guide guide, Link selfLink) throws NoSuchGuideException {
        this.guide=guide;
        add(selfLink);
    }

    public Integer getGuideId() {
        return guide.getId(); }

    public String getGuideFirstName() {
        return guide.getFirstName();
    }

    public String getGuideLastName() {
        return guide.getLastName();
    }

    public Date getGuideBirthday() {
        return guide.getBirthday();
    }

    public String getGuideSex() {
        return guide.getSex();
    }

}