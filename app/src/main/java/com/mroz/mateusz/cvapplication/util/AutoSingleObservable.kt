package com.mroz.mateusz.cvapplication.util

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver


abstract class AutoSingleObservable<T>(private val disposable: CompositeDisposable):
    DisposableSingleObserver<T>() {

    override fun onStart() {
        super.onStart()
        disposable.add(this)
    }

    abstract fun success(t:T)
    override fun onSuccess(t: T) {
        try {
            success(t)
        } finally {
            disposable.remove(this)
        }
    }

    abstract fun error(e: Throwable)
    override fun onError(e: Throwable) {
        try {
            error(e)
        } finally {
            disposable.remove(this)
        }
    }
}