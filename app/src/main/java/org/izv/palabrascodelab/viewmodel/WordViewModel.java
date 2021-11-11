package org.izv.palabrascodelab.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.izv.palabrascodelab.model.data.Word;
import org.izv.palabrascodelab.model.repository.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private final LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    /*public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }*/

    public void cleanTable() {
        mRepository.cleanTable();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords; //mRepository.getAllWords();
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }

    public void littleInsert() {
        mRepository.littleInsert();
    }
}