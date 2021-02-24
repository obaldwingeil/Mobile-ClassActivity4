package com.example.fragmentexample3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean twoPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if we cannot find the second fragment in the layout
        // that means we only have one column
        if(findViewById(R.id.fragContainer_land_second) != null){
            twoPane = true;
            Log.d("twoPane", twoPane + "");
        }

        // loading in one or two fragments based on the boolean
        if(!twoPane){ // port
            Log.d("twoPane", twoPane + "");
            loadFragment(new FirstFragment(), R.id.fragContainer_first);
            Button button_personality = findViewById(R.id.button_personality);
            button_personality.setOnClickListener(v -> launchSecondActivity(v));
            Button button_houseInfo = findViewById(R.id.button_houseInfo);
            button_houseInfo.setOnClickListener(v -> launchThirdActivity(v));
        }
        else{
            loadFragment(new FirstFragment(), R.id.fragContainer_land_first);
            loadFragment(new SecondFragment(), R.id.fragContainer_land_second);
            loadFragment(new ThirdFragment(), R.id.fragContainer_land_third);
        }

    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public void launchSecondActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public void launchThirdActivity(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

}