package com.example.mybmi

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_result_detail.*

class ResultDetail : BaseActivity() {
    var results : Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_detail)
        results=intent.getFloatExtra(BMI_SCORE,0.0f)
        iresultdetail.text=results.toString()
        if(results <18.5){
            detail.text=getString(R.string.dless)
            iresultdetail.setTextColor(getResources().getColorStateList(R.color.less))
        } else if(results>=18.5 && results<25){
            detail.text=getString(R.string.dnorm)
            iresultdetail.setTextColor(getResources().getColorStateList(R.color.normal))
        } else if(results>=25 && results<30){
            detail.text=getString(R.string.dover)
            iresultdetail.setTextColor(getResources().getColorStateList(R.color.over))
        }else if(results>=30){
            detail.text=getString(R.string.dobes)
           iresultdetail.setTextColor(getResources().getColorStateList(R.color.obese))
        }


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

