package prototype.todolist.data

// Todo : Organiser les fichiers en trois packages : Dao,Entries, Repositories
data class TaskEntry(
    var id: Int,
    var title: String,
    var priority: Int,
    var timestamp: Long

)

