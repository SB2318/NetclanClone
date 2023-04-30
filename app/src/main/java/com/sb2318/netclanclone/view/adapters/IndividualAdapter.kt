package com.sb2318.netclanclone.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sb2318.netclanclone.R
import com.sb2318.netclanclone.databinding.ItemHomeLayoutBinding
import com.sb2318.netclanclone.services.DataModel
import com.sb2318.netclanclone.services.processDistance

class IndividualAdapter(private val dataLists:List<DataModel>,private val context:Context)
    : RecyclerView.Adapter<IndividualAdapter.IndividualViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndividualViewHolder {
        val binding= DataBindingUtil.inflate<ItemHomeLayoutBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home_layout,
            parent,
            false
        )

        return IndividualViewHolder(binding)
    }

    override fun getItemCount(): Int = dataLists.size

    override fun onBindViewHolder(holder: IndividualViewHolder, position: Int) {
        holder.bind(dataLists[position])
    }

    inner class IndividualViewHolder(val binding:ItemHomeLayoutBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(dataModel: DataModel) {

            binding.profileImage.visibility= View.GONE
            binding.titleText.visibility = View.VISIBLE
            binding.linearLayout2.visibility = View.GONE
            binding.tagRecycler.visibility = View.VISIBLE

            val titleText= "${dataModel.title[0]}${dataModel.title.substring(
                dataModel.title.indexOf(" ")+1,
                dataModel.title.indexOf(" ")+2
            )}"

            binding.titleText.text = titleText
            binding.progressBar.progress= dataModel.progress

            binding.title.text = if(dataModel.title.length>20)
                "${dataModel.title.substring(0,16)}..."
            else
                dataModel.title

            val distanceInKm = processDistance(dataModel.distance)
            val distanceMsg= "${dataModel.location},within $distanceInKm KM"
            binding.location.text= distanceMsg
            binding.statusText.text= dataModel.status
            binding.aboutText.text= context.getString(R.string.home_message)

            val adapter= TagAdapter(dataModel.tags)

            binding.tagRecycler.adapter= adapter
            binding.tagRecycler.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL,false)
            binding.tagRecycler.setHasFixedSize(true)
        }

    }

}