package post

data class CommentsThread(
    var count: Int = 0,
    var items: List<Comment>? = null,
    var canPost: Boolean = false,
    var showReplyButton: Boolean = false,
    var groupsCanPost: Boolean = false,
)