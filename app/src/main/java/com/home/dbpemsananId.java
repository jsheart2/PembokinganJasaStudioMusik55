package com.home;

public class dbpemsananId {
    private String id;
    private String nama;
    private String jumlah;
    private String price;
    private String getNama;
    private String tglboking;
    private String menit;


    public dbpemsananId(String id, String nama, String jumlah, String price, String getNama, String tglboking, String menit) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
        this.price = price;
        this.getNama = getNama;
        this.tglboking = tglboking;
        this.menit = menit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGetNama() {
        return getNama;
    }

    public void setGetNama(String getNama) {
        this.getNama = getNama;
    }

    public String getTglboking() {
        return tglboking;
    }

    public void setTglboking(String tglboking) {
        this.tglboking = tglboking;
    }

    public String getMenit() {
        return menit;
    }

    public void setMenit(String menit) {
        this.menit = menit;
    }
}
