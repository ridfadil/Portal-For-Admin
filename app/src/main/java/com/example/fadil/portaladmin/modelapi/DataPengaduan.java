package com.example.fadil.portaladmin.modelapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*        "status": "success",
                "data": [
    {
        "id": 3,
            "judul": "organisasi",
            "nim": "1157050094",
            "keluhan": "tidak sesuai",
            "saran": "harus lebih baik",
            "jenis_keluhan": "organisasi",
            "foto": null
    },*/

public class DataPengaduan {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("nim")
    @Expose
    private String nim;
    @SerializedName("keluhan")
    @Expose
    private String keluhan;
    @SerializedName("saran")
    @Expose
    private String saran;
    @SerializedName("jenis_keluhan")
    @Expose
    private String jenisKeluhan;

    public DataPengaduan(String id, String judul, String nim, String keluhan, String saran, String jenisKeluhan) {
        this.id = id;
        this.judul = judul;
        this.nim = nim;
        this.keluhan = keluhan;
        this.saran = saran;
        this.jenisKeluhan = jenisKeluhan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
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

    public String getJenisKeluhan() {
        return jenisKeluhan;
    }

    public void setJenisKeluhan(String jenisKeluhan) {
        this.jenisKeluhan = jenisKeluhan;
    }
}
