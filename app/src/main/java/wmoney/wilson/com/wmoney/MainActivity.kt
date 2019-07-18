package wmoney.wilson.com.wmoney

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import utils.Database

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var database = Database(applicationContext)

        var btnAdd = findViewById<TextView>(R.id.add)

        btnAdd.setOnClickListener {
            print("click on add new user button")
            startActivity(Intent(this, AddActivity::class.java))
        }
    }


}
