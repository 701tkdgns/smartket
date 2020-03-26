package org.techtown.project.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.techtown.project.R;

public class user_login_fragment extends AppCompatActivity {

    Button back_btn;
    TextView emailText;
    TextView passText;
    TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_success);

        back_btn = (Button)findViewById(R.id.back_btn);
        emailText = (TextView)findViewById(R.id.emailText2);
        passText = (TextView)findViewById(R.id.passText2);
        nameText = (TextView)findViewById(R.id.nameText);

        Intent intent = getIntent();
        final Person person = (Person)intent.getSerializableExtra("사용자");
        Toast.makeText(getApplicationContext(), person.toString(), Toast.LENGTH_LONG).show();

        emailText.setText(person.getEmail());
        passText.setText(person.getPassword());
        nameText.setText(person.getName());

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_login_fragment.super.onBackPressed();
            }
        });
    }
}
