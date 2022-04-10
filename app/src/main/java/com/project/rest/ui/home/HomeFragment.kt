package com.project.rest.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.project.rest.Bron
import com.project.rest.R
import com.project.rest.databinding.FragmentHomeBinding
import com.project.rest.ui.Communicator

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var communicator: Communicator

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?


    {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


            binding.imageButton3.setOnClickListener{
                val a = activity
                if(a!=null) {

                    val Intent = Intent(activity, Bron::class.java)
                    startActivity(Intent)
                }
        }











        val root: View = binding.root
        return root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


}