package com.mroz.mateusz.cvapplication.ui.experience.model

import android.os.Parcel
import android.os.Parcelable

data class Task(val taskName: String) : Parcelable {
    constructor(parcel: Parcel) : this(
       parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(taskName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Task> {
        override fun createFromParcel(parcel: Parcel): Task {
            return Task(parcel)
        }

        override fun newArray(size: Int): Array<Task?> {
            return arrayOfNulls(size)
        }
    }

}