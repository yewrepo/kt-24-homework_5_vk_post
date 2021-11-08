package note

class CrudController<E> {

    private val list = mutableListOf<ItemHolder<E>>()
    private var lastId: Int = 0

    fun add(item: IdItem<E>): E {
        val copy = item.copy(lastId++)
        list.add(ItemHolder(item = copy))
        return copy as E
    }

    fun get(id: Int): E? {
        return getById(id)?.item as E?
    }

    fun update(item: IdItem<E>): Boolean {
        for ((index, existed) in list.withIndex()) {
            if (existed.getId() == item.getId()
                && existed.getLinkId() == item.getLinkId()
            ) {
                list[index].item = item
                return true
            }
        }
        return false
    }

    fun delete(id: Int): Boolean {
        for (item in list) {
            if (item.getId() == id) {
                item.isDeleted = true
                return true
            }
        }
        return false
    }

    fun revert(id: Int): Boolean {
        for (item in list) {
            if (item.getId() == id) {
                item.isDeleted = false
                return true
            }
        }
        return false
    }

    private fun getById(id: Int): ItemHolder<E>? = list.find {
        it.getId() == id
    }

    fun clear() {
        list.clear()
        lastId = 0
    }

    override fun toString(): String {
        return list.toString()
    }
}