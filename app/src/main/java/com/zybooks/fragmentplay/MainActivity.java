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
        if(savedInstanceState == null){
            fm.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, FragmentOne.class, null)
                    .addToBackStack("FragmentOne")
                    .commit();
        }
        Button swap = findViewById(R.id.swap_button);
        //TODO: Add onClickListener that calls swap
        swap.setOnClickListener( v -> swap()
        );
    }

    public void swap() {
        //TODO: Use Transactions and the BackStack to swap between FragmentOne and FragmentTwo
        fm = getSupportFragmentManager();
        if ( fm.getBackStackEntryAt(0).getName().equals("FragmentOne") ) {
            fm.popBackStack();

            //TODO: Use the fragment manager and a transaction to add FragmentOne to the Activity's fragment container view
            fm.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, FragmentTwo.class, null)
                    .addToBackStack("FragmentTwo")
                    .commit();
        }
        else {
            fm.popBackStack();
            fm.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container_view, FragmentOne.class, null)
                    .addToBackStack("FragmentOne")
                    .commit();

        }
    }

}