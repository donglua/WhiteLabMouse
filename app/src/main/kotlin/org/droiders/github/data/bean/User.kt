package org.droiders.github.data.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by Donglua on 16/8/5.
 */
data class User(
    @SerializedName("login")                val login: String,
    @SerializedName("id")                   val id: String,
    @SerializedName("avatar_url")           val avatarUrl: String,
    @SerializedName("gravatar_id")          val gravatarId: String,
    @SerializedName("url")                  val url: String,
    @SerializedName("html_url")             val htmlUrl: String,
    @SerializedName("followers_url")        val followersUrl: String,
    @SerializedName("following_url")        val followingUrl: String,
    @SerializedName("gists_url")            val gistsUrl: String,
    @SerializedName("starred_url")          val starredUrl: String,
    @SerializedName("subscriptions_url")    val subscriptionsUrl: String,
    @SerializedName("organizations_url")    val organizationsUrl: String,
    @SerializedName("repos_url")            val reposUrl: String,
    @SerializedName("events_url")           val eventsUrl: String,
    @SerializedName("received_events_url")  val receivedEventsUrl: String,
    @SerializedName("type")                 val type: String,
    @SerializedName("site_admin")           val siteAdmin: String,
    @SerializedName("name")                 val name: String,
    @SerializedName("company")              val company: String,
    @SerializedName("blog")                 val blog: String,
    @SerializedName("location")             val location: String,
    @SerializedName("email")                val email: String,
    @SerializedName("hireable")             val hireable: String,
    @SerializedName("bio")                  val bio: String,
    @SerializedName("public_repos")         val publicRepos: String,
    @SerializedName("public_gists")         val publicGists: String,
    @SerializedName("followers")            val followers: String,
    @SerializedName("following")            val following: String,
    @SerializedName("created_at")           val createdAt: String,
    @SerializedName("updated_at")           val updatedAt: String,
    @SerializedName("private_gists")        val privateGists: String,
    @SerializedName("total_private_repos")  val totalPrivateRepos: String,
    @SerializedName("owned_private_repos")  val ownedPrivateRepos: String
)