package com.shrutipandit.alarmsk

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.shrutipandit.alarmsk.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService = ApiClient.create()
        val call: Call<List<Photo>> = apiService.getPhotos()

        call.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    val photos: List<Photo>? = response.body()

                    // Assuming photos is not null and contains at least one item
                    val firstPhoto: Photo? = photos?.get(0)

                    // Display relevant information in TextView
                    firstPhoto?.let {
                        val textView: TextView = findViewById(R.id.tv)
                        textView.text = "Title: ${it.title}\nUrl: }"
                    }

                    // Use Glide to load and set the image
//                    val firstPhotoUrl: String = firstPhoto? ""
//                    Glide.with(this@MainActivity)
//                        .load(firstPhotoUrl)
//                        .into(binding.img.phto)
                } else {
                    // Handle error
                    Log.e("MainActivity", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                // Handle failure
                Log.e("MainActivity", "Failure: ${t.message}")
            }
        })
    }
}
