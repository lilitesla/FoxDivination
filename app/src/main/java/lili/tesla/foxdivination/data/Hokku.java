package lili.tesla.foxdivination.data;

/**
 * Created by Лилия on 05.12.2017.
 */

public class Hokku {
    private String hokku;
    private String author;
    private String interpretation;

    public Hokku(String hokku, String author, String interpretation) {
        this.hokku = hokku;
        this.author = author;
        this.interpretation = interpretation;
    }

    public String getHokku() {
        return hokku;
    }

    public void setHokku(String hokku) {
        this.hokku = hokku;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }
}
