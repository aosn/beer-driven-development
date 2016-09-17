package io.github.aosn.camp2016.ui.entity;

public class CellSpec {

    /**
     * 土地名
     */
    private String landName;

    /**
     * 購入金額
     */
    private int price;

    /**
     * 収入（止まった人が払う）
     */
    private int fee;

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
