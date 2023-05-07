package prototype.todolist.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import prototype.todolist.R
import prototype.todolist.data.TaskEntry
import prototype.todolist.databinding.FragmentTaskManagerBinding

class TaskManagerFragment : Fragment() {

    private var _binding: FragmentTaskManagerBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter : TaskAdapter
    private lateinit var listener : TaskAdapter.OnItemClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentTaskManagerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView

        // todo : voir la meilleur façon de création des événement avec kotlin
        this.listener = object : TaskAdapter.OnItemClickListener {
            override fun onItemClick(task: TaskEntry) {

                val action = TaskManagerFragmentDirections.actionTaskManagerFragmentToTaskFormFragment(taskid = task.id )
                view.findNavController().navigate(action)
//                val intent = Intent(applicationContext, TaskFormActivity::class.java)
//                intent.putExtra("taskId", task.id)
//                startForResult.launch(intent)
            }
        }


        this.taskAdapter =  TaskAdapter(listener)
        binding.apply {
            // Todo version 2 : Ajoutez la possibilité de choisir le layoutManager depuis un button sur le menu
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter =  taskAdapter
            floatingActionButton.setOnClickListener{
                val action = TaskManagerFragmentDirections.actionTaskManagerFragmentToTaskFormFragment(taskid = 0 )
                view.findNavController().navigate(action)
            }

        }



    }

    /**
     * Frees the binding object when the Fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

    }



//    // todo : Recherche : SuppressLint
//    @SuppressLint("SuspiciousIndentation")
//    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//            result: ActivityResult ->
//        if (result.resultCode == Activity.RESULT_OK) {
//            val intent = result.data
//
//            val message = result.data!!.extras?.getString("keyName")
//                ?: "No Result Provided"
//
//            this.taskAdapter.notifyDataSetChanged()
//            Toast.makeText(applicationContext,message, Toast.LENGTH_LONG)
//
//        }
//    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.layout_menu, menu)
//        return true
//    }
}