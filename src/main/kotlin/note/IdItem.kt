package note

interface IdItem<T> {
    fun getId(): Int
    fun getLinkId(): Int
    fun copy(newId: Int): IdItem<T>{return this}
}
