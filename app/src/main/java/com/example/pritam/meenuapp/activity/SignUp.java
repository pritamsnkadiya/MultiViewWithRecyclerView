package com.example.pritam.meenuapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pritam.meenuapp.R;

public class SignUp extends AppCompatActivity {

    public LinearLayout signIn_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_sign_up);

        signIn_btn = (LinearLayout)findViewById (R.id.signIn_btn);

        signIn_btn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"Under Working",Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();
            }
        });
    }
}
