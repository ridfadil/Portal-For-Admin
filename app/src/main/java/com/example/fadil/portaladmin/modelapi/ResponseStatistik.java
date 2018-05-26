package com.example.fadil.portaladmin.modelapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseStatistik {
/*    {
        "status": "success",
            "data": [
        {
            "jml_administrasi": 2,
                "jml_fasilitas": 6,
                "jml_dosen": 0,
                "jml_organisasi": 4
        }
    ]
    }*/
@SerializedName("status")
@Expose
private String status;
    @SerializedName("data")
    @Expose
    private List<Statistik> statistik;

    public ResponseStatistik(String status, List<Statistik> statistik) {
        this.status = status;
        this.statistik = statistik;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Statistik> getStatistik() {
        return statistik;
    }

    public void setStatistik(List<Statistik> statistik) {
        this.statistik = statistik;
    }
}
