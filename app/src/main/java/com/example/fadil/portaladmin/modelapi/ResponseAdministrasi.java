package com.example.fadil.portaladmin.modelapi;

public class ResponseAdministrasi {
    private String nama;
    private String nim;
    private String admin;
    private String keluhan;
    private String saran;

    public ResponseAdministrasi(String nama, String nim, String admin, String keluhan, String saran) {
        this.nama = nama;
        this.nim = nim;
        this.admin = admin;
        this.keluhan = keluhan;
        this.saran = saran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getSaran() {
        return saran;
    }

    public void setSaran(String saran) {
        this.saran = saran;
    }
}
