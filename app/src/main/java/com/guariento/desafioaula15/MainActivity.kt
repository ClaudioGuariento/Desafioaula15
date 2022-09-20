package com.guariento.desafioaula15

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isFirstTime()) {
            showWelcomeDialog()
            updateFirstTime()
        }
    }

    private fun isFirstTime(): Boolean {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getBoolean(KEY_FIRST, true)
    }

    private fun updateFirstTime(){
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean(KEY_FIRST, false)
            apply()
        }
    }
    private fun showWelcomeDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.apply {
            setMessage("Primeira vez que você abre o app").setTitle("Olá")
            setPositiveButton(android.R.string.ok) { _,_ ->}
            setCancelable(false)
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private companion object {
        private const val KEY_FIRST = "KEY_FIRST"
    }
}