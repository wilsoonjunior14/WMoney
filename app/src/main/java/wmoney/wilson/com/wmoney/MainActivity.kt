package wmoney.wilson.com.wmoney

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import models.User
import utils.Database
import wmoney.wilson.com.wmoney.utils.Preferences

class MainActivity : AppCompatActivity() {

    override fun onStart(){
        super.onStart()
        var user = Preferences().getLogin(applicationContext)
        if (!user.getName().equals("")){
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var database = Database(applicationContext)

        var btnAdd = findViewById<TextView>(R.id.add)

        btnAdd.setOnClickListener {
            print("click on add new user button")
            startActivity(Intent(this, AddActivity::class.java))
        }

        btnLogin.setOnClickListener{

            var email    = email.text.toString()
            var password = password.text.toString()

            if (email.length <= 0 || !email.contains("@") || password.length <= 0 ){
                Toast.makeText(applicationContext, "Email ou Senha inválidos", Toast.LENGTH_LONG).show()
            }else{

                var user = User(this, 0, "", "", "").findLogin(email, password)
                if (user != null){
                    System.out.println("Login realizado com sucesso!")
                    Preferences().save_login(applicationContext, user)
                    startActivity(Intent(this, HomeActivity::class.java))
                }

            }

        }
    }


}
