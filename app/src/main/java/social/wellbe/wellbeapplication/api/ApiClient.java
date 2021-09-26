package social.wellbe.wellbeapplication.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit=null;
    final static String baseURL="https://vellbie-server-staging.herokuapp.com/";

    public static Retrofit getRetrofit(){
        if (retrofit==null){
            retrofit=new Retrofit
                    .Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
