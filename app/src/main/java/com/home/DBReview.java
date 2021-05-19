package com.home;

public class DBReview {
    private String DBReview;
    private String edtcomentar;

    public DBReview(String DBReview, String edtcomentar) {
        this.DBReview = DBReview;
        this.edtcomentar = edtcomentar;
    }

    public String getDBReview() {
        return DBReview;
    }

    public void setDBReview(String DBReview) {
        this.DBReview = DBReview;
    }

    public String getEdtcomentar() {
        return edtcomentar;
    }

    public void setEdtcomentar(String edtcomentar) {
        this.edtcomentar = edtcomentar;
    }
}
