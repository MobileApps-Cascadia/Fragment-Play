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
        if (savedInstanceState == null) {
            fm.beginTransaction().setReorderingAllowed(true).add(R.id.fragment_container_view, FragmentOne.class, null).addToBackStack("Fragment Two").commit();
        }

        Button swap = findViewById(R.id.swap_button);
        //TODO: Add onClickListener that calls swap
        swap.setOnClickListener(
                view -> {
                    swap();
                    });

    }

    public void swap() {
        //TODO: Use Transactions and the BackStack to swap between FragmentOne and FragmentTwo


        if (fm.getBackStackEntryAt(0).getName() == "Fragment One") {
            fm.popBackStack();
            fm.beginTransaction().setReorderingAllowed(true).replace(R.id.fragment_container_view, FragmentOne.class, null).addToBackStack("Fragment Two").commit(); }
        else if (fm.getBackStackEntryAt(0).getName() == "Fragment Two") {
            fm.popBackStack();
            fm.beginTransaction().setReorderingAllowed(true).replace(R.id.fragment_container_view, FragmentTwo.class, null).addToBackStack("Fragment One").commit(); }
    }
}