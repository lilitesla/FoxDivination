package lili.tesla.foxdivination.data;

/**
 * Created by Лилия on 24.11.2017.
 */

public class Prediction {

    private int id;
    private String index_id;
    private String caption;
    private String description;

    public Prediction(int  predId, String predIndex, String predCaption, String predDescription) {
        id = predId;
        index_id = predIndex;
        caption = predCaption;
        description = predDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndex_id() {
        return index_id;
    }

    public void setIndex_id(String index_id) {
        this.index_id = index_id;
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
}
