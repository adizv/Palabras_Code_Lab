package org.izv.palabrascodelab.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.izv.palabrascodelab.R;
import org.izv.palabrascodelab.view.recycler.WordAdapter;
import org.izv.palabrascodelab.viewmodel.WordViewModel;

public class MainActivity extends AppCompatActivity {

    private WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflate
        initialize();
    }

    private void initialize() {
        mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

        //mWordViewModel.littleInsert();

        RecyclerView recyclerView = this.findViewById(R.id.recyclerview);
        WordAdapter wordAdapter = new WordAdapter(mWordViewModel.getAllWords());
        recyclerView.setAdapter(wordAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}