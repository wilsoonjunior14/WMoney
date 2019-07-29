package wmoney.wilson.com.wmoney.utils.Builders

import android.content.Context
import models.User

class UserBuilder {

    lateinit var users: ArrayList<User>

    init {
        users = ArrayList<User>()
    }

    public fun getValidUsers(context: Context) : ArrayList<User>{
        users.add(User(context, 0, "wjunior_msn@hotmail.com", "12345", "Wilson Junior"))
        users.add(User(context, 0, "wilsoonjunior@gmail.com", "12345", "Wilson Junior"))
        users.add(User(context, 0, "fwrj@cin.ufpe.br", "12345", "Wilson Junior"))
        users.add(User(context, 0, "franwj@cin.ufpe.br", "12345", "Wilson Junior"))
        return users
    }

    public fun getInvalidEmailUsers() : ArrayList<User>{
        users.add(User(null!!, 0, "wjunior_msnhotmail.com", "12345", "Wilson Junior"))
        users.add(User(null!!, 0, "", "12345", "Wilson Junior"))
        users.add(User(null!!, 0, "fwrjaslkdfhaksjfasdhfkjasdghsaadfjgasdkfjasfgkjasgakjsdgfaskjdfgjshgaskjgfsajkdfgskajdgfkajsdfgkjasdfkjasdhfcin.ufpe.bakjlsdfsgkjgskajgfksgfkajsfgkjashgdkjfhsdgfkjsgdahfkjhagdsjfkhgadskfjadsgkjfsagkdjfgajdskfgsdjkafsr", "12345", "Wilson Junior"))
        users.add(User(null!!, 0, "@#@$@$@#$@#$@#$@#$@#$@#$", "12345", "Wilson Junior"))
        return users
    }

    public fun getInvalidPasswordUsers() : ArrayList<User>{
        users.add(User(null!!, 0, "wjunior_msn@hotmail.com", "", "Wilson Junior"))
        users.add(User(null!!, 0, "wilsoonjunior@gmail.com", "12345kajsfasgfkjshgadfkjhsagfjkshgadfjksadghjfkasgfasgfkjkjasdgfkjasdhgfjkaghsdfjksgdhakfjgdashkfjdhgsadakjgfskjagfaksjfgfgkjgdsfghdsfkjghjgfkjgfksagfhjgfhsdfgeuytwruegyfjgshdfjdsghfjghskf", "Wilson Junior"))
        return users
    }

}