package com.project.rest

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import android.widget.ImageButton
import android.widget.EditText
import android.content.Context
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.rest.databinding.ActivityBronBinding
import com.project.rest.databinding.ActivityMainBinding
import com.rengwuxian.materialedittext.MaterialEditText
import kotlinx.android.synthetic.main.activity_bron.*


class Bron : AppCompatActivity() {
    private lateinit var binding: ActivityBronBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBronBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageButton2.setOnClickListener{
            val data: String = editTextDate.getText().toString()
            val time1: String = editTextTime.getText().toString()
            val time2: String = editTextTime2.getText().toString()
            val name: String = editTextTextPersonName.getText().toString()

            val db = Firebase.firestore

            val user = hashMapOf(
                "Дата" to data,
                "С" to time1,
                "До" to time2
            )

            db.collection("users").document(name)
                .set(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
            Toast.makeText(this,"Ваш столик забронирован", Toast.LENGTH_SHORT).show()
        }












    }

}