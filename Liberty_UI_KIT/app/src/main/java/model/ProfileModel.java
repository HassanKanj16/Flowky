package model;

public class ProfileModel {
    Integer bookimg;
    String booktext,booktext1;

    public ProfileModel(Integer bookimg, String booktext, String booktext1) {
        this.bookimg = bookimg;
        this.booktext = booktext;
        this.booktext1 = booktext1;
    }

    public Integer getBookimg() {
        return bookimg;
    }

    public void setBookimg(Integer bookimg) {
        this.bookimg = bookimg;
    }

    public String getBooktext() {
        return booktext;
    }

    public void setBooktext(String booktext) {
        this.booktext = booktext;
    }

    public String getBooktext1() {
        return booktext1;
    }

    public void setBooktext1(String booktext1) {
        this.booktext1 = booktext1;
    }
}
