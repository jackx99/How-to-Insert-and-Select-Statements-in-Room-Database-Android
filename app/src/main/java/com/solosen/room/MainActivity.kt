package com.solosen.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val localDatabase = MyDatabase.getInstance(context = applicationContext)
        val dao = localDatabase.dao()

        button.setOnClickListener {
            runBlocking {
                launch {
                    dao.createUser(User(username = "sen", password = "1234"))
                    val user = dao.getUser()
                    Toast.makeText(applicationContext, user.username, Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}
