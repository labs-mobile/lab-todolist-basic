package prototype.todolist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import prototype.todolist.R

class TaskFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_form)
    }
}