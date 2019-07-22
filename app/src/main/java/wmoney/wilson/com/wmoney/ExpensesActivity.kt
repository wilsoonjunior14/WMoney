package wmoney.wilson.com.wmoney

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_expenses.*
import wmoney.wilson.com.wmoney.models.Expense
import java.util.prefs.Preferences
import kotlin.math.exp

class ExpensesActivity : AppCompatActivity() {

    var items : Array<String> = arrayOf("Ativo", "Passivo")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)

        var user = wmoney.wilson.com.wmoney.utils.Preferences().getLogin(applicationContext)

        var array = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1, this.items)
        listItems.adapter = array

        btnSave.setOnClickListener{

            var data = ""+date.year+"-"+date.month+"-"+date.dayOfMonth
            var ativo = if (listItems.selectedItemPosition == 0) true else false
            var expense = Expense(applicationContext, 0, data, value.text.toString().toDouble(), user.getId(), ativo)

            var result = expense.valida()
            if (!result.equals("")){
                Toast.makeText(applicationContext, result, Toast.LENGTH_LONG).show()
            }else{

                var returns = expense.save(expense as Object)
                if (returns){
                    this.finish()
                    startActivity(Intent(this, HomeActivity::class.java))
                }

            }

        }
    }
}
