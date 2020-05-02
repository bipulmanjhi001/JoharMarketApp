package net.simplifiedcoding.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.data.model.SeedDataDashboardModel
import com.jslps.joharmarketapp.databinding.ViewDashboardBinding
import com.jslps.joharmarketapp.ui.dashboard.DashboardRecyclerListner

class DashboardAdapter (
    private val data: List<SeedDataDashboardModel>,
    private val listener: DashboardRecyclerListner

) : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>(){

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DashboardViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.view_dashboard,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.dashboardBinding.seeddatadashboard = data[position]
        holder.dashboardBinding.constLeft.setOnClickListener {
            listener.itemClickListnerDashboard(it,data[position])
        }

        holder.dashboardBinding.constRight.setOnClickListener {
            listener.itemClickListnerDashboard(it,data[position])
        }
    }


    inner class DashboardViewHolder(
        val dashboardBinding:ViewDashboardBinding
    ) : RecyclerView.ViewHolder(dashboardBinding.root)

}