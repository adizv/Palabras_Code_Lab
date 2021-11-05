package org.izv.palabrascodelab.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.izv.palabrascodelab.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflate
        initialize();
    }

    private void initialize() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        //final WordListAdapter adapter = new WordListAdapter(new WordListAdapter.WordDiff());
        //recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}