package com.mroz.mateusz.cvapplication.ui.skills


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
import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillAdapter
import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillsGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_skills.*
import kotlinx.android.synthetic.main.fragment_skills.loading_state
import kotlinx.android.synthetic.main.please_wait_information.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SkillsFragment : DaggerFragment(), SkillsView {
    companion object {
        @JvmStatic
        fun newInstance() = SkillsFragment()
    }

    @Inject
    lateinit var presenter: SkillsPresenter
    var adapter: SkillAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout: Int = R.layout.fragment_skills
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        presenter.loadSkills()
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
                skills_root,
                text,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun loadSkillList(listSkills: List<SkillsGroup>) {
        CoroutineScope(Main).launch {
            val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
            adapter = SkillAdapter(listSkills)
            skills_rv.layoutManager = layoutManager
            skills_rv.adapter = adapter
        }
    }
}
