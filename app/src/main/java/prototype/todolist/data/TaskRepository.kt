package prototype.todolist.data

class TaskRepository () {

    private val taskDao = TaskDao()
    fun insert(taskEntry: TaskEntry) = taskDao.insert(taskEntry)
    fun updateData(taskEntry: TaskEntry) = taskDao.update(taskEntry)
    fun deleteItem(taskEntry: TaskEntry) = taskDao.delete(taskEntry)
    fun getAllTasks() = taskDao.getAllTasks()
    fun findById(id: Int) = taskDao.findById(id)
}