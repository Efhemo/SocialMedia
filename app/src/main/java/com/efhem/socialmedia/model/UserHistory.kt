package com.efhem.socialmedia.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class UserHistory(

    @PrimaryKey(autoGenerate = true)
    val id: Int = -1,
    @Json(name = "details")
    val details: Details?,
    @Json(name = "posts")
    val posts: List<Post>?
)

@JsonClass(generateAdapter = true)
data class Details(
    @Json(name = "address")
    val address: Any?,
    @Json(name = "auth_id")
    val authId: String,
    @Json(name = "auth_type")
    val authType: String,
    @Json(name = "avatar")
    val avatar: String,
    @Json(name = "biography")
    val biography: String,
    @Json(name = "date_of_birth")
    val dateOfBirth: String,
    @Json(name = "email")
    val email: Any?,
    @Json(name = "eye_colour")
    val eyeColour: Any?,
    @Json(name = "follow_status")
    val followStatus: Any?,
    @Json(name = "follower_count")
    val followerCount: String,
    @Json(name = "following_count")
    val followingCount: String,
    @Json(name = "fullname")
    val fullname: String,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "height")
    val height: Any?,
    @Json(name = "id")
    val id: String,
    @Json(name = "phone_number")
    val phoneNumber: Any?,
    @Json(name = "post_like_count")
    val postLikeCount: String,
    @Json(name = "role_id")
    val roleId: String,
    @Json(name = "skin_colour")
    val skinColour: Any?,
    @Json(name = "username")
    val username: String,
    @Json(name = "website")
    val website: Any?
)

@JsonClass(generateAdapter = true)
data class Post(
    @Json(name = "bookmark_status")
    val bookmarkStatus: Any?,
    @Json(name = "category_id")
    val categoryId: String,
    @Json(name = "comment_count")
    val commentCount: String,
    @Json(name = "comments")
    val comments: List<Comment>/*,
    @Json(name = "competition")
    val competition: Competition*/,
    @Json(name = "created_at")
    val createdAt: String,
    /*@Json(name = "hashtags")
    val hashtags: List<Hashtag>,*/
    @Json(name = "id")
    val id: String,
    @Json(name = "like_count")
    val likeCount: String,
    @Json(name = "media_url")
    val mediaUrl: String,
    @Json(name = "post_duration")
    val postDuration: Int,
    @Json(name = "post_like_status")
    val postLikeStatus: Any?,
    @Json(name = "post_shares_count")
    val postSharesCount: String,
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "user_info")
    val userInfo: UserInfo
)

@JsonClass(generateAdapter = true)
data class Comment(
    @Json(name = "comment")
    val comment: String,
    @Json(name = "commenter_avatar")
    val commenterAvatar: String,
    @Json(name = "commenter_id")
    val commenterId: String,
    @Json(name = "commenter_name")
    val commenterName: String,
    @Json(name = "created_at")
    val createdAt: String,
    @Json(name = "id")
    val id: String
)

@JsonClass(generateAdapter = true)
data class Competition(
    @Json(name = "cpid")
    val cpid: String,
    @Json(name = "judge_status")
    val judgeStatus: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "vote_end_date")
    val voteEndDate: String,
    @Json(name = "vote_status")
    val voteStatus: Any?
)

@JsonClass(generateAdapter = true)
data class UserInfo(
    @Json(name = "avatar")
    val avatar: String,
    @Json(name = "fullname")
    val fullname: String,
    @Json(name = "role_id")
    val roleId: String,
    @Json(name = "user_id")
    val userId: String,
    @Json(name = "username")
    val username: String
)

@JsonClass(generateAdapter = true)
data class Hashtag(
    @Json(name = "name")
    val name: String
)