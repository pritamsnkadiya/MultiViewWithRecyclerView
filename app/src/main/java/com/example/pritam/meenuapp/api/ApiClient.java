package com.example.pritam.meenuapp.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.pritam.meenuapp.models.MultiViewModel;
import com.example.pritam.meenuapp.models.UserResponseModel;
import com.example.pritam.meenuapp.utils.Constant;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient implements Serializable {

    private static final String TAG = ApiClient.class.getSimpleName ();

    private static final boolean production = false;//BuildConfig.DEBUG;
    public static final String BASE_URL = "http://www.fastpays.in/corpcrm1/dashboard/api/add_new_client2.php/";

    private static final Object mLock = new Object ();
    private static Retrofit retrofit = null;
    private static ApiClient apiClient;
    SharedPreferences prf;
    private Context context;

    public ApiClient() {
    }

    public ApiClient(Context context) {
        this.context = context;
    }

    public static boolean isProduction() {
        return production;
    }

    public static ApiClient getSingletonApiClient() {
        synchronized (mLock) {
            if (apiClient == null)
                apiClient = new ApiClient ();

            return apiClient;
        }
    }

    private static Retrofit getClient() {
        if (retrofit == null) {
            //OkHttpClient.Builder client = new OkHttpClient.Builder();

            OkHttpClient.Builder okHttpClient = new OkHttpClient ().newBuilder ()
                    .connectTimeout (60 * 5, TimeUnit.SECONDS)
                    .readTimeout (60 * 5, TimeUnit.SECONDS)
                    .writeTimeout (60 * 5, TimeUnit.SECONDS);

            GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create ();
            retrofit = new Retrofit.Builder ()
                    .baseUrl (BASE_URL)
                    .client (okHttpClient.build ())
                    .addConverterFactory (gsonConverterFactory)
                    .build ();

        }
        return retrofit;
    }

    public void getUserResponse(String token, Callback<UserResponseModel> callback) {
        Call<UserResponseModel> call = null;
        try {
            ApiInterface apiService = ApiClient.getClient ().create (ApiInterface.class);
            Log.d (TAG, "EmployeeResponse Detail Request URL : " + Constant.LOGIN_API_RESPONSE_DETAIL);
            //Log.d(TAG, "OrderDetail Request URL : "+BASE_URL + Constant.API_ORDERS+id);
            call = apiService.getUserData (Constant.LOGIN_API_RESPONSE_DETAIL, token);
            call.enqueue (callback);
        } catch (Exception e) {
            Log.e (TAG, e.toString (), e);
            callback.onFailure (call, e);
        }
    }


    public void getMultiViewCall(String token, Callback<MultiViewModel> callback) {
        Call<MultiViewModel> call = null;
        try {
            ApiInterface apiService = ApiClient.getClient ().create (ApiInterface.class);
            Log.d (TAG, "MultiViewModel Detail Request URL : " + Constant.MULTIVIEW_TYPE_API);
            //Log.d(TAG, "OrderDetail Request URL : "+BASE_URL + Constant.API_ORDERS+id);
            call = apiService.getMultiViewType (Constant.MULTIVIEW_TYPE_API, token);
            call.enqueue (callback);
        } catch (Exception e) {
            Log.e (TAG, e.toString (), e);
            callback.onFailure (call, e);
        }
    }

   /* public void FollowUpInsertedRequestDetail(FollowUpInsertedRequest request, Callback<FollowUpInsertedResponse> callback) {
        Call<FollowUpInsertedResponse> call = null;
        try {
            ApiInterface apiService = ApiClient.getClient ().create (ApiInterface.class);
            Log.d(TAG, "FollowUpInserted Request URL : "+BASE_URL);
            call = apiService.postFollowUpInseretdRequest (request);
            call.enqueue (callback);
        } catch (Exception e) {
            Log.e (TAG, e.toString (), e);
            callback.onFailure (call, e);
        }
    }*/
}