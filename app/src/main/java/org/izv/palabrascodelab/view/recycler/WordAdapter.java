package org.izv.palabrascodelab.view.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import org.izv.palabrascodelab.R;
import org.izv.palabrascodelab.model.data.Word;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordViewHolder> {

    private LiveData<List<Word>> mAllWords;

    public WordAdapter(LiveData<List<Word>> mAllWords) {
        this.mAllWords = mAllWords;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        TextView textView = holder.getWordItemView();
        textView.setText(mAllWords.getValue().get(position).getWord());
    }

    @Override
    public int getItemCount() {
        if(mAllWords == null) {
            return 0;
        }
        if(mAllWords.getValue() == null) {
            return 0;
        }
        return mAllWords.getValue().size();
    }
}
