package com.arju.foodmandu.bll;

import com.arju.foodmandu.api.UserApi;
import com.arju.foodmandu.model.username;
import com.arju.foodmandu.serverresponse.SignUpResponse;
import com.arju.foodmandu.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {

    boolean isSuccess = false;

    public boolean checkUser(String username, String password) {

       com.arju.foodmandu.model.username Username= new username(username,password);
       UserApi userapi= Url.getInstance().create(UserApi.class);
       Call<SignUpResponse> usersCall = userapi.checklogin(Username);

        try {
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
                    loginResponse.body().getStatus().equals("Login success!")) {

                Url.token += loginResponse.body().getToken();
                // Url.Cookie = imageResponseResponse.headers().get("Set-Cookie");
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
