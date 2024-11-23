package com.example.project_mobile.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_mobile.R
import com.example.project_mobile.SearchBarView
import com.example.project_mobile.adapters.BlogCardAdapter
import com.example.project_mobile.adapters.ClinicCardAdapter
import com.example.project_mobile.adapters.DoctorCardAdapter
import com.example.project_mobile.adapters.HealthServiceAdapter
import com.example.project_mobile.models.Blog
import com.example.project_mobile.models.Clinic
import com.example.project_mobile.models.HealthService
import com.example.project_mobile.models.User
import com.example.project_mobile.utils.SpacingItemDecorator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomepageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomepageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view= inflater.inflate(R.layout.fragment_homepage, container, false)

        val searchBar = view.findViewById<SearchBarView>(R.id.searchBar)

        searchBar.disableChildFocus()

        searchBar.setOnFilterListener {
            val searchText = searchBar.getSearchText()

            Toast.makeText(view.context, searchText, Toast.LENGTH_SHORT).show()
        }

        searchBar.setOnSearchBarClickListener {
            Toast.makeText(view.context, "Search bar clicked", Toast.LENGTH_SHORT).show()
        }

        val healthServices = ArrayList<HealthService>() // Create a list of health services
        healthServices.add(HealthService(1, "Tooth", R.drawable.tooth))
        healthServices.add(HealthService(2, "Eye", R.drawable.eye))
        healthServices.add(HealthService(3, "Lungs", R.drawable.lung))
        healthServices.add(HealthService(4, "Ear", R.drawable.ear))
        healthServices.add(HealthService(5, "Heart", R.drawable.heart))
        healthServices.add(HealthService(6, "Stomach", R.drawable.stomach))
        healthServices.add(HealthService(7, "Intestines", R.drawable.intestine))
        healthServices.add(HealthService(8, "Blood", R.drawable.red_blood_cells))

        val healthServiceRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewHealthServices)
        healthServiceRecyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        healthServiceRecyclerView.setHasFixedSize(true)

        val itemDecorator = SpacingItemDecorator(12, 0, 0, 0, true)
        healthServiceRecyclerView.addItemDecoration(itemDecorator)

        val healthServiceAdapter = HealthServiceAdapter(healthServices)
        healthServiceRecyclerView.adapter = healthServiceAdapter

        healthServiceAdapter.setOnClickListener(object : HealthServiceAdapter.OnClickListener {
            override fun onItemClick(position: Int, healthService: HealthService) {
                Toast.makeText(view.context, healthService.name, Toast.LENGTH_SHORT).show()
            }
        })

        val txtSeeAllHealthServices = view.findViewById<View>(R.id.txtSeeAllHealthServices)
        txtSeeAllHealthServices.setOnClickListener {
            showAllHealthServicesBottomSheet()
        }

        val doctors = ArrayList<User>()
        doctors.add(
            User(
                1,
                "Dr. John Doe",
                "johndo@gmail.com",
                "098413123",
                "123456",
                "doctor1",
                "123 Main St, New York, NY",
                "Doctor",
                "General Practitioner"
            )
        )
        doctors.add(
            User(
                2,
                "Dr. John Doe",
                "johndo@gmail.com",
                "098413123",
                "123456",
                "doctor1",
                "123 Main St, New York, NY",
                "Doctor",
                "General Practitioner"
            )
        )
        doctors.add(
            User(
                3,
                "Dr. John Doe",
                "johndo@gmail.com",
                "098413123",
                "123456",
                "doctor1",
                "123 Main St, New York, NY",
                "Doctor",
                "General Practitioner"
            )
        )

        val doctorsRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewDoctors)
        doctorsRecyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        doctorsRecyclerView.setHasFixedSize(true)

        val itemDecorator2 = SpacingItemDecorator(12, 0, 0, 0, true)
        doctorsRecyclerView.addItemDecoration(itemDecorator2)

        val doctorCardAdapter = DoctorCardAdapter(doctors)
        doctorsRecyclerView.adapter = doctorCardAdapter

        doctorCardAdapter.setOnClickListener(object : DoctorCardAdapter.OnClickListener {
            override fun onItemClick(position: Int, doctor: User) {
                Toast.makeText(view.context, doctor.name, Toast.LENGTH_SHORT).show()
            }

            override fun onHeartButtonClick(position: Int, doctor: User) {
                Toast.makeText(view.context, "Heart button clicked", Toast.LENGTH_SHORT).show()
            }
        })

        val clinics = ArrayList<Clinic>()
        clinics.add(
            Clinic(
                1,
                "Clinic Emory",
                "123 Main St, New York, NY",
                "098413123",
                "clinic1",
                4.5f,
                "This is a clinic",
                healthServices
            )
        )
        clinics.add(
            Clinic(
                2,
                "Clinic Emory",
                "123 Main St, New York, NY",
                "098413123",
                "clinic1",
                4.5f,
                "This is a clinic",
                healthServices
            )
        )
        clinics.add(
            Clinic(
                3,
                "Clinic Emory",
                "123 Main St, New York, NY",
                "098413123",
                "clinic1",
                4.5f,
                "This is a clinic",
                healthServices
            )
        )

        val clinicsRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewClinics)
        clinicsRecyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        clinicsRecyclerView.setHasFixedSize(true)

        val itemDecorator3 = SpacingItemDecorator(12, 0, 0, 0, true)
        clinicsRecyclerView.addItemDecoration(itemDecorator3)

        val clinicCardAdapter = ClinicCardAdapter(clinics)
        clinicsRecyclerView.adapter = clinicCardAdapter

        clinicCardAdapter.setOnClickListener(object : ClinicCardAdapter.OnClickListener {
            override fun onItemClick(position: Int, clinic: Clinic) {
                Toast.makeText(view.context, clinic.name, Toast.LENGTH_SHORT).show()
            }

            override fun onHeartButtonClick(position: Int, clinic: Clinic) {
                Toast.makeText(view.context, "Heart button clicked", Toast.LENGTH_SHORT).show()
            }
        })

        // class Blog(
        //    var title: String,
        //    var description: String,
        //    var image: String,
        //    var date: String,
        //    var rating: Int,
        //    var author: User,
        //) {
        //    override fun toString(): String {
        //        return "Blog(title='$title', description='$description', image='$image', date='$date', author=$author)"
        //    }
        //}

        val blogs = ArrayList<Blog>()
        blogs.add(
            Blog(
                "Blog 1",
                "This is a blog",
                "https://www.google.com",
                "2021-09-01",
                4,
                doctors[0]
            )
        )

        blogs.add(
            Blog(
                "Blog 2",
                "This is a blog",
                "https://www.google.com",
                "2021-09-01",
                4,
                doctors[1]
            )
        )

        blogs.add(
            Blog(
                "Blog 3",
                "This is a blog",
                "https://www.google.com",
                "2021-09-01",
                4,
                doctors[2]
            )
        )

        val blogsRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewBlogs)
        blogsRecyclerView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        blogsRecyclerView.setHasFixedSize(true)

        val itemDecorator4 = SpacingItemDecorator(12, 0, 0, 0, true)
        blogsRecyclerView.addItemDecoration(itemDecorator4)

        val blogCardAdapter = BlogCardAdapter(blogs)
        blogsRecyclerView.adapter = blogCardAdapter

        blogCardAdapter.setOnClickListener(object : BlogCardAdapter.OnClickListener {
            override fun onItemClick(position: Int, blog: Blog) {
                Toast.makeText(view.context, blog.title, Toast.LENGTH_SHORT).show()
            }

            override fun onHeartButtonClick(position: Int, blog: Blog) {
                Toast.makeText(view.context, "Heart button clicked", Toast.LENGTH_SHORT).show()
            }
        })

        return view
    }

    private fun showAllHealthServicesBottomSheet() {
        val dialog : Dialog = Dialog(this.requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.health_services_bottom_sheet)

        val cancelButton = dialog.findViewById<View>(R.id.cancelButton)
        val healthServiceRecyclerView = dialog.findViewById<RecyclerView>(R.id.healthServicesRecyclerView)

        val healthServices = ArrayList<HealthService>() // Create a list of health services
        healthServices.add(HealthService(1, "Tooth", R.drawable.tooth))
        healthServices.add(HealthService(2, "Eye", R.drawable.eye))
        healthServices.add(HealthService(3, "Lungs", R.drawable.lung))
        healthServices.add(HealthService(4, "Ear", R.drawable.ear))
        healthServices.add(HealthService(5, "Heart", R.drawable.heart))
        healthServices.add(HealthService(6, "Stomach", R.drawable.stomach))
        healthServices.add(HealthService(7, "Intestines", R.drawable.intestine))
        healthServices.add(HealthService(8, "Blood", R.drawable.red_blood_cells))

        healthServiceRecyclerView.layoutManager = GridLayoutManager(this.requireContext(), 3)
        healthServiceRecyclerView.setHasFixedSize(true)

        val itemDecorator = SpacingItemDecorator(12)
        healthServiceRecyclerView.addItemDecoration(itemDecorator)

        val healthServiceAdapter = HealthServiceAdapter(healthServices)
        healthServiceRecyclerView.adapter = healthServiceAdapter

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomepageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomepageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}