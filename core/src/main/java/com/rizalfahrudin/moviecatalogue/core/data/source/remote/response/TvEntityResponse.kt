package com.rizalfahrudin.moviecatalogue.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvEntityResponse(

    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("original_name")
    var original_name: String? = null,

    @field:SerializedName("overview")
    var overview: String? = null,

    @field:SerializedName("poster_path")
    var poster_path: String? = null
)