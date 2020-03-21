package com.example.mybmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        nm.isEnabled=false
        nm.setTextColor(getResources().getColorStateList(R.color.colorText))
        uni.isEnabled=false
        uni.setTextColor(getResources().getColorStateList(R.color.colorText))
        mail.isEnabled=false
        mail.setTextColor(getResources().getColorStateList(R.color.colorText))
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item
        val id = item.getItemId()

        if (id == R.id.mmetric) {
            val vmetric= Intent(this,CountingActivity::class.java)
            startActivity(vmetric)
        }
        if (id == R.id.mimperial) {
            val vimperial= Intent(this,ImperialActivity::class.java)
            startActivity(vimperial)
        }
        if (id == R.id.devinfo) {
            val vinfo= Intent(this,ProfileActivity::class.java)
            startActivity(vinfo)
        }

        return super.onOptionsItemSelected(item)

    }
}
