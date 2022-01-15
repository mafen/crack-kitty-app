package com.mafen.kittycounterapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataDao {

    @Query("SELECT * FROM data_table Order by id ASC")
    LiveData<List<DataItem>> getAll();

    @Query("SELECT * from data_table WHERE  id=:id")
    LiveData<DataItem> getDataItem(int id);

    /**
     * A SQL update query to update the @item in the database
     */
    @Update()
    void updateItem(DataItem item);


    @Insert
    void insertAll(DataItem... dataItem);
}
