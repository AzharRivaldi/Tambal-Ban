package com.azhar.tambalban.data.model.nearby

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Azhar Rivaldi on 06-06-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 */

class ModelResults : Serializable {
    @SerializedName("geometry")
    lateinit var modelGeometry: ModelGeometry

    @SerializedName("name")
    lateinit var name: String

    @SerializedName("vicinity")
    lateinit var vicinity: String

    @SerializedName("place_id")
    lateinit var placeId: String

    @SerializedName("rating")
    var rating = 0.0
}