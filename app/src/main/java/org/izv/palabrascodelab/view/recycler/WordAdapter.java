package org.izv.palabrascodelab.view.recycler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import org.izv.palabrascodelab.R;
import org.izv.palabrascodelab.model.data.Word;
import org.izv.palabrascodelab.view.MainActivity;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordViewHolder> {

    // de LiveData<List<Word>> a List<Word>
    private List<Word> mAllWords;
    private int cont1 = 0, cont2 = 0;

    public WordAdapter(List<Word> mAllWords) {
        this.mAllWords = mAllWords;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        cont1++;
        //Log.v(MainActivity.TAG, "on create view holder: " + cont1);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        cont2++;
        //Log.v(MainActivity.TAG, "on bind view holder: " + cont2);
        TextView textView = holder.getWordItemView();
        textView.setText(mAllWords.get(position).getWord());
    }

    @Override
    public int getItemCount() {
        if(mAllWords == null) {
            return 0;
        }
        return mAllWords.size();
    }

    public void update(List<Word> words) {
        mAllWords = words;
        notifyDataSetChanged();
    }
}
