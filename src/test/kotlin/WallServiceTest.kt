import org.junit.Test
import post.Post
import post.PostType
import java.util.*
import org.junit.Assert.*

internal class WallServiceTest {

    @Test
    fun add_postLastId() {
        resetArray()
        assertEquals(3, WallService.lastId)
    }

    @Test
    fun update_shouldSuccess() {
        resetArray()
        val update = Post(id = 2, date = Date().time, ownerId = 3, postType = PostType.Copy, text = "bla-bla")
        val result = WallService.update(update)
        assertTrue(result)
    }

    @Test
    fun update_shouldFail() {
        resetArray()
        val update = Post(id = 4545, date = Date().time, ownerId = 3, postType = PostType.Copy, text = "bla-bla")
        val result = WallService.update(update)
        assertFalse(result)
    }

    private fun resetArray() {
        WallService.clear()
        WallService.add(Post(date = Date().time, ownerId = 1, postType = PostType.Post, text = "Hello!"))
        WallService.add(Post(date = Date().time, ownerId = 2, postType = PostType.Post, text = "Hello World!"))
        WallService.add(Post(date = Date().time, ownerId = 3, postType = PostType.Copy, text = "Hello there!"))
    }
}