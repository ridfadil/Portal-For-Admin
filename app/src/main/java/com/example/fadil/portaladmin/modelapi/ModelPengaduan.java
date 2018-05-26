package com.example.fadil.portaladmin.modelapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModelPengaduan {

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

@SerializedName("status")
@Expose
private String status;
@SerializedName("data")
@Expose
private List<DataPengaduan> data;

    public ModelPengaduan(String status, List<DataPengaduan> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataPengaduan> getData() {
        return data;
    }

    public void setData(List<DataPengaduan> data) {
        this.data = data;
    }
}
