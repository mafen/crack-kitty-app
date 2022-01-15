package com.mafen.kittycounterapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class DataRepo {

    private DataDao dataDao;
    private LiveData<List<DataItem>> allDataItems;

    DataRepo(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        dataDao = db.dataDao();
        allDataItems = dataDao.getAll();

    }

    LiveData<List<DataItem>> getAllDataItems(){
        return allDataItems;
    }


    LiveData<DataItem> getDataItem(int id){
        return dataDao.getDataItem(id);
    }

    /**
     * @param dataItem the item that is supposed to be updated in the database
     */
    void updateDataItem(DataItem dataItem){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            dataDao.updateItem((dataItem));
        });

    }


}
