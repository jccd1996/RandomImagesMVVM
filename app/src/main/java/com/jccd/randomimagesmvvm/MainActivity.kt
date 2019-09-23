package com.jccd.randomimagesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  var model: MainActivityViewModel = MainActivityViewModel()

        var model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        val urlImage:MutableLiveData<String?>? = model.callUrlImage()

        urlImage?.observe(this, Observer {urlChange ->
            Picasso.get()
                .load(urlChange)
                .into(ivRandomPhoto)

            Picasso.get()
                .load(urlChange)
                .into(ivRandomPhoto2)
        })

        btnGetUrlImage.setOnClickListener {
            model.randomNumberUrl()
        }
    }
}
