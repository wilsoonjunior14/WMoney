package wmoney.wilson.com.wmoney

import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import kotlinx.android.synthetic.main.activity_home.*
import models.User
import wmoney.wilson.com.wmoney.utils.Preferences

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var user = Preferences().getLogin(applicationContext)
        println("GET USERDATA: "+user.getName())
        name.text  = "Nome: "+user.getName()
        email.text = "Email: "+user.getEmail()

        var dataPoints: Array<DataPoint> = arrayOf(DataPoint(0.0, 20.2), DataPoint(1.0, 5.4), DataPoint(2.0, 5.0), DataPoint(3.0, 30.1))

        var barGraphs = BarGraphSeries<DataPoint>(dataPoints)

        graphView.addSeries(barGraphs)

        barGraphs.title = "Despesas"
        barGraphs.spacing = 2
        barGraphs.valuesOnTopColor = Color.RED

        btnAdd.setOnClickListener{
            startActivity(Intent(this, ExpensesActivity::class.java))
        }
    }
}
