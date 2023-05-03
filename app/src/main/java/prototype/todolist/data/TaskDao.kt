package prototype.todolist.data



class TaskDao {

    companion object {
        private var list_tasks : MutableList<TaskEntry> = mutableListOf<TaskEntry>()

        init {
            // Todo : add 10 tasks
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


}