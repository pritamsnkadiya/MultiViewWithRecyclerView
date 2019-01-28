package com.example.pritam.meenuapp.api;

import com.example.pritam.meenuapp.models.MultiViewModel;
import com.example.pritam.meenuapp.models.UserResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

    public static final int DEFAULT_PAGE_SIZE = 10;

    @Headers({"Accept: application/json"})
    @GET
    Call<UserResponseModel> getUserData(@Url String url, @Header("Authorization") String tokenId);


    @Headers({"Accept: application/json"})
    @GET
    Call<MultiViewModel> getMultiViewType(@Url String url, @Header("Authorization") String tokenId);

    /*@Headers({"Content-Type: application/json"})
    @POST("/corpcrm1/user/api/add_followup.php")
    Call<FollowUpInsertedResponse> postFollowUpInseretdRequest(@Body FollowUpInsertedRequest request);*/

}
