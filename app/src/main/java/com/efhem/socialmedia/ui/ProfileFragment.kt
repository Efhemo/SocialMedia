package com.efhem.socialmedia.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.efhem.socialmedia.R
import com.efhem.socialmedia.databinding.FragmentProfileBinding
import com.efhem.socialmedia.model.UserHistory
import com.efhem.socialmedia.util.UserHistoryRCAdapter
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

        val adapter = UserHistoryRCAdapter()
        binding.postRc.setHasFixedSize(false)
        binding.postRc.adapter = adapter

        viewModel.userHistory.observe(this, Observer { userHistory: UserHistory? ->

            userHistory?.let { it: UserHistory ->

                Glide.with(this).load(it.details?.avatar)
                    .apply(RequestOptions.placeholderOf(R.drawable.glide_placeholder))
                    .apply(RequestOptions.centerCropTransform())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.avater)

                binding.followingVal.text = it.details?.followingCount.toString()
                binding.followersVal.text = it.details?.followerCount.toString()
                binding.postLikesVal.text = it.details?.postLikeCount.toString()

                binding.userName.text = it.details?.fullname

                if (it.details?.followStatus == null) {

                    binding.status.text = getString(R.string.not_verified)
                    binding.status.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_clea,
                        0
                    )
                } else {
                    binding.status.text = getString(R.string.verified)
                    binding.status.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_check_black_24dp,
                        0
                    )
                }

                Toast.makeText(this.requireContext(), it.details?.avatar, Toast.LENGTH_LONG).show()

                adapter.submitList(it.posts)
            }
        })

        return binding.root
    }


}
