package com.example.ahmed.volleyrequestimage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    Button btn_showImage;
    ImageView img;
    String ser_url = "https://www.fadaeyat.co/vb/imgcache/2/24166fadaeyat.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_showImage = (Button) findViewById(R.id.btn_show);
        img = (ImageView) findViewById(R.id.imageView1);

        btn_showImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageRequest ir = new ImageRequest(ser_url, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {

                        img.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "someThing went error....", Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });

                MySingleton m = new MySingleton(MainActivity.this);
                RequestQueue rq = m.getRQ();
                rq.add(ir);
            }
        });
    }

}

