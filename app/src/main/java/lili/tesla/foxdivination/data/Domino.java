package lili.tesla.foxdivination.data;

import lili.tesla.foxdivination.R;
import lili.tesla.foxdivination.presentation.application.App;

/**
 * Created by Лилия on 27.11.2017.
 */

public class Domino {

    private int id;
    private String description;
    private int imageId;

    public Domino(int dId) {
        id = dId;
        description = App.dataBaseAccess.getDominoDescription(dId);
        imageId = getDominoImageId(dId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public int getImageId() {
        return imageId;
    }

    private int getDominoImageId(int imageNum) {

        int result = 0;

        switch (imageNum) {
            case 1: result = R.drawable.domino_00; break;
            case 2: result = R.drawable.domino_10; break;
            case 3: result = R.drawable.domino_11; break;
            case 4: result = R.drawable.domino_20; break;
            case 5: result = R.drawable.domino_21; break;
            case 6: result = R.drawable.domino_22; break;
            case 7: result = R.drawable.domino_30; break;
            case 8: result = R.drawable.domino_31; break;
            case 9: result = R.drawable.domino_32; break;
            case 10: result = R.drawable.domino_33; break;
            case 11: result = R.drawable.domino_40; break;
            case 12: result = R.drawable.domino_41; break;
            case 13: result = R.drawable.domino_42; break;
            case 14: result = R.drawable.domino_43; break;
            case 15: result = R.drawable.domino_44; break;
            case 16: result = R.drawable.domino_50; break;
            case 17: result = R.drawable.domino_51; break;
            case 18: result = R.drawable.domino_52; break;
            case 19: result = R.drawable.domino_53; break;
            case 20: result = R.drawable.domino_54; break;
            case 21: result = R.drawable.domino_55; break;
            case 22: result = R.drawable.domino_60; break;
            case 23: result = R.drawable.domino_61; break;
            case 24: result = R.drawable.domino_62; break;
            case 25: result = R.drawable.domino_63; break;
            case 26: result = R.drawable.domino_64; break;
            case 27: result = R.drawable.domino_65; break;
            case 28: result = R.drawable.domino_66; break;
        }

        return result;

    }

}
