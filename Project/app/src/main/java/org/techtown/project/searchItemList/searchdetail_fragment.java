package org.techtown.project.searchItemList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.project.R;

import java.util.ArrayList;
import java.util.Objects;

public class searchdetail_fragment extends Fragment {
    ViewGroup viewGroup;
    Button sdb;
    search_fragment sf;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.search_item_detail, container, false);
        ReceiveData();
          sdb = (Button) viewGroup.findViewById(R.id.search_back_btn_detail);

        sdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_fragment sf = new search_fragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.search_fragment, sf).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return viewGroup;
    }

    private void ReceiveData(){
        Bundle bundle = getArguments();
        String in = bundle.getString("item_name");
        String iv = bundle.getString("item_value");

        TextView banner_name = viewGroup.findViewById(R.id.detail_banner_name);
        TextView item_name = viewGroup.findViewById(R.id.detail_item_name);
        TextView item_value = viewGroup.findViewById(R.id.detail_item_value);

        banner_name.setText(in);
        item_name.setText(in);
        item_value.setText(iv);
    }
}

