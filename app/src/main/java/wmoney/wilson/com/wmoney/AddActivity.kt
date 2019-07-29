package wmoney.wilson.com.wmoney

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import models.User

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnSave.setOnClickListener {
            var newUser = User(applicationContext, 0, email.text.toString(), password.text.toString(), name.text.toString())

            var result = newUser.valid()
            if (!result.equals("")){
                Toast.makeText(applicationContext, result, Toast.LENGTH_LONG).show()
            }else{
                val save = newUser.save(newUser as Object)

            }
        }



    }

    fun init(){
        email.setText("")
        name.setText("")
        password.setText("")
        confpassword.setText("")
    }

}
