package com.example.testingnew.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testingnew.R
import com.example.testingnew.UI.Main.MainActivity
import kotlinx.android.synthetic.main.activity_thanks_page.*

class ThanksPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thanks_page)

        homePageButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivities(arrayOf(intent))
        }

    }
}