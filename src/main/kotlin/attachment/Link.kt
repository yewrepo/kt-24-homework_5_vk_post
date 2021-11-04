package attachment

data class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    val photo: Photo? = null,
    val product: Any? = null,
    val button: Any? = null,
    val previewPage: String? = null,
    val previewUrl: String? = null
)