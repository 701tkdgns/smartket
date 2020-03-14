package org.techtown.project;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ramotion.foldingcell.FoldingCell;

public class FoldingCellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foldingcell_main);
        // get our folding cell
        final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);
        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                fc.toggle(false);
            }
        });
    }
}
