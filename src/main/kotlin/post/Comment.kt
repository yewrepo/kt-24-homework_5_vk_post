package post

import attachment.Attachment

data class Comment(
    val id: Int = 0,
    val postId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut? = null,
    val replyByUser: Int = 0,
    val replyToComment: Int = 0,
    val attachments: List<Attachment>? = null,
    val parentsStack: List<Any>? = null,
    val thread: CommentsThread? = null
)
