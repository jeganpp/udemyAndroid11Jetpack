package com.example.section10_retrofitdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.section10_retrofitdemo1.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
        val responseLiveData:LiveData<Response<Albums>> = liveData {
            val response:Response<Albums> = retrofitService.getAlbums()
            emit(response)
        }
        responseLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if(albumList != null) {
                while (albumList.hasNext()) {
                    val albumsItem = albumList.next()
                    Log.i("Jegan", "${albumsItem.title}")
                    val result = " " + "Album id: ${albumsItem.id}" + "\n" +
                            " " + "Album title: ${albumsItem.title}" + "\n" +
                            " " + "Album userId: ${albumsItem.userId}" + "\n\n\n"
                    binding.textView3.append(result)
                }
            }
        })
    }
}