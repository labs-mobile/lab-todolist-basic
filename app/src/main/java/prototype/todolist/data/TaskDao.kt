package prototype.todolist.data

class TaskDao {

    companion object {
        private var list_tasks : MutableList<TaskEntry> = mutableListOf<TaskEntry>()

        init {
            for( i in 1..10){
                val task = TaskEntry(i,"Task $i",1,System.currentTimeMillis())
                list_tasks.add(task)
            }
        }
    }




    fun insert(taskEntry: TaskEntry){
        TaskDao.list_tasks.add(taskEntry)
     }

     fun delete(taskEntry: TaskEntry){

     }

     fun update(taskEntry: TaskEntry){
         TaskDao.list_tasks[taskEntry.id - 1] = taskEntry
     }


    fun getAllTasks(): MutableList<TaskEntry> {
        return TaskDao.list_tasks
    }

    fun findById(id: Int) :TaskEntry {
        val task = TaskDao.list_tasks.filter { it.id == id }.first()
        return task
    }


}