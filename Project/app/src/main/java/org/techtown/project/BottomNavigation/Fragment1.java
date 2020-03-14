package org.techtown.project.BottomNavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.techtown.project.FoldingCellActivity;
import org.techtown.project.Login.LoginActivity;
import org.techtown.project.Login.Person;
import org.techtown.project.Login.SubActivity;
import org.techtown.project.MainActivity;
import org.techtown.project.PagerSlidingTabStrip.ViewPagerActivity;
import org.techtown.project.R;
import org.techtown.project.RecyclerViewActivity.RecyclerViewActivity;
import org.techtown.project.fragment.FragmentActivity;

public class Fragment1 extends Fragment {
    ViewGroup viewGroup;
    Button intent_btn;
    Button login_btn;
    EditText emailText;
    EditText passText;
    Button fragment_btn;
    TextView tvData;
    Button request_btn;
    Button viewPager_btn;
    Button recyclerview_btn;
    Button foldingcell_btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.activity_main, container, false);


        login_btn = (Button)viewGroup.findViewById(R.id.login_btn);
        fragment_btn = (Button)viewGroup.findViewById(R.id.fragment);
        emailText = (EditText)viewGroup.findViewById(R.id.emailText1);
        passText = (EditText)viewGroup.findViewById(R.id.passText1);
        tvData = (TextView)viewGroup.findViewById(R.id.tvData);
        request_btn = (Button)viewGroup.findViewById(R.id.request_btn);
        viewPager_btn = (Button)viewGroup.findViewById(R.id.viewpager_btn);
        recyclerview_btn = (Button)viewGroup.findViewById(R.id.recyclerview_btn);
        foldingcell_btn = (Button)viewGroup.findViewById(R.id.foldingcell_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                Person person = new Person(emailText.getText().toString(),  passText.getText().toString(), "이세현");
                intent.putExtra("사용자", person);
                startActivity(intent);
            }
        });

        intent_btn = viewGroup.findViewById(R.id.intent_btn);
        intent_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), SubActivity.class);
                startActivity(intent);
            }
        });

        fragment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FragmentActivity.class);
                startActivity(intent);

            }
        });

        viewPager_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewPagerActivity.class);
                startActivity(intent);
            }
        });

        recyclerview_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        foldingcell_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FoldingCellActivity.class);
                startActivity(intent);
            }
        });

        return viewGroup;
    }

}
