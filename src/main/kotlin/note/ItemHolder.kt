package note

class ItemHolder<E>(
    var item: IdItem<E>,
    var isDeleted: Boolean = false
) {
    fun getId(): Int = item.getId()
    fun getLinkId(): Int = item.getLinkId()

    override fun toString(): String {
        return "ItemHolder(item=$item, isDeleted=$isDeleted)"
    }

}