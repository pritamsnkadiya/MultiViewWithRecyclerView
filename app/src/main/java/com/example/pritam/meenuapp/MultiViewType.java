package com.example.pritam.meenuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.pritam.meenuapp.adapters.MultiViewTypeAdapter;
import com.example.pritam.meenuapp.api.ApiClient;
import com.example.pritam.meenuapp.models.Model;
import com.example.pritam.meenuapp.models.MultiViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MultiViewType extends AppCompatActivity {
    private static final String TAG = MultiViewType.class.getSimpleName ();

    MultiViewModel viewModel;
    String accesToken ="";
    RecyclerView mRecyclerView;
    MultiViewTypeAdapter adapter;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_multi_view_type);

        ArrayList<Model> list= new ArrayList ();


        list.add(new Model(Model.VIDEO_TYPE,"Video Type",0,0,0,0,0,0));
        list.add(new Model(Model.IMAGE_TYPE2,"Hello",R.drawable.one,R.drawable.two,0,0,0,0));
        list.add(new Model(Model.IMAGE_TYPE4,"Hi",R.drawable.profile,R.drawable.two,R.drawable.one,R.drawable.three,0,0));
        list.add(new Model(Model.IMAGE_TYPE6,"Hey",R.drawable.profile,R.drawable.two,R.drawable.one,R.drawable.three,R.drawable.three,R.drawable.profile));
        list.add(new Model(Model.IMAGE_TYPE4,"Which one",R.drawable.profile,R.drawable.two,R.drawable.one,R.drawable.three,0,0));

        linearLayoutManager = new LinearLayoutManager (this, OrientationHelper.VERTICAL, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator ());
     /*   adapter = new MultiViewTypeAdapter (list,this);
        mRecyclerView.setAdapter(adapter);*/

        callApiGetProfileData(accesToken);

    }

    private void callApiGetProfileData(String token) {
        try {
            ApiClient.getSingletonApiClient ().getMultiViewCall (token, new Callback<MultiViewModel> () {
                @Override
                public void onResponse(Call<MultiViewModel> call, Response<MultiViewModel> response) {

                    Log.d (TAG, "MultiViewModel Data :" + response.body ());
                    viewModel = response.body ();
                    if (response.isSuccessful ()) {
                        Log.d (TAG, viewModel.toString () + "");

                        adapter = new MultiViewTypeAdapter (MultiViewType.this,viewModel.getMultiView ());
                        mRecyclerView.setAdapter(adapter);

                    } else {
                    }
                }

                @Override
                public void onFailure(Call<MultiViewModel> call, Throwable t) {
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
