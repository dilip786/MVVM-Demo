package com.kotlin.mvvmdemo.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.mvvmdemo.model.ImageDO
import com.kotlin.mvvmdemo.model.PixabayResponseDO
import com.kotlin.mvvmdemo.webservices.ApiClient
import com.kotlin.mvvmdemo.webservices.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageListViewModel : ViewModel() {

    var images: MutableLiveData<ArrayList<ImageDO>>? = null
    var errorMessage: MutableLiveData<String>? = null

    init {
        // Call webservice.
        fetchImages();
        images = MutableLiveData()
        errorMessage = MutableLiveData()
    }

    fun getImages(): LiveData<ArrayList<ImageDO>>? {
        return images;
    }

     fun getError(): LiveData<String>? {
        return errorMessage;
    }

    private fun fetchImages() {

        val apiService = ApiClient.client!!.create(ApiInterface::class.java)
        val call = apiService.getImages(
            "13745654-0d7421681193bbdba054b8959",
            "trees",
            true,
            100,
            1
        )

        call.enqueue(object : Callback<PixabayResponseDO> {
            override fun onResponse(
                call: Call<PixabayResponseDO>,
                response: Response<PixabayResponseDO>
            ) {
                images!!.value = response!!.body()!!.getImages();
            }

            override fun onFailure(call: Call<PixabayResponseDO>, t: Throwable) {
                errorMessage!!.value = t.localizedMessage
            }
        })
    }

}