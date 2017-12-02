package lili.tesla.foxdivination.data;

import lili.tesla.foxdivination.R;

/**
 * Created by Лилия on 03.12.2017.
 */

public class Zodiac {

    private int gender;
    private String name;
    private int zodiakId;
    private String description;
    private int image;

    public Zodiac(int gender, int zodiakId, String name, String description) {
        this.gender = gender;
        this.zodiakId = zodiakId;
        this.name = name;
        this.description = description;
        this.image = getZodiacImage();
    }

    private int getZodiacImage() {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZodiakId() {
        return zodiakId;
    }

    public void setZodiakId(int zodiakId) {
        this.zodiakId = zodiakId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }
}
