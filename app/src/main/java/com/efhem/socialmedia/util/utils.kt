package com.efhem.socialmedia.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.efhem.socialmedia.databinding.FragmentOthersBinding

object Utils {

    fun hideKeyboard(activity: Activity) {
        val view = activity.currentFocus
        if (view != null) {
            (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    fun hideErrorView(binding: FragmentOthersBinding): Unit {
        binding.rabit.visibility = View.GONE
        binding.noData.visibility = View.GONE
    }

    fun showErrorView(binding: FragmentOthersBinding): Unit {
        binding.rabit.visibility = View.VISIBLE
        binding.noData.visibility = View.VISIBLE
    }

    fun resId(resName: String, c: Class<*>): Int {

        try {
            val idField = c.getDeclaredField(resName)
            return idField.getInt(idField)
        } catch (e: Exception) {
            e.printStackTrace()
            return -1
        }
    }

    fun getExtension(url: String): String? {
        if (url.contains(".")) {
            return url.substring(url.lastIndexOf("."))
        }
        return null
    }
}