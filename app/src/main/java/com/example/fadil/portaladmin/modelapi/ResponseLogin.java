package com.example.fadil.portaladmin.modelapi;

import com.example.fadil.portaladmin.modelapi.DataLogin;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseLogin {
/*    {
        "status": "success",
            "login": "1",
            "data": [
        {
            "nim": "1157050094",
                "nama": "fadil",
                "password": "farid123",
                "role": "user"
        }
    ]
    }*/
@SerializedName("status")
    @Expose
    private String status;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("data")
    @Expose
    private List<DataLogin> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<DataLogin> getData() {
        return data;
    }

    public void setData(List<DataLogin> data) {
        this.data = data;
    }
}
