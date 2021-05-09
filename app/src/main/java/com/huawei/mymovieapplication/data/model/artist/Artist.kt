package com.huawei.mymovieapplication.data.model.artist

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artists")
data class Artist(

        @PrimaryKey
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")//eğer farklı bir isim kullanmak istersek bu şekilde yapıyoruz=> @ColumnInfo(name ="artist_name")
        val name: String,
        @SerializedName("popularity")
        val popularity: Double,
        @SerializedName("profile_path")
        val profilePath: String
)