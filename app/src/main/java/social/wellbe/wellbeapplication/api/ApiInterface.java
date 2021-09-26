package social.wellbe.wellbeapplication.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import social.wellbe.wellbeapplication.model.UserData;
import social.wellbe.wellbeapplication.model.UserResponce;

public interface ApiInterface {

    @POST("api/signup")
    Call<UserResponce> addUser(@Body UserData u);
}
