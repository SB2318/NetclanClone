package com.sb2318.netclanclone.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sb2318.netclanclone.R
import com.sb2318.netclanclone.databinding.ItemHomeLayoutBinding
import com.sb2318.netclanclone.services.DataModel
import com.sb2318.netclanclone.services.processDistance

class MerchantAdapter(val dataLists:List<DataModel>,val context:Context):RecyclerView.Adapter<MerchantAdapter.MerchantViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MerchantViewHolder {

        val binding= DataBindingUtil.inflate<ItemHomeLayoutBinding>(
              LayoutInflater.from(parent.context),
               R.layout.item_home_layout,
            parent,
            false
        )

        return MerchantViewHolder(binding)
    }

    override fun getItemCount(): Int = dataLists.size

    override fun onBindViewHolder(holder: MerchantViewHolder, position: Int) {
        holder.bind(dataLists[position])
    }

    inner class MerchantViewHolder(val binding: ItemHomeLayoutBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(dataModel: DataModel) {
          binding.titleText.visibility= View.GONE
          binding.tagRecycler.visibility = View.GONE
          binding.linearLayout2.visibility= View.VISIBLE
          binding.profileImage.visibility= View.VISIBLE
          binding.aboutText.text=  context.getString(R.string.merchant_message)
          binding.progressBar.progress= dataModel.progress

          binding.title.text = if(dataModel.title.length>10)
                                "${dataModel.title.substring(0,10)}..."
                               else
                                   dataModel.title

          val distanceInKm = processDistance(dataModel.distance)
          val distanceMsg= "${dataModel.location},within $distanceInKm KM"
          binding.location.text= distanceMsg
          binding.statusText.text= dataModel.companyType
        }

    }
}