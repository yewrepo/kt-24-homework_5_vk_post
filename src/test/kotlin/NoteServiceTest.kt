import exception.NoteNotFoundException
import note.Note
import note.NoteComment
import org.junit.Assert
import org.junit.Before
import org.junit.Test

internal class NoteServiceTest {

    @Test(expected = NoteNotFoundException::class)
    fun createComment_shouldThrow() {
        NoteService.createComment(
            NoteComment(
                ownerId = 23,
                noteId = 99,
                message = "Awesome note!"
            )
        )
    }

    @Test
    fun createComment_shouldPass() {
        NoteService.createComment(
            NoteComment(
                ownerId = 23,
                noteId = 1,
                message = "Awesome note!"
            )
        )
    }

    @Test
    fun updateComment_shouldPass() {
        NoteService.update(
            NoteComment(id = 1,ownerId = 34, noteId = 2, message = "Comment, Note 2 for 3 new")
        )
    }

    @Test
    fun deleteComment_shouldSuccess() {
        val comment = NoteService.createComment(
            NoteComment(
                ownerId = 23,
                noteId = 1,
                message = "Awesome note!"
            )
        )
        Assert.assertTrue(NoteService.deleteComment(comment.getId()))
    }

    @Test
    fun revertComment_shouldSuccess() {
        val comment = NoteService.createComment(
            NoteComment(
                ownerId = 23,
                noteId = 1,
                message = "Awesome note!"
            )
        )
        Assert.assertTrue(NoteService.revertComment(comment.getId()))
    }

    @Test
    fun addNote_shouldSuccess() {
        Assert.assertNotNull(
            NoteService.add(
                Note(
                    ownerId = 23,
                    title = "New note",
                    text = "Some text",
                    date = 80
                )
            )
        )
    }

    @Test
    fun updateNote_shouldSuccess() {
        Assert.assertTrue(
            NoteService.update(
                Note(
                    id = 1,
                    ownerId = 1,
                    title = "Note 2.1",
                    text = "Some text 2",
                    date = 8034
                )
            )
        )
    }

    @Test
    fun updateNote_shouldFailByOwner() {
        Assert.assertFalse(
            NoteService.update(
                Note(
                    id = 1,
                    ownerId = 33,
                    title = "Note 2.1",
                    text = "Some text 2",
                    date = 8034
                )
            )
        )
    }

    @Before
    fun prepare() {
        NoteService.clear()
        NoteService.add(Note(ownerId = 1, title = "Note 1", text = "Note body 1", date = 123456))
        NoteService.add(Note(ownerId = 1, title = "Note 2", text = "Note body 2", date = 1234567))
        NoteService.add(Note(ownerId = 2, title = "Note 3", text = "Note body 3", date = 12345678))
        NoteService.createComment(NoteComment(ownerId = 34, noteId = 2, message = "Comment, 1 for 3"))
        NoteService.createComment(NoteComment(ownerId = 34, noteId = 2, message = "Comment, 2 for 3"))
    }
}