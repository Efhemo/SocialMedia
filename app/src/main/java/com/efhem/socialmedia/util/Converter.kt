package com.efhem.socialmedia.util

import androidx.room.TypeConverter
import com.efhem.socialmedia.model.Comment
import com.efhem.socialmedia.model.Details
import com.efhem.socialmedia.model.Post
import com.efhem.socialmedia.model.UserInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {

    @TypeConverter
    fun fromArray(value: String?): List<Post>? {
        if (value == null) {
            return null
        }
        val listType = object : TypeToken<List<Post>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toString(list: List<Post>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromArrayComment(value: String?): List<Comment>? {
        if (value == null) {
            return null
        }
        val listType = object : TypeToken<List<Comment>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toStringComment(list: List<Comment>?): String? {

        if (list == null) {
            return null
        }

        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromDetails(value: String?): Details? {
        if (value == null) {
            return null
        }
        val detailsType = object : TypeToken<Details>() {

        }.type
        return Gson().fromJson(value, detailsType)
    }

    @TypeConverter
    fun toStringDeails(details: Details?): String? {

        if (details == null) {
            return null
        }

        val gson = Gson()
        return gson.toJson(details)
    }

    @TypeConverter
    fun fromUserInfo(value: String?): UserInfo? {
        if (value == null) {
            return null
        }
        val userInfoType = object : TypeToken<UserInfo>() {

        }.type
        return Gson().fromJson(value, userInfoType)
    }

    @TypeConverter
    fun toStringUserInfo(userInfo: UserInfo?): String? {

        if (userInfo == null) {
            return null
        }

        val gson = Gson()
        return gson.toJson(userInfo)
    }

}