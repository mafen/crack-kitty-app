package com.mafen.kittycounterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.mafen.kittycounterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private DataViewModel dataViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);

        dataViewModel.getDataItem(1).observe(this, dataItem -> {
            binding.setDataItem( dataItem);

            binding.buttonCounter.setOnClickListener(v -> {
                dataItem.increaseTotal();

                dataViewModel.update(dataItem);

            });
        });








    }
}