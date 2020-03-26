package org.techtown.project.searchItemList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.project.BottomNavigation.Fragment3;
import org.techtown.project.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class search_fragment extends Fragment {
    private ArrayList<Item> items = new ArrayList<>();
    private Button back_btn;
    private searchdetail_fragment sdf;
    private ImageButton heart_btn;

    @Nullable
    @Override
    public ViewGroup onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String search = getArguments().getString("search");

        final ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.search_list, container, false);

        EditText editText = viewGroup.findViewById(R.id.search_text);
        editText.setText(search);

        initDataset();

        Context context = viewGroup.getContext();
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.search_item_list);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final itemAdapter adapter = new itemAdapter(context, items);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new itemAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                sdf = new searchdetail_fragment();
                Bundle bundle = dataTrans(v);
                sdf.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.list_search_layout, sdf).addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        back_btn = (Button)viewGroup.findViewById(R.id.search_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment3 fr3 = new Fragment3();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.search_fragment, fr3).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return viewGroup;
    }

    private void initDataset(){
        items.clear();
        items.add(new Item(getResources().getDrawable(R.drawable.premierball),"참깨라면", "1000원"));
        items.add(new Item(getResources().getDrawable(R.drawable.premierball),"진라면","2000원"));
        items.add(new Item(getResources().getDrawable(R.drawable.premierball),"프라포치노","3200원"));
        items.add(new Item(getResources().getDrawable(R.drawable.premierball),"아이스커피","4000원"));
    }

    private Bundle dataTrans(View v){
        Bundle bundle = new Bundle();
        TextView item_name = v.findViewById(R.id.item_name);
        TextView item_value = v.findViewById(R.id.item_value);
        bundle.putString("item_name",item_name.getText().toString());
        bundle.putString("item_value",item_value.getText().toString());
        return bundle;
    }

}
