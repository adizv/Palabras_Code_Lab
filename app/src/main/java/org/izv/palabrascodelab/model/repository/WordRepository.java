package org.izv.palabrascodelab.model.repository;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import org.izv.palabrascodelab.model.dao.WordDao;
import org.izv.palabrascodelab.model.data.Word;
import org.izv.palabrascodelab.model.database.WordRoomDatabase;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;

    private LiveData<List<Word>> mAllWords;

    public WordRepository(Context context) {
        this((Application) context.getApplicationContext());
    }

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
        /*new Thread() {
            @Override
            public void run() {
                mWordDao.insert(word);
            }
        }.start();*/
    }
}