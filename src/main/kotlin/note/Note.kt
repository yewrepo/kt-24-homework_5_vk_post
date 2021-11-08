package note

data class Note(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String,
    val text: String,
    val date: Int,
    val comments: Int = 0,
    val readComments: Int = 0,
    val viewUrl: String? = null,
)
