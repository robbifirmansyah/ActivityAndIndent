package com.example.activityandindent

import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.activityandindent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var isChecked = false

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASSWORD = "extra_password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val registeredUsername = intent.getStringExtra(EXTRA_USERNAME)
        val registeredPassword = intent.getStringExtra(EXTRA_PASSWORD)

        with(binding) {
            with(binding) {
                checkbox.setOnClickListener {
                    isChecked = !isChecked
                    if (isChecked) {
                        checkbox.setImageResource(R.drawable.baseline_check_box_24)
                    } else {
                        checkbox.setImageResource(R.drawable.baseline_check_box_outline_blank_24)
                    }
                }

            btnLogin.setOnClickListener {
                val enteredUsername = edtName.text.toString()
                val enteredPassword = edtPassword.text.toString()

                if (enteredUsername == registeredUsername && enteredPassword == registeredPassword) {
                    val intentToThirdActivity = Intent(this@SecondActivity, ThirdActivity::class.java)
                    intentToThirdActivity.putExtra(EXTRA_USERNAME, edtName.text.toString())
                    startActivity(intentToThirdActivity)
                } else {
                    Toast.makeText(this@SecondActivity, "Username atau password salah.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
}
