package wmoney.wilson.com.wmoney.models

import android.content.ContentValues
import android.content.Context
import android.widget.Toast
import models.User
import utils.Database
import utils.DatabaseOperations

class Expense(context: Context, id: Int, date: String, value: Double, id_user: Int, increment: Boolean) : DatabaseOperations{

    private var context: Context = context
    private var id: Int = id
    private var date: String = date
    private var value: Double = value
    private var id_user: Int = id_user
    private var increment: Boolean = increment

    fun getId() : Int{
        return this.id
    }

    fun getDate() : String{
        return this.date
    }

    fun getValue() : Double{
        return this.value
    }

    fun getIdUser() : Int{
        return this.id_user
    }

    fun getIncrement() : Boolean{
        return this.increment
    }

    override fun save(objeto: Object): Boolean {
        try {
            var expense = objeto as Expense
            var cv = ContentValues()
            var sqlite = Database(this.context).writableDatabase

            cv.put("value", expense.getValue())
            cv.put("date", expense.getDate())
            cv.put("increment", expense.getIncrement())
            cv.put("id_user", expense.getIdUser())

            val result = sqlite.insert("expenses", null, cv)
            if (result.toInt() == -1){
                Toast.makeText(context, "Não foi possível salvar a despesa!", Toast.LENGTH_LONG).show()
                return false
            }else{
                Toast.makeText(context, "Despesa salva com sucesso", Toast.LENGTH_LONG).show()
                return true
            }

        }catch (e: Exception){
            e.printStackTrace()
            Toast.makeText(context, "Erro ao salvar despesa!", Toast.LENGTH_LONG).show()
            return false
        }

        return false
    }

    override fun delete(context: Context, objeto: Object): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(context: Context, objeto: Object): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    public fun valida() : String{
        if (this.value == null || this.value <= 0) return "Valor da despesa não informado!"
        if (this.date.equals("") || this.date.length > 10) return "Data inválida"
        if (this.increment == null) return "Tipo da Despesa não informada"
        if (this.id_user == null) return "Id do usuário não informado"

        return ""
    }

}