package prototype.todolist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import prototype.todolist.R
import prototype.todolist.data.TaskEntry
import prototype.todolist.data.TaskRepository
import prototype.todolist.databinding.ActivityTaskFormBinding

class TaskFormActivity : AppCompatActivity() {

    private val taskRepository = TaskRepository()
    private lateinit var task : TaskEntry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityTaskFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val taskId = intent?.extras?.getInt("taskId")



        // Add
        if(taskId == null){
            this.task = taskRepository.newTask()
            binding.btnDelete.visibility = View.INVISIBLE
        }
        // Update
        else
        {
            this.task = taskRepository.findById(taskId!!)

        }


        binding.apply {

            editTaskTitle.setText(task.title)
            spinner.setSelection(task.priority)
            btnSave.setOnClickListener {
                if(TextUtils.isEmpty(editTaskTitle.text)){
                    Toast.makeText(applicationContext, "It's empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val taskTitle = editTaskTitle.text.toString()
                val priority = spinner.selectedItemPosition
                val taskEntry = TaskEntry(
                    task.id,
                    taskTitle,
                    priority,
                    task.timestamp
                )
                taskRepository.save(taskEntry)
                // Put the String to pass back into an Intent and close this activity
                val intent = Intent()
                intent.putExtra("keyName", "Test bonjour")
                setResult(Activity.RESULT_OK, intent)
                finish()
                Toast.makeText(applicationContext, "Saved!", Toast.LENGTH_SHORT).show()
            }
            btnDelete.setOnClickListener {
                taskRepository.delete(taskId!!)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

        }




        title = "éditer $taskId"


    }
}