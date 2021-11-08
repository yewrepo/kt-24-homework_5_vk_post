package note

data class Note(
    private val id: Int = -1,
    val ownerId: Int = 0,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int = 0,
    val readComments: Int = 0,
    val viewUrl: String? = null
) : IdItem<Note> {
    override fun getId(): Int = id
    override fun getLinkId(): Int = ownerId
    override fun copy(newId: Int): IdItem<Note> {
        return this.copy(id = newId, date = date)
    }
}
