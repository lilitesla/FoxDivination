package lili.tesla.foxdivination.data;

/**
 * Created by Лилия on 25.11.2017.
 */

public class Ekaterina {
    private String caption1;
    private String description1;
    private String caption2;
    private String description2;
    private String caption3;
    private String description3;
    private int imageId1;
    private int imageId2;
    private int imageId3;

    public Ekaterina(String cap1, String desc1, String cap2, String desc2, String cap3, String desc3) {
        caption1 = cap1;
        description1 = desc1;
        caption2 = cap2;
        description2 = desc2;
        caption3 = cap3;
        description3 = desc3;
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

    public int getImageId1() {
        return imageId1;
    }

    public void setImageId1(int imageId1) {
        this.imageId1 = imageId1;
    }

    public int getImageId2() {
        return imageId2;
    }

    public void setImageId2(int imageId2) {
        this.imageId2 = imageId2;
    }

    public int getImageId3() {
        return imageId3;
    }

    public void setImageId3(int imageId3) {
        this.imageId3 = imageId3;
    }
}
