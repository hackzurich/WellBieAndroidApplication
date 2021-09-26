package social.wellbe.wellbeapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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
import social.wellbe.wellbeapplication.Helper;
import social.wellbe.wellbeapplication.R;
import social.wellbe.wellbeapplication.model.User;
import social.wellbe.wellbeapplication.model.UserData;
import social.wellbe.wellbeapplication.model.UserLogin;
import social.wellbe.wellbeapplication.model.UserLoginRespo;

public class SignInActivity extends AppCompatActivity {
    String json;
    RequestBody formBody;
    Request request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        OkHttpClient client = new OkHttpClient();
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        EditText email = findViewById(R.id.login_user_name);
        EditText pass = findViewById(R.id.login_password);


        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                json = new Gson().toJson(new UserLogin(email.getText().toString(),pass.getText().toString()));
                formBody = RequestBody.create(JSON, json);
                request = new Request.Builder()
                        .url("https://vellbie-server-staging.herokuapp.com/oauth/token")
                        .post(formBody)
                        .build();

                if (email.getText().toString().length() <= 0 || pass.getText().toString().length() < 8) {
                    Toast.makeText(SignInActivity.this, "Check your email & password", Toast.LENGTH_SHORT).show();
                    return;
                }
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        Log.d("fail", call.toString());
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                        Log.d("done", response.body().string());
                        if (response.code() >= 400) {

                            SignInActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(SignInActivity.this, "Check your email & password", Toast.LENGTH_SHORT).show();
                                }
                            });

                            return;
                        }
                        startActivity(new Intent(getBaseContext(), HomeNavigationActivity.class));
                        finish();
                    }
                });
            }
        });




    }
}