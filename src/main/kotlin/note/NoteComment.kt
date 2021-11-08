package note

data class NoteComment(
    val id: Int,
    val ownerId: Int,
    val noteId: Int,
    val replyTo: Int = 0,
    val message: String,
    val guid: Int = 0,
)