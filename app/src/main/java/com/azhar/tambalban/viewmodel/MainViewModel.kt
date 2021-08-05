package com.azhar.tambalban.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azhar.tambalban.data.model.details.ModelDetail
import com.azhar.tambalban.data.model.nearby.ModelResults
import com.azhar.tambalban.data.response.ModelResultDetail
import com.azhar.tambalban.data.response.ModelResultNearby
import com.azhar.tambalban.networking.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by Azhar Rivaldi on 18-07-2021
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

class MainViewModel : ViewModel() {

    private val modelResultsMutableLiveData = MutableLiveData<ArrayList<ModelResults>>()
    private val modelDetailMutableLiveData = MutableLiveData<ModelDetail>()

    companion object {
        var strApiKey = "YOUR API KEY"
    }

    fun setMarkerLocation(strLocation: String) {
        val apiService = ApiClient.getClient()
        val call = apiService.getDataResult(strApiKey, "Tambal Ban", strLocation, "distance")
        call.enqueue(object : Callback<ModelResultNearby> {
            override fun onResponse(call: Call<ModelResultNearby>, response: Response<ModelResultNearby>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    val items = ArrayList(response.body()!!.modelResults)
                    modelResultsMutableLiveData.postValue(items)
                }
            }

            override fun onFailure(call: Call<ModelResultNearby>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }

    fun setDetailLocation(strPlaceID: String) {
        val apiService = ApiClient.getClient()
        val call = apiService.getDetailResult(strApiKey, strPlaceID)
        call.enqueue(object : Callback<ModelResultDetail> {
            override fun onResponse(call: Call<ModelResultDetail>, response: Response<ModelResultDetail>) {
                if (!response.isSuccessful) {
                    Log.e("response", response.toString())
                } else if (response.body() != null) {
                    modelDetailMutableLiveData.postValue(response.body().modelDetail)
                }
            }

            override fun onFailure(call: Call<ModelResultDetail>, t: Throwable) {
                Log.e("failure", t.toString())
            }
        })
    }

    fun getMarkerLocation(): LiveData<ArrayList<ModelResults>> = modelResultsMutableLiveData

    fun getDetailLocation(): LiveData<ModelDetail> = modelDetailMutableLiveData

}