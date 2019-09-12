package com.efhem.socialmedia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.efhem.socialmedia.R
import com.efhem.socialmedia.databinding.FragmentProfileBinding
import com.efhem.socialmedia.viewmodel.ProfileViewModel

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory(this.activity!!.application)
            .create(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentProfileBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)



        return binding.root
    }


}
