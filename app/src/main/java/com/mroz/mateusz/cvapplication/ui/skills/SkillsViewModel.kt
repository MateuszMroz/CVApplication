package com.mroz.mateusz.cvapplication.ui.skills

import androidx.lifecycle.*
import com.mroz.mateusz.cvapplication.data.DefaultCvRepository
import com.mroz.mateusz.cvapplication.data.Result
import com.mroz.mateusz.cvapplication.ui.skills.adapter.SkillsGroup
import com.mroz.mateusz.cvapplication.ui.skills.model.Skill
import com.mroz.mateusz.cvapplication.ui.skills.model.SkillDetails
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class SkillsViewModel @Inject constructor(private val defaultCvRepository: DefaultCvRepository) :
    ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Main + job + handlerException

    private var _skills = MutableLiveData<List<Skill>>()
    val skills: LiveData<List<SkillsGroup>> = Transformations.map(_skills) {
        mapToExpandableList(it)
    }

    private val _dataLoading = MutableLiveData<Boolean>()
    var dataLoading: LiveData<Boolean> = _dataLoading

    private val job: Job = Job()

    private val handlerException = CoroutineExceptionHandler { _, exception ->
        Timber.d("$exception handled !")
        exception.printStackTrace()
    }

    init {
        loadSkills()
    }

    private fun loadSkills() {
        _dataLoading.value = true
        viewModelScope.launch {
            val result = defaultCvRepository.getSkills()
            if (result is Result.Success) {
                setSkills(result.data)
            } else {
                onDataNotAvailable()
            }
            _dataLoading.value = false
        }
    }

    private fun setSkills(skills: List<Skill>) {
        _skills.value = skills
    }

    private fun onDataNotAvailable() {
        _skills.value = null
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

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}