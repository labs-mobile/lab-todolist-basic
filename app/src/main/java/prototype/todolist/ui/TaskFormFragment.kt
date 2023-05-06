package prototype.todolist.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import prototype.todolist.R
import prototype.todolist.data.TaskEntry
import prototype.todolist.data.TaskRepository
import prototype.todolist.databinding.ActivityTaskFormBinding
import prototype.todolist.databinding.FragmentTaskFormBinding

class TaskFormFragment : Fragment() {

    companion object {
        val TASKID = "taskid"
    }


    private var _binding: FragmentTaskFormBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var taskId =  0


    private val taskRepository = TaskRepository()
    private lateinit var task : TaskEntry


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve the LETTER from the Fragment arguments
        arguments?.let {

            taskId = it.getInt(TASKID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentTaskFormBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Add
        if(taskId == 0){
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
                    Toast.makeText(context, "It's empty!", Toast.LENGTH_SHORT).show()
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

                Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()
            }
            btnDelete.setOnClickListener {
                taskRepository.delete(taskId!!)

                val action = TaskFormFragmentDirections.actionTaskFormFragmentToTaskManagerFragment()
                view.findNavController().navigate(action)

            }

        }




//        title = "éditer $taskId"


//        val recyclerView = binding.recyclerView
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        recyclerView.adapter = WordAdapter(letterId, requireContext())
//
//        // Adds a [DividerItemDecoration] between items
//        recyclerView.addItemDecoration(
//            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
//        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}