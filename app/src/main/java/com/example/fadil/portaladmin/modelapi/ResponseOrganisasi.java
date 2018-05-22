package com.example.fadil.portaladmin.modelapi;

public class ResponseOrganisasi {
    private String nama;
    private String nim;
    private String organisasi;
    private String keluhan;
    private String saran;

    public ResponseOrganisasi(String nama, String nim, String organisasi, String keluhan, String saran) {
        this.nama = nama;
        this.nim = nim;
        this.organisasi = organisasi;
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

    public String getOrganisasi() {
        return organisasi;
    }

    public void setOrganisasi(String organisasi) {
        this.organisasi = organisasi;
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
