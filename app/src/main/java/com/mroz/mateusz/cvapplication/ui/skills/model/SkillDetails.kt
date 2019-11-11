package com.mroz.mateusz.cvapplication.ui.skills.model

import android.os.Parcel
import android.os.Parcelable

data class SkillDetails(
    val skill: String,
    val skillLevel: Float
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readFloat()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(skill)
        parcel.writeFloat(skillLevel)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SkillDetails> {
        override fun createFromParcel(parcel: Parcel): SkillDetails {
            return SkillDetails(parcel)
        }

        override fun newArray(size: Int): Array<SkillDetails?> {
            return arrayOfNulls(size)
        }
    }
}