package com.example.pritam.meenuapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pritam.meenuapp.MultiViewType;
import com.example.pritam.meenuapp.R;

public class Login extends AppCompatActivity {

    public LinearLayout signIn_btn,forgot_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);

        signIn_btn = (LinearLayout)findViewById (R.id.signIn_btn);
        forgot_password = (LinearLayout)findViewById (R.id.forgot_password);

        signIn_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Login.this,MultiViewType.class);
                startActivity (intent);
            }
        });

        forgot_password.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"Under Working",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
            }
        });
    }
}
