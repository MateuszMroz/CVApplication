package com.mroz.mateusz.cvapplication.ui.education


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.base.BaseFragment
import com.mroz.mateusz.cvapplication.ui.education.adapter.EducationAdapter
import com.mroz.mateusz.cvapplication.ui.education.model.Education
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_education.*
import kotlinx.android.synthetic.main.fragment_education.loading_state
import kotlinx.android.synthetic.main.fragment_skills.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class EducationFragment : DaggerFragment(), EducationView {
    companion object {
        @JvmStatic
        fun newInstance() = EducationFragment()
    }

    lateinit var job: CompletableJob

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout: Int = R.layout.fragment_education
        return inflater.inflate(layout, container, false)
    }

    @Inject
    lateinit var presenter: EducationPresenter
    private lateinit var adapter: EducationAdapter

    private fun initializeRecyclerView() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        adapter = EducationAdapter()
        education_rv.layoutManager = layoutManager
        education_rv.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeRecyclerView()
        presenter.view = this
        job = Job()
        CoroutineScope(IO + job).launch {
            val listOfEducation = presenter.loadEducationPosition(job)
            updateList(listOfEducation)
        }

        job.invokeOnCompletion {
            it?.message.let { msg ->
                if (msg.isNullOrBlank()) {
                    showMessage("Unknown error.")
                } else {
                    showMessage(msg)
                }
            }
        }
    }

    private suspend fun updateList(listEducation: List<Education>) {
        withContext(Main) {
            updateAdapter(listEducation)
        }
    }

    override fun showLoader() {
        CoroutineScope(Main).launch {
            loading_state?.let {
                loading_state.visibility = View.VISIBLE
            }
        }
    }

    override fun hideLoader() {
        CoroutineScope(Main).launch {
            loading_state?.let {
                it.visibility = View.GONE
            }
        }
    }

    override fun showMessage(text: String) {
        CoroutineScope(Main).launch {
            Snackbar.make(
                education_root,
                text,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun updateAdapter(listEducationPosition: List<Education>) {
        adapter.listEducationPosition = listEducationPosition as MutableList<Education>
    }
}
