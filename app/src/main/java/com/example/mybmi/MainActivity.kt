package com.example.mybmi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : BaseActivity() {
    lateinit   var logo1: TextView
    lateinit   var logo: TextView
    lateinit   var botAnim: Animation
    lateinit   var topAnim: Animation
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        //animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        botAnim = AnimationUtils.loadAnimation(this, R.anim.botom_animation)

        //hook
        logo1 = findViewById(R.id.tx1)
        logo = findViewById(R.id.tx)

        this.logo1.setAnimation(topAnim)
        this.logo.setAnimation(botAnim)
        handler = Handler()
        handler.postDelayed({
            val intent= Intent(this,CountingActivity::class.java)
            startActivity(intent)
            finish()

        },2000)

    }
}
