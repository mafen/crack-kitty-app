package com.mafen.kittycounterapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DataViewModel extends AndroidViewModel {

    private DataRepo dataRepo;

    private LiveData<List<DataItem>> dataItemList;

    public DataViewModel(Application application){
        super(application);
        dataRepo = new DataRepo(application);
        dataItemList = dataRepo.getAllDataItems();
    }

    public LiveData<List<DataItem>> getDataItemList() {
        return dataItemList;
    }

    LiveData<DataItem> getDataItem(int id) {
        return dataRepo.getDataItem(id);
    }

    void update( DataItem dataItem){
        dataRepo.updateDataItem(dataItem);
    }
}
