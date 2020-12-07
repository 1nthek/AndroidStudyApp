package com.example.androidstudyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androidstudyapp.databinding.FragmentThirdBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ThirdFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentThirdBinding.bind(view)
        binding.btnDialog1.setOnClickListener {
            activity?.let {
                AlertDialog.Builder(it)
                        .setTitle("Add Contact")
                        .setMessage("Do you want to Add ~")
                        .setIcon(R.drawable.ic_add_contact)
                        .setPositiveButton("Yes") { _, _ ->
                            Toast.makeText(activity, "You added ~", Toast.LENGTH_SHORT).show()
                        }
                        .setNegativeButton("No") { _, _ ->
                            Toast.makeText(activity, "You didn't added ~", Toast.LENGTH_SHORT)
                                    .show()
                        }
                        .create()
            }?.show()
        }

        val options = arrayOf("First Item", "Second Item", "Third Item")
        binding.btnDialog2.setOnClickListener {
            activity?.let { it1 ->
                AlertDialog.Builder(it1)
                        .setTitle("Choose one of these options")
                        .setSingleChoiceItems(options, 0) { _, i ->
                            Toast.makeText(activity, "You Clicked on ${options[i]}", Toast
                                    .LENGTH_SHORT)
                                    .show()
                        }
                        .setPositiveButton("Accept") { _, _ ->
                            Toast.makeText(activity, "You accepted the SingleChoiseDialog", Toast
                                    .LENGTH_SHORT)
                                    .show()
                        }
                        .setNegativeButton("Decline") { _, _ ->
                            Toast.makeText(activity, "You declined the SingleChoiceDialog", Toast
                                    .LENGTH_SHORT).show()
                        }
            }?.show()
        }
        binding.btnDialog3.setOnClickListener {
            activity?.let { it1 ->
                AlertDialog.Builder(it1)
                        .setTitle("Choose one of these options")
                        .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                            if (isChecked) {
                                Toast.makeText(activity, "You checked ${options[i]}", Toast
                                        .LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(activity, "You unchecked ${options[i]}", Toast
                                        .LENGTH_SHORT).show()
                            }
                        }
                        .setPositiveButton("Accept") { _, _ ->
                            Toast.makeText(activity, "You accepted the ~", Toast.LENGTH_SHORT).show()
                        }
                        .setNegativeButton("Decline") { _, _ ->
                            Toast.makeText(activity, "You declined the ~", Toast
                                    .LENGTH_SHORT).show()
                        }
                        .create()
            }?.show()
        }

        val customList = listOf("First", "Second", "Third", "Fourth")
        val adapter = activity?.let {
            ArrayAdapter<String>(it, R.layout
                .support_simple_spinner_dropdown_item, customList)
        }
        binding.spMonths.adapter = adapter

        binding.spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(activity, "You selected ${
                    parent?.getItemAtPosition(position)
                            .toString()
                }", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }
}
















