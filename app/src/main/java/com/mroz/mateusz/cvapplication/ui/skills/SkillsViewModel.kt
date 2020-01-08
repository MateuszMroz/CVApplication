package com.mroz.mateusz.cvapplication.ui.skills

import androidx.lifecycle.ViewModel
import com.mroz.mateusz.cvapplication.data.remote.ApiService
import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillsGroup
import com.mroz.mateusz.cvapplication.ui.skills.model.Skill
import com.mroz.mateusz.cvapplication.ui.skills.model.SkillDetails
import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class SkillsViewModel @Inject constructor(private val apiService: ApiService) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job + handlerException

    private val handlerException = CoroutineExceptionHandler { _, exception ->
        Timber.d("$exception handled !")
        exception.printStackTrace()
        view.showMessage(exception.message.toString())
        view.hideLoader()
    }

    private val job: Job = Job()

    lateinit var view: SkillsView

    fun loadSkills() {
        view.showLoader()
        launch {
            val result = mapToExpandableList(apiService.getSkills())
            view.loadSkillList(result)
            view.hideLoader()
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

    fun destroy() {
        job.cancel()
    }

}