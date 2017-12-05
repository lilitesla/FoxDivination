package lili.tesla.foxdivination.data;

import lili.tesla.foxdivination.R;

/**
 * Created by Лилия on 06.12.2017.
 */

public class Mokuso {
    private String indexId;
    private String description;
    private int[] images;

    public Mokuso(String indexId, String description) {
        this.indexId = indexId;
        this.description = description;

        images = new int[4];
        for (int i = 0; i < 4; i ++) {
            if (indexId.charAt(i) == '1') {
                images[i] = R.drawable.mokuso_1;
            } else {
                images[i] = R.drawable.mokuso_2;
            }
        }
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }
}
