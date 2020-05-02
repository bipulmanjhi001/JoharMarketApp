package com.jslps.joharmarketapp.data.seeddata

import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.data.model.SeedDataDashboardModel
import java.util.*

class DashboardSeedData {
    private val title_left = arrayOf(
        "Market",
        "Machine",
        "Veterinary",
        "Logistics"
    )

    private val title_right = arrayOf(
        "Buyers",
        "Inputs",
        "Warehouse",
        "Mandi Prices"
    )

    private val icon_left = arrayOf(
        R.drawable.market_icon,
        R.drawable.machine_icon,
        R.drawable.vetenary_icon,
        R.drawable.truck_icon
    )

    private val icon_right = arrayOf(
        R.drawable.order_icon,
        R.drawable.input_icon,
        R.drawable.warehouse_icon,
        R.drawable.rupee_icon

    )


     fun getListData(): List<SeedDataDashboardModel>? {
        val list: MutableList<SeedDataDashboardModel> =
            ArrayList<SeedDataDashboardModel>()
        for (i in title_left.indices) {
            val model = SeedDataDashboardModel(
                title_left.get(i),
                title_right.get(i),
                icon_left.get(i),
                icon_right.get(i)
            )
            // Binds all strings into an array
            list.add(model)
        }
        return list
    }
}