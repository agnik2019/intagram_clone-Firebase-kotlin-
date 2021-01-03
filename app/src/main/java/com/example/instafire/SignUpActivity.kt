package com.example.instafire

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instafire.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*


private val TAG = "Something"

class SignUpActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var db : FirebaseFirestore
    private lateinit var uid:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
         mAuth = FirebaseAuth.getInstance()
      //  if(auth.currentUser != null) goPostsActivity()
        btnSignup.setOnClickListener {

            SignUpUser()

    }
    }

    fun SignUpUser(){
       // btnLogin.isEnabled = false
        val email = etEmail2.text.toString()
        val password = etPassword2.text.toString()
        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Email or password can not be empty", Toast.LENGTH_SHORT)
                    .show()
            return
        }
        //Firebase authentication
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
//                        val user = mAuth?.currentUser
//                        val uid = user!!.uid
                      //  name = newUsername?.username.toString()
                   //     db.collection("users").document(uid).set(email)
//                        uid = mAuth.currentUser!!.uid
//                        val userHashMap = HashMap<String,Any>()
//                        userHashMap["username"] = email
//                        userHashMap["age"] = 22
//                        db.collection("users")
//                                .document(uid)
//                                .set(userHashMap)
//                                .addOnSuccessListener {
//
//                                    Log.i(TAG,"user stored successfully")
//                                }
//                                .addOnFailureListener { exception ->
//                                    Log.i(TAG,"sorry",exception)
//                                }

                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.d(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Signup failed.",
                                Toast.LENGTH_SHORT).show()
                    }

                }
    }


}