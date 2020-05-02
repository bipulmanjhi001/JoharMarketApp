package com.jslps.joharmarketapp.ui.dashboard

import android.view.View
import com.jslps.joharmarketapp.data.model.SeedDataDashboardModel
import com.jslps.joharmarketapp.data.seeddata.DashboardSeedData

interface DashboardRecyclerListner {
    fun itemClickListnerDashboard(view: View, data:SeedDataDashboardModel)
}