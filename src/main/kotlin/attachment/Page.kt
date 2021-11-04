package attachment

data class Page(
    val id: Int,
    val groupId: Int,
    val creatorId: Int,
    val title: String,
    val current_user_can_edit: Boolean,
    val current_user_can_edit_access: Boolean,
    val who_can_view: Int,
    val who_can_edit: Int,
    val edited: Int,
    val created: Int,
    val editor_id: Int,
    val views: Int,
    val parent: String,
    val parent2: String,
    val source: String,
    val html: String,
    val viewUrl: String,
)
