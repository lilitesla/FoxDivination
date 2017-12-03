package lili.tesla.foxdivination.data;

import lili.tesla.foxdivination.R;

/**
 * Created by Лилия on 03.12.2017.
 */

public class CoinAfrica {

    private int value;
    private int imageId;

    public CoinAfrica(int value) {
        this.value = value;
        this.imageId = getCoinImageId();
    }

    private int getCoinImageId(){
        if (value == 0) {
            return R.drawable.reshka_africa;
        } else {
            return R.drawable.orel_africa;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
