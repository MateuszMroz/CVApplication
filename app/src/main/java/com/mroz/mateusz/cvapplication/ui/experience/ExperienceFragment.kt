package com.mroz.mateusz.cvapplication.ui.experience


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
import com.mroz.mateusz.cvapplication.ui.experience.adapter.ExperienceAdapter
import com.mroz.mateusz.cvapplication.ui.experience.adapter.ExperienceGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_experience.*
import kotlinx.android.synthetic.main.fragment_experience.loading_state
import kotlinx.android.synthetic.main.fragment_skills.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ExperienceFragment : DaggerFragment(), ExperienceView {
    companion object {
        @JvmStatic
        fun newInstance() = ExperienceFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout: Int = R.layout.fragment_experience
        return inflater.inflate(layout, container, false)
    }

    @Inject
    lateinit var presenter: ExperiencePresenter
    lateinit var adapter: ExperienceAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        presenter.loadExperience()
    }

    override fun loadExperienceList(listExperience: List<ExperienceGroup>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        adapter = ExperienceAdapter(listExperience)
        experience_rv.layoutManager = layoutManager
        experience_rv.adapter = adapter
    }

    override fun showLoader() {
        CoroutineScope(Dispatchers.Main).launch {
            loading_state?.let {
                loading_state.visibility = View.VISIBLE
            }
        }
    }

    override fun hideLoader() {
        CoroutineScope(Dispatchers.Main).launch {
            loading_state?.let {
                it.visibility = View.GONE
            }
        }
    }

    override fun showMessage(text: String) {
        CoroutineScope(Dispatchers.Main).launch {
            Snackbar.make(
                experience_root,
                text,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}
