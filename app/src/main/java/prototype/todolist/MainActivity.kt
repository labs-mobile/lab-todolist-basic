package prototype.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import prototype.todolist.data.TaskEntry
import prototype.todolist.databinding.ActivityMainBinding
import prototype.todolist.ui.TaskAdapter
import prototype.todolist.ui.TaskFormActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter : TaskAdapter


    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext,"onResume", Toast.LENGTH_LONG)

    }

    private var listener = object : TaskAdapter.OnItemClickListener {
        override fun onItemClick(task: TaskEntry, taskAdapter : TaskAdapter) {
             Toast.makeText(applicationContext,task.title,Toast.LENGTH_SHORT).show()

            val intent = Intent(applicationContext, TaskFormActivity::class.java)
            intent.putExtra("position", task.id)
            startForResult.launch(intent)


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        Toast.makeText(applicationContext,"onCreate", Toast.LENGTH_LONG)

        super.onCreate(savedInstanceState)

        // ViewBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.taskAdapter = TaskAdapter(listener)
        this.recyclerView = binding.recyclerView
        // Todo version 2 : Ajoutez la possibilité de choisir le layoutManager depuis un button sur le menu
        this.recyclerView.layoutManager = LinearLayoutManager(this)
        this.recyclerView.adapter = this.taskAdapter


    }



    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data

            val message = result.data!!.extras?.getString("keyName")
                ?: "No Result Provided"

                this.taskAdapter.notifyDataSetChanged()
               Toast.makeText(applicationContext,message, Toast.LENGTH_LONG)




        }
    }
}