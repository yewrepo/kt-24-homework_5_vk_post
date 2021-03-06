package post

import attachment.Attachment

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val date: Long,
    val text: String,
    val replyOwnerId: Int = 0,
    val replyPostId: Int = 0,
    val friendsOnly: Boolean = false,
    val comments: Comments = Comments(),
    val copyright: String = "",
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: PostType,
    val signerId: Int = 0,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val postponedId: Int = 0,
    val postSource: PostSource? = null,
    val geo: Geo? = null,
    val copyHistory: List<Any>? = null,
    val attachment: List<Attachment>? = null
)
