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
import social.wellbe.wellbeapplication.api.ApiClient;
import social.wellbe.wellbeapplication.api.ApiInterface;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ApiInterface api= ApiClient.getRetrofit().create(ApiInterface.class);

        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        String json=new Gson().toJson(new UserData(new User("mahmoudhesham00@gmail.com","123456789",true)));
        Log.d("my json",json);
        RequestBody formBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url("https://vellbie-server-staging.herokuapp.com/api/signup")
                .post(formBody)
                .build();

        findViewById(R.id.signup_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   client.newCall(request).enqueue(new Callback() {
                       @Override
                       public void onFailure(@NotNull Call call, @NotNull IOException e) {
                           Log.d("fail",call.toString());
                       }

                       @Override
                       public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                           Log.d("done",response.toString());
                           startActivity(new Intent(getBaseContext(),HomeNavigationActivity.class));
                           finish();
                       }
                   });
            }
        });

        findViewById(R.id.have_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), SignInActivity.class));
            }
        });
    }
}