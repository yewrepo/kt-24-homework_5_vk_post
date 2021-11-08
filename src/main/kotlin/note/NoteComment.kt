package note

data class NoteComment(
    private val id: Int = -1,
    val ownerId: Int,
    val noteId: Int,
    val replyTo: Int = 0,
    val message: String,
    val guid: Int = 0
) : IdItem<NoteComment> {
    override fun getId(): Int = id
    override fun getLinkId(): Int = noteId
    override fun copy(newId: Int): NoteComment {
        return this.copy(id = newId)
    }
}