package com.sb2318.netclanclone.view.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sb2318.netclanclone.view.fragments.tabFragments.IndividualFragment
import com.sb2318.netclanclone.view.fragments.tabFragments.MerchantFragment
import com.sb2318.netclanclone.view.fragments.tabFragments.ProfessionalFragment


class ViewPagerAdapter(private val activity: FragmentActivity): FragmentStateAdapter(activity) {


    override fun getItemCount(): Int =3

    override fun createFragment(position: Int): Fragment {

        return  when(position){

            0-> {
               return  IndividualFragment()
            }

            1-> {
               return ProfessionalFragment()
            }

            2->{
              return MerchantFragment()
            }

            else->
              IndividualFragment()
        }
    }
}