package social.wellbe.wellbeapplication;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Helper {
    static public void replaceFragment(FragmentManager fragmentManager, int id, Fragment fragment,int enter,int exit,int enterA,int exitA){
        FragmentTransaction transaction = fragmentManager.beginTransaction().setCustomAnimations(enter,exit,enterA,exitA);
        transaction.replace(id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    static public void replaceFragmentS(FragmentManager fragmentManager, int id, Fragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    static public String loadData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("sharedPreference", Context.MODE_PRIVATE);
        return sharedPreferences.getString("userPhone", "");
    }



}
