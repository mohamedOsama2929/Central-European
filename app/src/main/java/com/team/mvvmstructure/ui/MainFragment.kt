package com.team.mvvmstructure.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.team.entities.DataState
import com.team.mvvmstructure.databinding.FragmentMainBinding
import com.team.mvvmstructure.ui.viewmode.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private var binding: FragmentMainBinding? = null
    private val TAG = "MainFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.getData("37b4e8e2a6e2df13925e2c40b2111cc0")
        observe()
        binding?.btnNavigate?.setOnClickListener {
            findNavController().navigateUp()
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment())
        }
    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            mainViewModel.getCurrenciesLiveData.collect {
                when (it) {
                    is DataState.Success -> {
                        //Hide progressBar
                        it.data
                        Toast.makeText(requireContext(), "succ", Toast.LENGTH_SHORT).show()
                        Log.e(TAG, "observe: ")
                    }
                    is DataState.Loading -> {
                        //Show progressBar
                    }
                    is DataState.Error -> {
                        Log.e(TAG, "observe: " + it.exception)
                    }
                    else -> {
                        //do nothing
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
