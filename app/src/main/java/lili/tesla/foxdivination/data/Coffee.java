package lili.tesla.foxdivination.data;

import lili.tesla.foxdivination.R;

/**
 * Created by Лилия on 01.12.2017.
 */

public class Coffee {
    private int id;
    private String caption;
    private String description;
    private int[] images;

    public Coffee(int id, String caption, String description) {
        this.id = id;
        this.caption = caption;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImages(int[] intImages) {
        images = new int[intImages.length];

        for (int i = 0; i < intImages.length; i ++) {
            if (intImages[i] == 0) {
                images[i] = R.drawable.coffee_back;
            } else {
                images[i] = R.drawable.coffee_front;
            }
        }
    }

    public int[] getImages() {
        return images;
    }
}
