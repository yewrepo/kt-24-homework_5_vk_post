package attachment

data class Album(
    val id: Int,
    val photo: Photo? = null,
    val owner_id: Int,
    val title: String,
    val description: String,
    val created: Int,
    val updated: Int,
    val size: Int,
)
