package prototype.todolist

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
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
    private lateinit var listener : TaskAdapter.OnItemClickListener

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // todo : voir la meilleur façon de création des événement avec kotlin
        this.listener = object : TaskAdapter.OnItemClickListener {
            override fun onItemClick(task: TaskEntry) {
                val intent = Intent(applicationContext, TaskFormActivity::class.java)
                intent.putExtra("taskId", task.id)
                startForResult.launch(intent)
            }
        }


        this.taskAdapter =  TaskAdapter(listener)
        binding.apply {
            // Todo version 2 : Ajoutez la possibilité de choisir le layoutManager depuis un button sur le menu
            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            recyclerView.adapter =  taskAdapter
            floatingActionButton.setOnClickListener{
                val intent = Intent(applicationContext, TaskFormActivity::class.java)
                startForResult.launch(intent)
            }

        }






    }

    // todo : Recherche : SuppressLint
    @SuppressLint("SuspiciousIndentation")
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        return true
    }

}