package org.techtown.project.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.techtown.project.R;

public class FragmentActivity extends AppCompatActivity {

    private boolean isFragmentB = true ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragmentBorC, new fragmentB());
        fragmentTransaction.commit();

        Button button1 = (Button) findViewById(R.id.button1) ;
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment() ;
            }
        });
    }

    public void switchFragment() {
        Fragment fr;

        if (isFragmentB) {
            fr = new fragmentB() ;
        } else {
            fr = new fragmentC() ;
        }

        isFragmentB = (isFragmentB) ? false : true ;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBorC, fr);
        fragmentTransaction.commit();
    }
}

