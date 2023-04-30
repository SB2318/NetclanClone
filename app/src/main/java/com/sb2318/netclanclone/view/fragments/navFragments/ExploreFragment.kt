package com.sb2318.netclanclone.view.fragments.navFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.sb2318.netclanclone.R
import com.sb2318.netclanclone.databinding.FragmentExploreLayoutBinding

class ExploreFragment: Fragment() {

    private lateinit var binding: FragmentExploreLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_explore_layout,container,false)

        return binding.root
    }


}