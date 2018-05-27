package com.example.fadil.portaladmin.api;

import com.example.fadil.portaladmin.activity.PengaduanOrganisasi;
import com.example.fadil.portaladmin.modelapi.ResponseLogin;
import com.example.fadil.portaladmin.modelapi.FormLogin;
import com.example.fadil.portaladmin.modelapi.ModelPengaduan;
import com.example.fadil.portaladmin.modelapi.ResponseOrganisasi;
import com.example.fadil.portaladmin.modelapi.ResponseStatistik;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BaseApiService {

/*
    @GET("getPengaduan/{NIM}")
    Call<ModelPengaduan> getPengaduan( @Path("NIM") String nim);*/

    @GET("getAllPengaduan/")
    Call<ModelPengaduan> getPengaduan();

/*    @GET("getAllPengaduan/")
    Call<ModelPengaduan> getPengaduan();*/

    @GET("getPengaduanFasilitas/")
    Call<ModelPengaduan> getFasilitas();

    @GET("getPengaduanOrganisasi/")
    Call<ModelPengaduan> getOrganisasi();

    @GET("getPengaduanAdministrasi/")
    Call<ModelPengaduan> getAdministrasi();

    @GET("getPengaduanDosen/")
    Call<ModelPengaduan> getDosen();

    @GET("getStatistik/")
    Call<ResponseStatistik> getStatistik();

    @POST("loginUser/")
    Call<ResponseLogin> addLogin(@Body FormLogin login);

   /* @POST("loginUser/")
    Call<ResponseLogin> addLogin(@Body FormLogin login);

    @POST("addUser/")
    Call<ResponseBody> addUser(@Body FormAddUser addUser);

    @POST("addPengaduan/")
    Call<ResponseBody> addPengaduan(@Body FormAddPengaduan addPengaduan);*/

    /*@GET("api/company/companyprofil")
    Call<List<ResponseCompanyProfile>>getCompanyProfile(@Header("Authorization") String Authorization);

    @PATCH("api/users/{id}")
    Call<ResponseUpdateProfil> updateProfil(@Header("Authorization") String Authorization,@Path("id") String id, @Body ProfileUpdateForm profil);*/
}

