package com.sb2318.netclanclone.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sb2318.netclanclone.R
import com.sb2318.netclanclone.databinding.ItemRefineTagLayoutBinding

class RefineTagAdapter(val data:List<String>,val context:Context,val listener:OnItemClick):
    RecyclerView.Adapter<RefineTagAdapter.RefineTagViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RefineTagViewHolder {

        val binding= DataBindingUtil.inflate<ItemRefineTagLayoutBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_refine_tag_layout,
            parent,
            false
        )

        return RefineTagViewHolder(binding)
    }

    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: RefineTagViewHolder, position: Int) {
       holder.bind(data[position])
    }

    inner class RefineTagViewHolder(val binding:ItemRefineTagLayoutBinding)
        :RecyclerView.ViewHolder(binding.root){

        var choice = false;

        fun bind(tag: String) {
            binding.coffee.text= tag

            if(tag.equals("Coffee",true) || tag.equals("Business",true)
                || tag.equals("Friendship",true)){
                 choice= !choice
                binding.coffee.setTextColor(ContextCompat.getColor(context,R.color.white))
                binding.coffee.setBackgroundResource(R.drawable.refine_android_tag_select_bg)
            }else {
                binding.coffee.setTextColor(ContextCompat.getColor(context, R.color.black))
                binding.coffee.setBackgroundResource(R.drawable.refine_tag_unselect_bg)
            }

            binding.coffee.setOnClickListener {

                choice=!choice
                listener.onTagClick(tag,choice,binding.coffee)

            }
        }
    }


    interface OnItemClick{

      //In the refine fragment, there should be a list which keep track the selected Tag,
        // If it is unselect, then we just remove the tag from the list.
        //If the tagLists size is 1, then we can't let user to change the background of the current tag to white
        fun onTagClick(tag:String,choice:Boolean,textView: TextView)
    }
}