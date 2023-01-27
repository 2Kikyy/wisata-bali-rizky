package com.example.wisata_bali_rizky;

import android.content.Intent;
import android.os.StrictMode;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class Pengguna extends AppCompatActivity {
    TextView txtInfo;
    EditText txtPID, txtPName, txtPrice;
    Button btnCreate, btnRead, btnUpdate, btnDelete;
    public void btnLogin(View v) {
        Intent intent = new Intent(this, HomepageGuest.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengguna);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        txtPID = (EditText) findViewById(R.id.txtPID);
        txtPName = (EditText) findViewById(R.id.txtPName);
        txtPrice = (EditText) findViewById(R.id.txtPrice);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StrictMode.ThreadPolicy policy = new
                            StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    OkHttpClient client = new OkHttpClient();
                    HttpUrl.Builder urlBuilder = HttpUrl.parse("http://192.168.6.28/wisatabalirizky/api/create.php").newBuilder();
                    urlBuilder.addQueryParameter("username",
                            txtPName.getText().toString());
                    urlBuilder.addQueryParameter("password", txtPrice.getText().toString());
                    String url = urlBuilder.build().toString();
                    Request request = new Request.Builder()
                            .url(url)
                            .build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                        }
                        @Override
                        public void onResponse(Call call, final Response response) throws
                                IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        txtInfo.setText(response.body().string());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        ;
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StrictMode.ThreadPolicy policy = new
                            StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    OkHttpClient client = new OkHttpClient();
                    HttpUrl.Builder urlBuilder = HttpUrl.parse("http://192.168.6.28/wisatabalirizky/api/read.php").newBuilder();
                    urlBuilder.addQueryParameter("id", txtPID.getText().toString());
                    String url = urlBuilder.build().toString();
                    Request request = new Request.Builder()
                            .url(url)
                            .build();
                    client.newCall(request).enqueue(new Callback() {

                        @Override
                        public void onFailure(Call call, IOException e) {
                        }
                        @Override
                        public void onResponse(Call call, final Response response) throws
                                IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        //txtInfo.setText(response.body().string());
                                        try {
                                            String data = response.body().string();
                                            JSONArray jsonArray = new JSONArray(data);
                                            JSONObject jsonObject;
                                            jsonObject = jsonArray.getJSONObject(0);
                                            txtPID.setText(jsonObject.getString("id"));
                                            txtPName.setText(jsonObject.getString("username"));
                                            txtPrice.setText(jsonObject.getString("password"));
                                        } catch (JSONException e) {
                                            txtInfo.setText(e.getMessage());
                                        }
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        ;
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StrictMode.ThreadPolicy policy = new
                            StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    OkHttpClient client = new OkHttpClient();
                    HttpUrl.Builder urlBuilder = HttpUrl.parse("http://192.168.6.28/wisatabalirizky/api/update.php").newBuilder();
                    urlBuilder.addQueryParameter("id", txtPID.getText().toString());
                    urlBuilder.addQueryParameter("username",
                            txtPName.getText().toString());
                    urlBuilder.addQueryParameter("password", txtPrice.getText().toString());
                    String url = urlBuilder.build().toString();
                    Request request = new Request.Builder()
                            .url(url)
                            .build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                        }
                        @Override
                        public void onResponse(Call call, final Response response) throws
                                IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        txtInfo.setText(response.body().string());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                        ;
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StrictMode.ThreadPolicy policy = new
                            StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    OkHttpClient client = new OkHttpClient();
                    HttpUrl.Builder urlBuilder = HttpUrl.parse("http://192.168.6.28/wisatabalirizky/api/delete.php").newBuilder();
                    urlBuilder.addQueryParameter("id", txtPID.getText().toString());
                    String url = urlBuilder.build().toString();
                    Request request = new Request.Builder()
                            .url(url)
                            .build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                        }
                        @Override
                        public void onResponse(Call call, final Response response) throws
                                IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        txtInfo.setText(response.body().string());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}