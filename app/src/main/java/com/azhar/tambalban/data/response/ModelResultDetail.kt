package com.azhar.tambalban.data.response

import com.azhar.tambalban.data.model.details.ModelDetail
import com.google.gson.annotations.SerializedName

/**
 * Created by Azhar Rivaldi on 10-06-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * Linkedin : https://www.linkedin.com/in/azhar-rivaldi
 */

class ModelResultDetail {
    @SerializedName("result")
    lateinit var modelDetail: ModelDetail
}