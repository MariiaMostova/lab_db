package ua.com.iot.model;

import java.util.Date;

public class Guide {
    private Integer guideId;
    private String guideFirstName;
    private String guideLastName;
    private Date guideBirthday;
    private String sex;

    public Guide(Integer guideId, String guideFirstName, String guideLastName,Date guideBirthday, String sex ) {
        this.guideId = guideId;
        this.guideFirstName = guideFirstName;
        this.guideLastName = guideLastName;
        this.guideBirthday = guideBirthday;
        this.sex = sex;
    }

    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    public String getGuideFirstName() {
        return guideFirstName;
    }

    public void setGuideFirstName(String guideFirstName) {
        this.guideFirstName = guideFirstName;
    }

    public String getGuideLastName() {
        return guideLastName;
    }

    public void setGuideLastName(String guideLastName) {
        this.guideLastName = guideLastName;
    }

    public Date getGuideBirthday() {
        return guideBirthday;
    }

    public void setGuideBirthday(Date guideBirthday) {
        this.guideBirthday = guideBirthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "guideId=" + guideId +
                ", guideFirstName='" + guideFirstName + '\'' +
                ", guideLastName='" + guideLastName + '\'' +
                ", guideBirthday=" + guideBirthday +
                ", sex='" + sex + '\'' +
                '}';
    }
}
