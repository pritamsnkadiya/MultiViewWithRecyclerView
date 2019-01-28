package com.example.pritam.meenuapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.pritam.meenuapp.R;

public class Home extends AppCompatActivity {

    public LinearLayout signIn_btn,signUp_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_home);

        signIn_btn = (LinearLayout)findViewById (R.id.signIn_btn);
        signUp_btn = (LinearLayout)findViewById (R.id.signUp_btn);

        signIn_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Home.this,Login.class);
                startActivity (intent);
            }
        });

        signUp_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (Home.this,SignUp.class);
                startActivity (intent);
            }
        });
    }
}
