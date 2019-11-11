package com.mroz.mateusz.cvapplication.ui.skills

import com.mroz.mateusz.cvapplication.api.ApiService
import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillsGroup
import com.mroz.mateusz.cvapplication.ui.skills.model.Skill
import com.mroz.mateusz.cvapplication.ui.skills.model.SkillDetails
import com.mroz.mateusz.cvapplication.util.AutoSingleObservable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SkillsPresenter @Inject constructor(private val apiService: ApiService) {

    @Inject
    lateinit var disposable: CompositeDisposable
    lateinit var view: SkillsView

    fun loadSkills() {
        view.showLoader()
        apiService.getSkills()
            .subscribeOn(Schedulers.io())
            .map {
                mapToExpandableList(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : AutoSingleObservable<List<SkillsGroup>>(disposable) {
                override fun success(t: List<SkillsGroup>) {
                    view.hideLoader()
                    view.loadSkillList(t)
                }

                override fun error(e: Throwable) {
                    view.hideLoader()
                    view.showMessage(e.message.toString())
                    e.printStackTrace()
                }

            })
    }

    private fun mapToExpandableList(list: List<Skill>): List<SkillsGroup> {
        val expandableList = mutableListOf<SkillsGroup>()
        for (skill in list) {
            val title = skill.skillType
            val listSkill: List<SkillDetails>? = skill.listSkill

            val expandableGroup = SkillsGroup(title, listSkill ?: emptyList())
            expandableList.add(expandableGroup)
        }

        return expandableList
    }
}