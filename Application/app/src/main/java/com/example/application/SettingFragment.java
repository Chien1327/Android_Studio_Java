package com.example.application;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.content.SharedPreferences;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SettingFragment extends Fragment {

    public static class YourClassName {
        private static final String SHARE_PREF_NAME = "shared_prefs";
        private static final String USER_NAME = "USER_NAME";
        private static final String USER_PASSWORD = "USER_PASSWORD";
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SettingFragment.YourClassName.SHARE_PREF_NAME, MODE_PRIVATE);

        Button button = view.findViewById(R.id.button_logout);
        button.setOnClickListener(view1 -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        });
        return view;
//        SharedPreferences sharedPreferences = getSharedPreferences(YourClassName.SHARE_PREF_NAME, MODE_PRIVATE);

    }
}

//        button.setOnClickListener(view -> {
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.clear();
//            editor.apply();
//            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        });