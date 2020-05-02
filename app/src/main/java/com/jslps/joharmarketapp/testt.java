package com.jslps.joharmarketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.jslps.joharmarketapp.data.model.SeedDataDashboardModel;
import com.jslps.joharmarketapp.ui.dashboard.DashboardActivity;
import com.jslps.joharmarketapp.ui.dashboard.DashboardViewModel;
import com.jslps.joharmarketapp.ui.market.AddMarket;

import java.util.List;

public class testt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testt);

        Intent intent = new Intent(this, DashboardActivity.class);
        intent.putExtra("loggeduser","hello");
        startActivity(intent);

//        ViewModel viewModel = ViewModelProviders.of(this,viewModelFactory).get(DashboardViewModel.class)


    }
}
