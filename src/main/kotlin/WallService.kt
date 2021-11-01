import post.Post
import java.util.*

object WallService {

    var lastId: Int = 0
    private var postArray = emptyArray<Post>()

    fun add(post: Post): Post {
        post.id = lastId
        postArray += post
        lastId = postArray.size - 1
        return postArray.last()
    }

    fun update(post: Post): Boolean {
        if (postArray.getOrNull(post.id) != null) {
            postArray[post.id] = post
            return true
        }
        return false
    }

    fun clear() {
        lastId = 0
        postArray = emptyArray()
    }
}