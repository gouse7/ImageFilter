package com.mjcwrks.imagefilter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val gallery_ReqCode: Int=100

    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.imageView)


        GalleryPictureIntent()

    }

    open fun GalleryPictureIntent() {
        try {
            startActivityForResult(
                Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                ), gallery_ReqCode
            )
        } catch (e: Exception) {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(intent, "Select Picture"),
                gallery_ReqCode
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        /*if (resultCode == RESULT_OK && requestCode == gallery_ReqCode) {
            startActivity(Intent(this,FilterActivity::class.java).setData(data!!.data))
        }else if(resultCode ==3){
            Glide.with(this).load(data!!.data).into(imageView)
        }*/
    }

}