package attachment

sealed class Attachment(val type: String)

data class PhotoAttachment(val photo: Photo): Attachment("posted_photo")

data class LinkAttachment(val link: Link): Attachment("link")

data class PageAttachment(val link: Page): Attachment("page")

data class AlbumAttachment(val link: Album): Attachment("album")

data class AudioAttachment(val link: Audio): Attachment("audio")