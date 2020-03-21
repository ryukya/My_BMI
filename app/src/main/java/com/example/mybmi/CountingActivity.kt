package com.example.mybmi

import android.content.Intent
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_counting.*
import kotlin.Exception

class CountingActivity : BaseActivity() {
    var result: Float = 0.0f
    var cal = BMICalculate(0.0f, 0.0f)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counting)
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
            val vmetric = Intent(this, CountingActivity::class.java)
            startActivity(vmetric)
        }
        if (id == R.id.mimperial) {
            val vimperial = Intent(this, ImperialActivity::class.java)
            startActivity(vimperial)
        }
        if (id == R.id.devinfo) {
            val vinfo = Intent(this, ProfileActivity::class.java)
            startActivity(vinfo)
        }

        return super.onOptionsItemSelected(item)

    }

    fun countClicked(view: View) {
        btn.setOnClickListener {
            val BMI = findViewById(R.id.iresultdetail) as TextView
            val start = 0.0f
            try {
                cal.vheight = iheight.text.toString().toFloat()
                cal.vweight = iweight.text.toString().toFloat()
                result = cal.fmetric()

            //animate the result
            val animate = ValueAnimator.ofFloat(start, result)
            animate.addUpdateListener {
                val value = it.animatedValue as Float
                BMI.text = value.toString()
            }
            //check the color
            if (result < 18.5) {
                BMI.setTextColor(getResources().getColorStateList(R.color.less))
            } else if (result >= 18.5 && result < 25) {
                BMI.setTextColor(getResources().getColorStateList(R.color.normal))
            } else if (result >= 25 && result < 30) {
                BMI.setTextColor(getResources().getColorStateList(R.color.over))
            } else if (result >= 30) {
                BMI.setTextColor(getResources().getColorStateList(R.color.obese))
            }
            //validate value
            var tes=cal.validate()
            if (tes==false ) {
                Toast.makeText(this, getString(R.string.zero), Toast.LENGTH_LONG).show()
                BMI.linksClickable=false
            } else  {
                animate.start()
                val infos: String = getString(R.string.tinfo)
                info.text = infos
            }
            } catch (e: Exception) {
                if (iweight.text.toString().trim().isEmpty() && iheight.text.toString().trim().isNotEmpty()) {
                    Toast.makeText(this, getString(R.string.noweight), Toast.LENGTH_LONG).show()
                }
                if (iheight.text.toString().trim().isEmpty() && iweight.text.toString().trim().isNotEmpty()) {
                    Toast.makeText(this, getString(R.string.noheight), Toast.LENGTH_LONG).show()
                }
                if (iheight.text.toString().trim().isEmpty() && iweight.text.toString().trim().isEmpty()) {
                    Toast.makeText(this, getString(R.string.nohw), Toast.LENGTH_LONG).show()
                }
            }


        }

    }

    fun resultClicked(view: View) {
        val resultv = Intent(this, ResultDetail::class.java).apply { putExtra(BMI_SCORE, result) }
        //code  putextra to add value
        startActivity(resultv)
    }

}

