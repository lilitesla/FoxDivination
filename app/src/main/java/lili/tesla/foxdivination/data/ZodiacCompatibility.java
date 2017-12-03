package lili.tesla.foxdivination.data;

import lili.tesla.foxdivination.R;

/**
 * Created by Лилия on 03.12.2017.
 */

public class ZodiacCompatibility {

    private int manZodiacId;
    private int womanZodiacId;
    private String manZodiac;
    private String womanZodiac;

    private int percent;

    private String caption1;
    private String description1;

    private String caption2;
    private String description2;

    private String caption3;
    private String description3;

    private String caption4;
    private String description4;

    private String caption5;
    private String description5;

    private int manImageId;
    private int womanImageId;


    public ZodiacCompatibility(int manZodiacId, int womanZodiacId,
                               String manZodiac, String womanZodiac,
                               int percent,
                               String caption1, String description1,
                               String caption2, String description2,
                               String caption3, String description3,
                               String caption4, String description4,
                               String caption5, String description5) {
        this.manZodiacId = manZodiacId;
        this.womanZodiacId = womanZodiacId;
        this.manZodiac = manZodiac;
        this.womanZodiac = womanZodiac;
        this.percent = percent;
        this.caption1 = caption1;
        this.description1 = description1;
        this.caption2 = caption2;
        this.description2 = description2;
        this.caption3 = caption3;
        this.description3 = description3;
        this.caption4 = caption4;
        this.description4 = description4;
        this.caption5 = caption5;
        this.description5 = description5;

        manImageId = getZodiacImage(manZodiacId);
        womanImageId = getZodiacImage(womanZodiacId);
    }

    private int getZodiacImage(int zodiakId) {
        int result = 0;
        switch (zodiakId) {
            case 1: result = R.drawable.zodiac_aries; break;
            case 2: result = R.drawable.zodiac_taurus; break;
            case 3: result = R.drawable.zodiac_twins; break;
            case 4: result = R.drawable.zodiac_cancer; break;
            case 5: result = R.drawable.zodiac_lion; break;
            case 6: result = R.drawable.zodiac_virgo; break;
            case 7: result = R.drawable.zodiac_libra; break;
            case 8: result = R.drawable.zodiac_scorpio; break;
            case 9: result = R.drawable.zodiac_sagittarius; break;
            case 10: result = R.drawable.zodiac_capricorn; break;
            case 11: result = R.drawable.zodiac_aquarius; break;
            case 12: result = R.drawable.zodiac_fish; break;
        }
        return result;
    }

    public int getManZodiacId() {
        return manZodiacId;
    }

    public void setManZodiacId(int manZodiacId) {
        this.manZodiacId = manZodiacId;
    }

    public int getWomanZodiacId() {
        return womanZodiacId;
    }

    public void setWomanZodiacId(int womanZodiacId) {
        this.womanZodiacId = womanZodiacId;
    }

    public String getManZodiac() {
        return manZodiac;
    }

    public void setManZodiac(String manZodiac) {
        this.manZodiac = manZodiac;
    }

    public String getWomanZodiac() {
        return womanZodiac;
    }

    public void setWomanZodiac(String womanZodiac) {
        this.womanZodiac = womanZodiac;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getCaption1() {
        return caption1;
    }

    public void setCaption1(String caption1) {
        this.caption1 = caption1;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getCaption2() {
        return caption2;
    }

    public void setCaption2(String caption2) {
        this.caption2 = caption2;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getCaption3() {
        return caption3;
    }

    public void setCaption3(String caption3) {
        this.caption3 = caption3;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getCaption4() {
        return caption4;
    }

    public void setCaption4(String caption4) {
        this.caption4 = caption4;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public String getCaption5() {
        return caption5;
    }

    public void setCaption5(String caption5) {
        this.caption5 = caption5;
    }

    public String getDescription5() {
        return description5;
    }

    public void setDescription5(String description5) {
        this.description5 = description5;
    }

    public int getManImageId() {
        return manImageId;
    }

    public void setManImageId(int manImageId) {
        this.manImageId = manImageId;
    }

    public int getWomanImageId() {
        return womanImageId;
    }

    public void setWomanImageId(int womanImageId) {
        this.womanImageId = womanImageId;
    }
}
