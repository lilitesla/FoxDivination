package lili.tesla.foxdivination.data;

/**
 * Created by Лилия on 07.12.2017.
 */

public class MoRosary {

    private String indexId;
    private String[] answers;
    private int[] imagesId;

    public MoRosary(String indexId, String[] answers) {
        this.indexId = indexId;
        this.answers = answers;

        imagesId = new int[3];
        for (int i = 0; i < 3; i ++) {
            if (indexId.charAt(i) == '1') {
                imagesId[i] = 1; // TODO: 07.12.2017 вернуть настоящие картинки
            } else {
                if (indexId.charAt(i) == '2') {
                    imagesId[i] = 2; // TODO: 07.12.2017 вернуть настоящие картинки
                } else {
                    if (indexId.charAt(i) == '3') {
                        imagesId[i] = 3; // TODO: 07.12.2017 вернуть настоящие картинки
                    }
                }
            }
        }
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int[] getImagesId() {
        return imagesId;
    }

    public void setImagesId(int[] imagesId) {
        this.imagesId = imagesId;
    }
}
