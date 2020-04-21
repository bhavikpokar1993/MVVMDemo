package com.niravjoshi.proof_of_concept.concepts.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * [FeedDetailDTO] : Database class defined to provide and store data using [FeedDetailDTO] for [RoomDatabase] as ORM help for this project.
 *
 * @author Nirav Joshi
 * @since 10/15/2019
 * @version 1.0.0
 */

class FeedDetailDTO(
    @SerializedName("id")
    var mId: Long,

    @SerializedName("title")
    var mTitle: String?,

    @SerializedName("description")
    var mDescription: String?,

    @SerializedName("imageHref")
    var mImageUrl: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(mId)
        parcel.writeString(mTitle)
        parcel.writeString(mDescription)
        parcel.writeString(mImageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FeedDetailDTO> {
        override fun createFromParcel(parcel: Parcel): FeedDetailDTO {
            return FeedDetailDTO(parcel)
        }

        override fun newArray(size: Int): Array<FeedDetailDTO?> {
            return arrayOfNulls(size)
        }
    }
}



