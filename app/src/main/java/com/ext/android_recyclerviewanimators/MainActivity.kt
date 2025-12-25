package com.ext.android_recyclerviewanimators

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.ext.recyclerviewanimators.animator.FadeInAnimator
import com.ext.recyclerviewanimators.animator.ScaleInAnimator
import com.ext.recyclerviewanimators.animator.SlideInBottomAnimator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = TestAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // ✅ SET YOUR CUSTOM ANIMATOR FIRST
        val animator = SlideInBottomAnimator().apply {
            addDuration = 400
            removeDuration = 400
        }

        recyclerView.itemAnimator = ScaleInAnimator()



        // ✅ DISABLE CHANGE ANIMATIONS SAFELY
        (recyclerView.itemAnimator as? SimpleItemAnimator)
            ?.supportsChangeAnimations = false

        // ⏱ Insert items AFTER RecyclerView is ready
        recyclerView.postDelayed({
            adapter.addItems(
                List(20) { "Item #$it" }
            )
        }, 500)
    }
}
