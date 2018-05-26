package com.example.fadil.portaladmin.modelapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statistik {
        /*  "jml_administrasi": 2,
                  "jml_fasilitas": 6,
                  "jml_dosen": 0,
                  "jml_organisasi": 4*/

    @SerializedName("jml_administrasi")
    @Expose
    private String administrasi;
    @SerializedName("jml_fasilitas")
    @Expose
    private String fasilitas;
    @SerializedName("jml_dosen")
    @Expose
    private String dosen;
    @SerializedName("jml_organisasi")
    @Expose
    private String organisasi;

    public Statistik(String administrasi, String fasilitas, String dosen, String organisasi) {
        this.administrasi = administrasi;
        this.fasilitas = fasilitas;
        this.dosen = dosen;
        this.organisasi = organisasi;
    }

    public String getAdministrasi() {
        return administrasi;
    }

    public void setAdministrasi(String administrasi) {
        this.administrasi = administrasi;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getOrganisasi() {
        return organisasi;
    }

    public void setOrganisasi(String organisasi) {
        this.organisasi = organisasi;
    }
}