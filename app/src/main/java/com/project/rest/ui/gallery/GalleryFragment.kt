package com.project.rest.ui.gallery


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.rest.R
import com.project.rest.databinding.FragmentGalleryBinding
import kotlinx.android.synthetic.main.fragment_gallery.*



class GalleryFragment : Fragment() {



    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val db = Firebase.firestore
    private lateinit var auth: FirebaseAuth











    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View

    {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        auth = Firebase.auth




        binding.breg.setOnClickListener{

            val email: String = Email.getText().toString()
            val password: String = Password.getText().toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "Вы уже зарегестрировались")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            context, "Вы зарегестрировались",
                            Toast.LENGTH_SHORT
                        ).show()
                        updateUI(null)
                    }
                }

        }

















        binding.blog.setOnClickListener{
            val email: String = Email.getText().toString()
            val password: String = Password.getText().toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener() { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "Вы уже вошли")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(context, "Вы вошли",
                            Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }


        }























        //binding.breg.setOnClickListener {
            //val name: String = Name.getText().toString()
            //val number: String = Phone.getText().toString()
          //  val email: String = Email.getText().toString()
            //val pas: String = Password.getText().toString()



            //val db = Firebase.firestore


            //val user = hashMapOf(
                //"Number" to number,
                //"Email" to email,
                //"Password" to pas
            //)


// Add a new document with a generated ID
            //db.collection("users").document(name)
                //.set(user)
                //.addOnSuccessListener { documentReference ->
                    //Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference}")
                //}
                //.addOnFailureListener { e ->
                    //Log.w(TAG, "Error adding document", e)
                //}
            //Password.setText("")
            //Email.setText("")
            //Name.setText("")





        //}
        val root: View = binding.root
        return root



    }




    private fun updateUI(user: FirebaseUser?) {

    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            Toast.makeText(context, "Добрый день, вы вошли в свой аккаунт ",
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun reload() {
        TODO("Not yet implemented")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null


    }



}

