package com.zybooks.fragmentplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        //TODO: Use the fragment manager and a transaction to add FragmentOne to the Activity's fragment container view
        fm.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, com.zybooks.fragmentplay.FragmentOne.class, null)
                .addToBackStack("FragmentOne")
                .commit();


        Button swap = findViewById(R.id.swap_button);
        //TODO: Add onClickListener that calls swap
        swap.setOnClickListener(v -> swap());

    }

    public void swap() {
        //TODO: Use Transactions and the BackStack to swap between FragmentOne and FragmentTwo

        fm.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, com.zybooks.fragmentplay.FragmentTwo.class, null)
                .addToBackStack("FragmentTwo")
                .commit();
    }

}