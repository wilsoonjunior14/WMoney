package models
import android.content.ContentValues
import android.content.Context
import android.widget.Toast
import utils.Database
import utils.DatabaseOperations

class User(context: Context, id: Int, email: String, password: String, name: String) : DatabaseOperations{

    private val id: Int = id
    private val email: String = email
    private val password: String = password
    private val name: String = name
    private val context: Context = context

    public fun getEmail() : String{
        return this.email
    }

    public fun getPassword() : String{
        return this.password
    }

    public fun getName() : String{
        return this.name
    }

    override fun save(objeto: Object): Boolean {

        try {
            var newUser = objeto as User
            var cv = ContentValues()
            var sqlite = Database(this.context).writableDatabase

            cv.put("name", newUser.getEmail())
            cv.put("email", newUser.getName())
            cv.put("password", newUser.getPassword())

            val result = sqlite.insert("user", null, cv)
            if (result.toInt() == -1){
                Toast.makeText(context, "Não foi possível salvar o usuário!", Toast.LENGTH_LONG).show()
                return false
            }else{
                Toast.makeText(context, "Usuário salvo com sucesso", Toast.LENGTH_LONG).show()
                return true
            }

        }catch (e: Exception){
            e.printStackTrace()
            Toast.makeText(context, "Erro ao salvar usuário!", Toast.LENGTH_LONG).show()
            return false
        }

        return false
    }

    override fun delete(context: Context, objeto: Object): Boolean {
        return false
    }

    override fun update(context: Context, objeto: Object): Boolean {
        return false
    }

    public fun valid() : String{
        if (getEmail().equals("") || getEmail().length > 100) return "Email inválido! Máximo de 100 caracteres são permitidos"
        if (getName().equals("") || getName().length > 255) return "Nome inválido! Máximo de 255 caracteres são permitidos"
        if (getPassword().equals("") || getPassword().length > 10) return "Senha inválida! Máximo de 10 caracteres são permitidos"
        return ""
    }

    public fun findLogin(email: String, password: String){

    }

}