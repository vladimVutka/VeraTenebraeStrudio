package com.example.veratenebraestrudio

import com.example.veratenebraestrudio.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.example.veratenebraestrudio.Fragments.LoginFragment.LoginFragment
import com.example.veratenebraestrudio.Fragments.ProfileFragment.ProfileFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, LoginFragment())
            .commit()
    }

}
