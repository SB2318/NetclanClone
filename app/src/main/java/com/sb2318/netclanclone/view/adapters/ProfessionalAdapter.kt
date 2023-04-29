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

class ProfessionalAdapter(val dataLists:List<DataModel>,val context:Context)
    : RecyclerView.Adapter<ProfessionalAdapter.ProfessionalViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionalViewHolder {
        val binding= DataBindingUtil.inflate<ItemHomeLayoutBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home_layout,
            parent,
            false
        )

        return ProfessionalViewHolder(binding)
    }

    override fun getItemCount(): Int = dataLists.size

    override fun onBindViewHolder(holder: ProfessionalViewHolder, position: Int) {
        holder.bind(dataLists[position])
    }

    inner class ProfessionalViewHolder(val binding:ItemHomeLayoutBinding)
        :RecyclerView.ViewHolder(binding.root){


        fun bind(dataModel: DataModel) {
           binding.profileImage.visibility= View.GONE
           binding.titleText.visibility = View.VISIBLE
           binding.linearLayout2.visibility = View.VISIBLE
           binding.tagRecycler.visibility = View.VISIBLE

            val titleText= "${dataModel.title[0]}${dataModel.title.substring(
                  dataModel.title.indexOf(" ")+1,
                dataModel.title.indexOf(" ")+2
            )}"

            binding.titleText.text = titleText
            binding.progressBar.progress= dataModel.progress

            binding.title.text = if(dataModel.title.length>10)
                "${dataModel.title.substring(0,10)}..."
            else
                dataModel.title

            val distanceInKm = processDistance(dataModel.distance)
            val distanceMsg= "${dataModel.location},within $distanceInKm KM"
            binding.location.text= distanceMsg
            binding.statusText.text= dataModel.status

            binding.aboutText.text = context.getString(R.string.professional_message)
            val companyName= if(dataModel.companyName.isEmpty())
                                "NA"
                             else
                               dataModel.companyName

            val exp =  if(dataModel.experiencedYear==1)
                           "1 year of experience"
                       else
                           "${dataModel.experiencedYear}s of experience"
            val adapter= TagAdapter(listOf(
                 companyName,
                exp
            ))

            binding.tagRecycler.adapter= adapter
            binding.tagRecycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            binding.tagRecycler.setHasFixedSize(true)
        }

    }

}