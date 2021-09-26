package social.wellbe.wellbeapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import social.wellbe.wellbeapplication.R;
import social.wellbe.wellbeapplication.model.User;
import social.wellbe.wellbeapplication.model.UserData;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json=new Gson().toJson(new UserData(new User("mahmoudhesham@gmail.com","123456789",true)));
        Log.d("my json",json);
        RequestBody formBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url("https://vellbie-server-staging.herokuapp.com/oauth/token")
                .post(formBody)
                .build();



    }
}