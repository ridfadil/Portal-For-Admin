package com.example.fadil.portaladmin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fadil.portaladmin.R;
import com.example.fadil.portaladmin.modelapi.DataLogin;
import com.example.fadil.portaladmin.modelapi.ResponseLogin;
import com.example.fadil.portaladmin.api.UtilsApi;
import com.example.fadil.portaladmin.modelapi.FormLogin;
import com.example.fadil.portaladmin.session.SessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity  {


    private EditText etNimUsername;
    private EditText etPassword;
    private Button btnLogin;
    SessionManager session;
    String nim,pass;
    List<DataLogin> responData =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nim = etNimUsername.getText().toString();
                pass = etPassword.getText().toString();
                login(nim,pass);
           /*     Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(i);*/
            }
        });
    }

    public void login(String mNim,String mPass){
        FormLogin login = new FormLogin(mNim, mPass);
        Call<ResponseLogin> call = UtilsApi.getAPIService().addLogin(login);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                // Toast.makeText(PengaduanAdministrasi.this, "harusnya bener", Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    session = new SessionManager(getApplicationContext());
                    responData = response.body().getData();

                    if (responData.size()<1) {
                        Toast.makeText(LoginActivity.this, "Login Salah cek email dan username", Toast.LENGTH_SHORT).show();
                    } else {
                        String Nim = responData.get(0).getNim();
                        String nama = responData.get(0).getNama();
                        String role = responData.get(0).getRole();
                        session.createNamaSession(nama);
                        session.createNimSession(Nim);
                        session.createRoleSession(role);
                        Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                        startActivity(i);
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "check your Email or Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void initView() {
        etNimUsername = (EditText) findViewById(R.id.et_nim_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
    }
}