package com.mroz.mateusz.cvapplication.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import com.mroz.mateusz.cvapplication.ui.list_section.ListSectionFragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainView, HasSupportFragmentInjector {
    @Inject
    lateinit var dispatcherAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            setFragment(ListSectionFragment.newInstance())
        }
        presenter.view = this
        //presenter.loadBaseInfo()
    }

    override fun supportFragmentInjector() = dispatcherAndroidInjector

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, fragment)
            .commit()
    }

    override fun updateBaseInfo(baseInfo: BaseInfo) {
        setSupportActionBar(toolbar)
        supportActionBar?.title = baseInfo.name
        base_info_tv.text = baseInfo.about
    }

    override fun showLoader() {
        loading_state.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        loading_state.visibility = View.GONE
    }

    override fun showMessage(text: String?) {
        Snackbar.make(
            coordinator_layout,
            text ?: getString(R.string.unknown_message), Snackbar.LENGTH_LONG
        ).show()
    }
}

