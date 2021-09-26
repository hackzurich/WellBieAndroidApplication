package social.wellbe.wellbeapplication.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import social.wellbe.wellbeapplication.Helper;
import social.wellbe.wellbeapplication.MyStatusFragment;
import social.wellbe.wellbeapplication.R;

public class HomeNavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_navigation);
        bottomNavigation=findViewById(R.id.bottom_navigation);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Favorite:
                        Helper.replaceFragmentS(getSupportFragmentManager(),R.id.home_fragment_viewer,new FavoriteFragment());
                        break;

                    case R.id.challenges:
                        Helper.replaceFragmentS(getSupportFragmentManager(),R.id.home_fragment_viewer,new ChallangesFragment());
                        break;

                    case R.id.my_status:
                        Helper.replaceFragmentS(getSupportFragmentManager(),R.id.home_fragment_viewer,new MyStatusFragment());
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}