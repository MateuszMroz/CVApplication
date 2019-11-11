package com.mroz.mateusz.cvapplication.ui

import com.mroz.mateusz.cvapplication.RxImmediateSchedulerRule
import com.mroz.mateusz.cvapplication.api.ApiService
import com.mroz.mateusz.cvapplication.ui.base_information.model.BaseInfo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import java.lang.RuntimeException


class MainPresenterTest {

    @Rule
    @JvmField
    val rule = MockitoJUnit.rule()

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    lateinit var mainPresenter: MainPresenter
    lateinit var apiService: ApiService
    lateinit var baseInfo: BaseInfo

    @Before
    fun setUp() {
        mainPresenter = Mockito.mock(MainPresenter::class.java)
        apiService = Mockito.mock(ApiService::class.java)
        baseInfo = prepareData()
    }

    @Test
    fun loadBaseInfoCorrectWay() {
        //given
        val subscriber: TestObserver<BaseInfo> = TestObserver()
        given(apiService.getBaseInformation()).willReturn(Single.just(baseInfo))

        //when
        apiService.getBaseInformation()
            .subscribe(subscriber)

        //then
        subscriber.assertComplete()
        subscriber.assertNoErrors()

        val result = subscriber.values()[0]

        assertThat(result.name, `is`("Jan Kowalski"))
        assertThat(result.about, `is`("About Jan Kowalski"))
        assertThat(result.picture, `is`("https:/google.pl"))
        assertThat(result.address, `is`("Nuszkiewicza 3/11. Kraków"))
        assertThat(result.phoneNumber, `is`("123456789"))
        assertThat(result.mail, `is`("mateusz.mroz10@gmail.com"))
        assertThat(result.github, `is`("Mroz"))
        assertThat(result.linkedIn, `is`("Mateusz"))
    }

    @Test
    fun loadBaseInfoError() {
        //given
        val subscriber: TestObserver<BaseInfo> = TestObserver()
        given(apiService.getBaseInformation()).willReturn(Single.error(RuntimeException("error")))

        //when
        apiService.getBaseInformation()
            .subscribe(subscriber)

        //then
        subscriber.assertError(RuntimeException::class.java)
        subscriber.assertNotComplete()
    }

    private fun prepareData(): BaseInfo = BaseInfo(
        "Jan Kowalski",
        "About Jan Kowalski",
        "https:/google.pl",
        "Nuszkiewicza 3/11. Kraków",
        "123456789",
        "mateusz.mroz10@gmail.com",
        "Mroz",
        "Mateusz"
    )
}