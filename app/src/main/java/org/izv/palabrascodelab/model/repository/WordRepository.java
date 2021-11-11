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

    public void cleanTable() {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.deleteAll();
        });
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            try {
                Thread.sleep(2300 + (int)(Math.random() * 3000));
            } catch (InterruptedException e) {
            }
            mWordDao.insert(word);
        });
        /*Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2300 + (int)(Math.random() * 3000));
                } catch (InterruptedException e) {
                }
                mWordDao.insert(word);
            }
        };
        thread.start();*/
    }

    public void littleInsert() {
        Word word = new Word("New 6");
        insert(word);
        word = new Word("Old 6");
        insert(word);
    }
}