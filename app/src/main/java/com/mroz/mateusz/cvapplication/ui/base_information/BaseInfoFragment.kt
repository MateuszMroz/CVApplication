package com.mroz.mateusz.cvapplication.ui.base_information


import android.content.Intent
import android.net.Uri
import android.net.Uri.fromParts
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.mroz.mateusz.cvapplication.R
import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_base_information.*
import kotlinx.android.synthetic.main.fragment_base_information.loading_state
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class BaseInfoFragment : DaggerFragment(), BaseInfoView, BaseInfoRouter {
    companion object {
        @JvmStatic
        fun newInstance() = BaseInfoFragment()
    }

    private lateinit var rxPermissions: RxPermissions

    @Inject
    lateinit var presenter: BaseInfoPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout: Int = R.layout.fragment_base_information
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        rxPermissions = RxPermissions(this)

        //presenter.loadBaseInformation()
        onSelect()
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
                base_info_root,
                text,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun inputBaseInfo(baseInfo: BaseInfo) {
        address_tv.text = baseInfo.address
        phone_tv.text = baseInfo.phoneNumber
        mail_tv.text = baseInfo.mail
        github_tv.text = baseInfo.github
        linkedin_tv.text = baseInfo.linkedIn
    }

    override fun navigateLocation(location: String) {
        val map = "http://maps.google.co.in/maps?q=$location"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(map))
        startActivity(intent)
    }

    override fun navigatePhone(phoneNumber: String) {
        val result = rxPermissions
            .request(android.Manifest.permission.CALL_PHONE)
            .subscribe {
                if (it) {
                    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
                    startActivity(intent)
                } else {
                    showMessage(getString(R.string.accept_permission))
                }
            }

    }

    override fun navigateMail(mail: String) {
        val emailIntent = Intent(
            Intent.ACTION_SENDTO, fromParts(
                "mailto", mail, null
            )
        )
        startActivity(Intent.createChooser(emailIntent, "Send email..."))
    }

    override fun navigateGithub(githubAddress: String) {
        openBrowser(githubAddress)
    }

    override fun navigateLinkedIn(linkedInAddress: String) {
        openBrowser(linkedInAddress)
    }

    private fun openBrowser(website: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(website)
        if (intent.resolveActivity(context?.packageManager) != null)
            startActivity(intent)
        else
            showMessage("Cannot open any activity.")
    }

    private fun onSelect() {
        address_layout_cv.setOnClickListener { navigateLocation(presenter.baseInfo.address) }
        phone_layout_cv.setOnClickListener { navigatePhone(presenter.baseInfo.phoneNumber) }
        mail_layout_cv.setOnClickListener { navigateMail(presenter.baseInfo.mail) }
        github_layout_cv.setOnClickListener { navigateGithub(presenter.baseInfo.github) }
        linkedin_layout_cv.setOnClickListener { navigateLinkedIn(presenter.baseInfo.linkedIn) }
    }

}
