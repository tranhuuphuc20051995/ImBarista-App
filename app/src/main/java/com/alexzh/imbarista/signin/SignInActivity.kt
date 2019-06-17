package com.alexzh.imbarista.signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexzh.imbarista.R
import com.alexzh.imbarista.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        sign_up_button.setOnClickListener {
            SignUpActivity.start(this@SignInActivity)
        }
    }
}
