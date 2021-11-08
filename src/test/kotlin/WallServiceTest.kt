import exception.PostNotFoundException
import org.junit.Test
import post.Post
import post.PostType
import java.util.*
import org.junit.Assert.*
import org.junit.Before
import post.Comment

internal class WallServiceTest {

    @Test
    fun createComment_shouldPass() {
        WallService.createComment(
            Comment(
                postId = 1,
                fromId = 1,
                date = Date().time.toInt(),
                text = "Some comment"
            )
        )
    }

    @Test(expected = PostNotFoundException::class)
    fun createComment_shouldThrow() {
        WallService.createComment(
            Comment(
                postId = 999,
                fromId = 1,
                date = Date().time.toInt(),
                text = "Some comment"
            )
        )
    }

    @Test
    fun add_postLastId() {
        assertEquals(3, WallService.lastId)
    }

    @Test
    fun update_shouldSuccess() {
        val update = Post(id = 2, date = Date().time, ownerId = 3, postType = PostType.Copy, text = "bla-bla")
        val result = WallService.update(update)
        assertTrue(result)
    }

    @Test
    fun update_shouldFail() {
        val update = Post(id = 4545, date = Date().time, ownerId = 3, postType = PostType.Copy, text = "bla-bla")
        val result = WallService.update(update)
        assertFalse(result)
    }

    @Before
    fun resetArray() {
        WallService.clear()
        WallService.add(Post(date = Date().time, ownerId = 1, postType = PostType.Post, text = "Hello!"))
        WallService.add(Post(date = Date().time, ownerId = 2, postType = PostType.Post, text = "Hello World!"))
        WallService.add(Post(date = Date().time, ownerId = 3, postType = PostType.Copy, text = "Hello there!"))
    }
}