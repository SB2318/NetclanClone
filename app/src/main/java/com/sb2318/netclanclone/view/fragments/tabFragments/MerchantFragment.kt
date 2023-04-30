package com.sb2318.netclanclone.view.fragments.tabFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sb2318.netclanclone.R
import com.sb2318.netclanclone.databinding.FragmentExploreLayoutBinding
import com.sb2318.netclanclone.services.DataModel
import com.sb2318.netclanclone.services.DataService
import com.sb2318.netclanclone.view.adapters.MerchantAdapter

class MerchantFragment: Fragment() {

    private lateinit var binding: FragmentExploreLayoutBinding
    private lateinit var dataList:List<DataModel>


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

        dataList= DataService.getCompaniesData()
        val adapter= MerchantAdapter(dataList,requireContext())

        if(dataList.isEmpty()){
            binding.containerRecycler.visibility= View.GONE
            binding.noDataLayout.root.visibility= View.VISIBLE
        }else{
            binding.containerRecycler.visibility= View.VISIBLE
            binding.noDataLayout.root.visibility= View.GONE
        }

        val lm= LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        binding.containerRecycler.adapter= adapter
        binding.containerRecycler.layoutManager = lm
        binding.containerRecycler.setHasFixedSize(true)

        binding.containerRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (dy > 10 && binding.fab.isShown) {
                    binding.fab.hide()
                }

                if (dy < -10 && !binding.fab.isShown) {
                    binding.fab.show()
                }

                if (!recyclerView.canScrollVertically(-1)) {
                    binding.fab.show()
                }
            }
        })


    }
}