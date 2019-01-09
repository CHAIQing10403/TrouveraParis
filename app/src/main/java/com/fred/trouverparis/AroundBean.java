package com.fred.trouverparis;

public class AroundBean {
    private int imgId;
    private String resName;
    private String resLocal;
    private String resPhone;
    private String resComments;
    private double rawX;
    private double rawY;

    public AroundBean(double rawX, double rawY, int imgId, String resName, String resLocal, String resPhone, String resComments){
        this.resComments = resComments;
        this.resLocal = resLocal;
        this.resPhone = resPhone;
        this.resName = resName;
        this.imgId = imgId;
        this.rawX = rawX;
        this.rawY = rawY;
    }
    public AroundBean(int imgId, String resName, String resLocal, String resPhone, String resComments){
        this.resComments = resComments;
        this.resLocal = resLocal;
        this.resPhone = resPhone;
        this.resName = resName;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResLocal() {
        return resLocal;
    }

    public void setResLocal(String resLocal) {
        this.resLocal = resLocal;
    }

    public String getResPhone() {
        return resPhone;
    }

    public void setResPhone(String resPhone) {
        this.resPhone = resPhone;
    }

    public String getResComments() {
        return resComments;
    }

    public void setResComments(String resComments) {
        this.resComments = resComments;
    }

    public double getRawX() {
        return rawX;
    }

    public void setRawX(double rawX) {
        this.rawX = rawX;
    }

    public double getRawY() {
        return rawY;
    }

    public void setRawY(double rawY) {
        this.rawY = rawY;
    }
}
