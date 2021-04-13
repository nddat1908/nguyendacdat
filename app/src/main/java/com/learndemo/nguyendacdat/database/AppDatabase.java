package com.learndemo.nguyendacdat.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.learndemo.nguyendacdat.dao.ProductDao;
import com.learndemo.nguyendacdat.entity.ProductEntity;

@Database(entities = {ProductEntity.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public abstract ProductDao productDao();

    public static AppDatabase getAppDatabase(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class,"dbProducts").allowMainThreadQueries().build();

        }
        return appDatabase;
    }
}
