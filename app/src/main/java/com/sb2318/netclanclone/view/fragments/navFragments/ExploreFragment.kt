package com.sb2318.netclanclone.view.fragments.navFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.sb2318.netclanclone.R
import com.sb2318.netclanclone.databinding.FragmentExploreBinding
import com.sb2318.netclanclone.view.adapters.ViewPagerAdapter

class ExploreFragment: Fragment() {

    private lateinit var binding: FragmentExploreBinding
    private lateinit var pagerAdapter:ViewPagerAdapter

    // set tab drawable
    private val tabIcons= arrayOf(R.drawable.baseline_groups_24,
        R.drawable.baseline_business_center_24,
    R.drawable.baseline_contact_white)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_explore,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTabIcons()

        pagerAdapter= ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter= pagerAdapter

        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let { binding.viewPager.currentItem = it }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.getTabAt(position)?.select()
            }
        })

        binding.viewPager.isUserInputEnabled= false
    }


    fun setTabIcons(){

       for( i in 0..2){
           binding.tabLayout.getTabAt(i)?.setIcon(tabIcons[i])
       }
    }
}