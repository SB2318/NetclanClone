package com.sb2318.netclanclone.view.fragments.navFragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.sb2318.netclanclone.R
import com.sb2318.netclanclone.databinding.FragmentRefineBinding
import com.sb2318.netclanclone.view.adapters.RefineTagAdapter


class RefineFragment: Fragment(), RefineTagAdapter.OnItemClick {

    private lateinit var fragment: NavHostFragment
    private lateinit var  navController: NavController
    private lateinit var binding: FragmentRefineBinding
    private lateinit var dataList: List<String>
    private val selectedList= arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragment =
            (requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?)!!

        navController = fragment.navController
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_refine,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val servingList = listOf(
            "Available | Hey Let Us Connect",
            "Away | Stay Discreet And Watch",
            "Busy | Do Not Disturb | Will Catch Up Later",
            "SOS | Emergency! Need Assistance! Help"
        )

        val servingListAdapter = ArrayAdapter(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            servingList
        )

        binding.servingAsSpinner.adapter= servingListAdapter


        binding.distanceSlider.setLabelFormatter { value -> value.toInt().toString() }

        //Add text watcher

        binding.statusContainer.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.statusWordCounter.text= "${s?.length}/250"
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        //set refine tag adapter
         dataList = listOf("Coffee","Business","Hobbies","Friendship"
                                      ,"Movies","Dinning","Dating","Matrimony")

        val refineTagAdapter = RefineTagAdapter(dataList,requireContext(),this)

        binding.refineTagRecycler.adapter= refineTagAdapter
        binding.refineTagRecycler.setHasFixedSize(true)

    }

    override fun onTagClick(tag: String, choice: Boolean, textView: TextView) {

        if(choice){
            selectedList.add(tag)
            textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            textView.setBackgroundResource(R.drawable.refine_android_tag_select_bg)
        }else{

            selectedList.remove(tag)

            if(selectedList.size>0){
                textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                textView.setBackgroundResource(R.drawable.refine_tag_unselect_bg)
            }
        }
    }

}