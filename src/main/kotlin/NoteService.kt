import exception.NoteNotFoundException
import note.CrudController
import note.Note
import note.NoteComment

object NoteService {
    private val notes = CrudController<Note>()
    private val comments = CrudController<NoteComment>()

    fun createComment(comment: NoteComment): NoteComment {
        val post = notes.get(comment.noteId)
        if (post != null) {
            return add(comment)
        } else {
            throw NoteNotFoundException()
        }
    }

    private fun add(comment: NoteComment): NoteComment = comments.add(comment)

    fun add(note: Note): Note = notes.add(note)

    fun update(comment: NoteComment): Boolean = comments.update(comment)

    fun update(note: Note): Boolean = notes.update(note)

    fun deleteComment(id: Int): Boolean = comments.delete(id)

    fun revertComment(id: Int): Boolean = comments.revert(id)

    fun clear() {
        notes.clear()
        comments.clear()
    }
}