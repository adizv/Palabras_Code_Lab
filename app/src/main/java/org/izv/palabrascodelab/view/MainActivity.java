package org.izv.palabrascodelab.view;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.izv.palabrascodelab.R;
import org.izv.palabrascodelab.model.data.Word;
import org.izv.palabrascodelab.view.recycler.WordAdapter;
import org.izv.palabrascodelab.viewmodel.WordViewModel;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName() + "xyzyx";

    //public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private WordViewModel mWordViewModel;
    private ActivityResultLauncher<Intent> launcher;

    /*public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra("word"));
            mWordViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //inflate
        initialize();
    }

    private void initialize() {
        Log.v(TAG, "initialize");
        mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

        /*mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
            }
        });*/

        WordAdapter wordAdapter = new WordAdapter(null);

        mWordViewModel.getAllWords().observe(this, words -> {
            wordAdapter.update(words);
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(wordAdapter);
        FloatingActionButton fab = findViewById(R.id.fab);

        launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Word word = new Word(data.getStringExtra("word"));
                        mWordViewModel.insert(word);
                    } else {
                        Toast.makeText(
                                getApplicationContext(),
                                R.string.empty_not_saved,
                                Toast.LENGTH_LONG).show();
                    }
                }}
        );

        fab.setOnClickListener((View v) -> {
            Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
            //startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            launcher.launch(intent);
            //Word word = new Word(Math.random() + "");
            //mWordViewModel.insert(word);
            //mWordViewModel.cleanTable();
        });
        //mWordViewModel.littleInsert();
    }
}