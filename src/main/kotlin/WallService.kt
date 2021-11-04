import exception.PostNotFoundException
import post.Comment
import post.Post

object WallService {

    var lastId: Int = 0
    var lastCommentId: Int = 0

    private var postArray = emptyArray<Post>()
    private var commentArray = emptyArray<Comment>()

    fun createComment(comment: Comment) {
        val post = findById(comment.postId)
        if (post != null) {
            add(comment)
        } else {
            throw PostNotFoundException()
        }
    }

    private fun add(comment: Comment): Comment {
        val commentCopy = comment.copy(id = lastCommentId++)
        commentArray += commentCopy
        return commentArray.last()
    }

    fun add(post: Post): Post {
        val postCopy = post.copy(id = lastId++)
        postArray += postCopy
        return postArray.last()
    }

    /**
     * ownerId, date - не трогаем
     */
    fun update(post: Post): Boolean {
        val list = postArray.toMutableList()
        for ((index, value) in list.withIndex()) {
            if (value.id == post.id) {
                val removed = list.removeAt(index)
                val copied = copyPartly(lastId++, removed, post)
                list.add(copied)
                postArray = list.toTypedArray()
                return true
            }
        }
        return false
    }

    fun clear() {
        lastId = 0
        postArray = emptyArray()

        lastCommentId = 0
        commentArray = emptyArray()
    }

    private fun findById(id: Int): Post? = postArray.find {
        it.id == id
    }

    private fun copyPartly(newId: Int, source: Post, newPost: Post) = source.copy(
        id = newId,
        fromId = newPost.fromId,
        text = newPost.text,
        postType = newPost.postType,
        canDelete = newPost.canDelete,
        canEdit = newPost.canEdit,
        canPin = newPost.canPin,
        comments = newPost.comments,
        copyright = newPost.copyright,
        createdBy = newPost.createdBy,
        friendsOnly = newPost.friendsOnly,
        isFavorite = newPost.isFavorite,
        isPinned = newPost.isPinned,
        likes = newPost.likes,
        markedAsAds = newPost.markedAsAds,
        postponedId = newPost.postponedId,
        replyOwnerId = newPost.replyOwnerId,
        replyPostId = newPost.replyPostId,
        reposts = newPost.reposts,
        signerId = newPost.signerId,
        views = newPost.views
    )
}