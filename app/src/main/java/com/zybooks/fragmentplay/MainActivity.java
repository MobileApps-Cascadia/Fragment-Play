package com.zybooks.fragmentplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        //TODO: Use the fragment manager and a transaction to add FragmentOne to the Activity's fragment container view


        Button swap = findViewById(R.id.swap_button);
        //TODO: Add onClickListener that calls swap

    }

    public void swap() {
        //TODO: Use Transactions and the BackStack to swap between FragmentOne and FragmentTwo

    }

}