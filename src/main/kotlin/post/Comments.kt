package post

data class Comments(
    var count: Int = 0,
    var canPost: Boolean = false,
    var groupCanPost: Boolean = false,
    var canClose: Boolean = false,
    var canOpen: Boolean = false
)
