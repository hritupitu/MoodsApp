/*
No Edits are needed in Main Activity Kotlin file,
however, changes are still needed in activity_main.xml
 */
package com.android.example.moods

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}