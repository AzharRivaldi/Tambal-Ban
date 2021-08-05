package com.azhar.tambalban.data.model.details

import com.google.gson.annotations.SerializedName

/**
 * Created by Azhar Rivaldi on 24-07-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class ModelOpening {
    @SerializedName("open_now")
    var openNow: Boolean? = null

    @SerializedName("weekday_text")
    lateinit var weekdayText: List<String>
}