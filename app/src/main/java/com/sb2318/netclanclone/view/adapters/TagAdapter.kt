package com.sb2318.netclanclone.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sb2318.netclanclone.R
import com.sb2318.netclanclone.databinding.ItemTagLayoutBinding

class TagAdapter(val tags:List<String>):RecyclerView.Adapter<TagAdapter.TagHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagHolder {

        val binding= DataBindingUtil.inflate<ItemTagLayoutBinding>(
             LayoutInflater.from(parent.context),
              R.layout.item_tag_layout,
            parent,
            false
        )

        return TagHolder(binding)
    }

    override fun getItemCount(): Int= tags.size

    override fun onBindViewHolder(holder: TagHolder, position: Int) {
        holder.bind(tags[position],position)
    }


    inner class TagHolder(val binding:ItemTagLayoutBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(tag: String, position: Int) {

            binding.line.visibility= if(position==tags.size-1)
                                       View.GONE
                                     else
                                         View.VISIBLE

            binding.coffee.text= tag
        }

    }
}