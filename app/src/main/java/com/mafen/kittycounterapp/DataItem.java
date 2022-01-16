package com.mafen.kittycounterapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "data_table")
public class DataItem {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "helped" )
    private int helpedTotal;


    @Ignore
    public DataItem(String date, int helped_total){
        this.date = date;
        this.helpedTotal = helped_total;
        id = hashCode();
    }

    public DataItem(String date){
        this.date = date;
        id = hashCode();
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getHelpedTotal() {
        return helpedTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHelpedTotal(int helpedTotal) {
        this.helpedTotal = helpedTotal;
    }

    public void increaseTotal() {
        this.helpedTotal++;
    }

    public void resetTotal(){
        this.helpedTotal = 0;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
