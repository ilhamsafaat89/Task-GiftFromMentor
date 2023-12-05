package com.task.taskgift.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.task.taskgift.R
import com.task.taskgift.nilai.adapter.RecycleViewNilaiWaliAdapter
import com.task.taskgift.nilai.data.NilaiWali

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NilaiWaliFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NilaiWaliFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_nilai_wali, container, false)

        recyclerView = view.findViewById(R.id.rvNilaiList)

        val NilaiWaliList = SampleDataList()
        val adapter = RecycleViewNilaiWaliAdapter(NilaiWaliList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        return view
    }

    private fun SampleDataList(): List<NilaiWali>{
        return listOf(
            NilaiWali("Biologi", 80f, 70f, 80f, 90f),
            NilaiWali("Matematika", 70f,80f,90f, 90f),
            NilaiWali("B.Inggris", 90f, 100f, 70f, 50f),
            NilaiWali("B.Indonesia", 40f, 50f, 60f, 70f),
            NilaiWali("Fisika", 60f, 70f, 80f, 90f,)
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NilaiWaliFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NilaiWaliFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}