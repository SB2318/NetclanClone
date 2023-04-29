package com.sb2318.netclanclone.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sb2318.netclanclone.R
import com.sb2318.netclanclone.databinding.FragmentExploreLayoutBinding
import com.sb2318.netclanclone.services.DataService
import com.sb2318.netclanclone.view.ProfessionalAdapter

class ProfessionalFragment:Fragment() {

    private lateinit var binding: FragmentExploreLayoutBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_explore_layout,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter= ProfessionalAdapter(DataService.getNearByPersonData(),requireContext())

        val lm= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        binding.containerRecycler.adapter= adapter
        binding.containerRecycler.layoutManager = lm
        binding.containerRecycler.setHasFixedSize(true)

        binding.filterIcon.setOnClickListener {

            //navigate to professional filter screen
        }
    }

}
