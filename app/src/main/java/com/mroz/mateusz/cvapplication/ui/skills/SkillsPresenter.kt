package com.mroz.mateusz.cvapplication.ui.skills

import com.mroz.mateusz.cvapplication.data.remote.ApiService
import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillsGroup
import com.mroz.mateusz.cvapplication.ui.skills.model.Skill
import com.mroz.mateusz.cvapplication.ui.skills.model.SkillDetails
import com.mroz.mateusz.cvapplication.util.AutoSingleObservable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class SkillsPresenter @Inject constructor(private val apiService: ApiService) {

    lateinit var view: SkillsView

    fun loadSkills() {
        view.showLoader()
        CoroutineScope(IO).launch {
            try {
                val result = mapToExpandableList(apiService.getSkills())
                view.loadSkillList(result)
                view.hideLoader()
            } catch (e: Exception) {
                e.printStackTrace()
                view.showMessage(e.message.toString())
                view.hideLoader()
            }

        }
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