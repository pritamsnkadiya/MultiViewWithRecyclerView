package com.example.pritam.meenuapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pritam.meenuapp.R;
import com.example.pritam.meenuapp.adapters.AllUsersDetailsDataAdapter;
import com.example.pritam.meenuapp.api.ApiClient;
import com.example.pritam.meenuapp.models.User;
import com.example.pritam.meenuapp.models.UserResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName ();

    String accessToken = "Nr0c4wM1rVJBorf4fcMYeg";
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<User> saleDetailsModelList;
    UserResponseModel userResponseModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById (R.id.recycler_view_users);
        recyclerView.setHasFixedSize (true);
        layoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager (layoutManager);
        saleDetailsModelList = new ArrayList<> ();

        callApiGetProfileData (accessToken);
    }

    private void callApiGetProfileData(String token) {
        try {
            ApiClient.getSingletonApiClient ().getUserResponse (token, new Callback<UserResponseModel> () {
                @Override
                public void onResponse(Call<UserResponseModel> call, Response<UserResponseModel> response) {

                    Log.d (TAG, "UsersDetail Data :" + response.body ());
                    userResponseModel = response.body ();
                    if (userResponseModel != null) {
                        // Store here
                        Log.d (TAG, userResponseModel.toString () + "");
                        mAdapter = new AllUsersDetailsDataAdapter (MainActivity.this, userResponseModel.getResult ().getUsers ());
                        recyclerView.setAdapter (mAdapter);
                    } else {
                        // Methods.showPromptMessage (Constant.API_DETAIL);
                        finish ();
                    }
                }

                @Override
                public void onFailure(Call<UserResponseModel> call, Throwable t) {
                    Log.d (TAG, "Fetching Data Error : " + t.getStackTrace ());
                     Log.d (TAG, "Fetching Data Error2 : " + t.getMessage ());
                    Toast.makeText (getApplicationContext (), "Fetching Data Error" + t.getMessage (), Toast.LENGTH_LONG).show ();
                }
            });
        } catch (Exception e) {
            Log.d ("", "Error msg : " + e.getMessage ());
        }
    }
}
