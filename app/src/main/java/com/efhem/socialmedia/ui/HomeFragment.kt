package com.efhem.socialmedia.ui


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.efhem.socialmedia.R
import com.efhem.socialmedia.databinding.FragmentOthersBinding
import com.efhem.socialmedia.util.Utils

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentOthersBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_others, container, false)

        Utils.hideErrorView(binding)

        Handler().postDelayed({
            binding.spinKit.visibility = View.GONE
            Utils.showErrorView(binding)
        }, 3000)

        return binding.root
    }


}
