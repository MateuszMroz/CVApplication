package com.mroz.mateusz.cvapplication.ui.skills


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillAdapter
import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillsGroup
import com.mroz.mateusz.cvapplication.viewModelFactory.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_skills.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SkillsFragment : DaggerFragment() {
    companion object {
        @JvmStatic
        fun newInstance() = SkillsFragment()
    }

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory
    lateinit var viewModel: SkillsViewModel

    var adapter: SkillAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, providerFactory).get(SkillsViewModel::class.java)
    }

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
        subscribeSkills()
        subscribeDataLoading()
    }

    private fun subscribeSkills() {
        viewModel.skills.removeObservers(viewLifecycleOwner)
        viewModel.skills.observe(viewLifecycleOwner, Observer {
            loadSkillList(it)
        })
    }

    private fun subscribeDataLoading() {
        viewModel.dataLoading.observe(viewLifecycleOwner, Observer {
            if (it)
                showLoader()
            else
                hideLoader()
        })
    }

    fun showLoader() {
        loading_state?.let {
            loading_state.visibility = View.VISIBLE
        }
    }

    fun hideLoader() {
        loading_state?.let {
            it.visibility = View.GONE
        }
    }

    fun showMessage(text: String) {
        CoroutineScope(Main).launch {
            Snackbar.make(
                skills_root,
                text,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    private fun loadSkillList(listSkills: List<SkillsGroup>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        adapter = SkillAdapter(listSkills)
        skills_rv.layoutManager = layoutManager
        skills_rv.adapter = adapter
    }
}
