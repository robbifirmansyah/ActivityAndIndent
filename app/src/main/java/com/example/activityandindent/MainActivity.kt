package com.example.activityandindent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Toast
import com.example.activityandindent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isChecked = false

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASSWORD = "extra_password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            checkbox.setOnClickListener {
                isChecked = !isChecked
                if (isChecked) {
                    checkbox.setImageResource(R.drawable.baseline_check_box_24)
                } else {
                    checkbox.setImageResource(R.drawable.baseline_check_box_outline_blank_24)
                }
            }

            btnRegister.setOnClickListener {
                val name = edtName.text.toString()
                val email = edtEmail.text.toString()
                val phone = edtPhone.text.toString()
                val password = edtPassword.text.toString()

                if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty() && isChecked) {
                    val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java)
                    intentToSecondActivity.putExtra(EXTRA_NAME, name)
                    intentToSecondActivity.putExtra(EXTRA_USERNAME, email)
                    intentToSecondActivity.putExtra(EXTRA_PASSWORD, password)
                    startActivity(intentToSecondActivity)
                } else {
                    Toast.makeText(this@MainActivity, "Harap isi semua kolom dan centang checkbox.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
