package org.techtown.project.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.techtown.project.MainActivity;
import org.techtown.project.R;

public class SubActivity extends AppCompatActivity {

    Button signupButton;
    EditText sendData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        signupButton = findViewById(R.id.signupButton);
        sendData = (EditText)findViewById(R.id.email);

        signupButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SubActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
