package com.kekegdsz.bluecollar.widget.tablayout;


/**
 * author：keke
 * createTime：2019/4/22 0022 18:18
 * desc：
 */
public class TabItem {

    public int imageResId;

    public int selectImageResId;

    public int nameResId;

    public int index = -1;


    public TabItem(int imageResId, int selectImageResId, int nameResId) {
        this.imageResId = imageResId;
        this.selectImageResId = selectImageResId;
        this.nameResId = nameResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public int getSelectImageResId() {
        return selectImageResId;
    }

    public void setSelectImageResId(int selectImageResId) {
        this.selectImageResId = selectImageResId;
    }

    public int getNameResId() {
        return nameResId;
    }

    public void setNameResId(int nameResId) {
        this.nameResId = nameResId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
