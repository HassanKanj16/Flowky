package model;

import android.widget.ImageView;
import android.widget.TextView;

public class NynewsModel {
    Integer nyimg,nyimg2;
    String nytext1,nytext2;

    public NynewsModel(Integer nyimg, Integer nyimg2, String nytext1, String nytext2) {
        this.nyimg = nyimg;
        this.nyimg2 = nyimg2;
        this.nytext1 = nytext1;
        this.nytext2 = nytext2;
    }

    public Integer getNyimg() {
        return nyimg;
    }

    public void setNyimg(Integer nyimg) {
        this.nyimg = nyimg;
    }

    public Integer getNyimg2() {
        return nyimg2;
    }

    public void setNyimg2(Integer nyimg2) {
        this.nyimg2 = nyimg2;
    }

    public String getNytext1() {
        return nytext1;
    }

    public void setNytext1(String nytext1) {
        this.nytext1 = nytext1;
    }

    public String getNytext2() {
        return nytext2;
    }

    public void setNytext2(String nytext2) {
        this.nytext2 = nytext2;
    }
}
