package utils

import android.content.Context

interface DatabaseOperations {

    fun save(objeto: Object) : HashMap<String, Object>

    fun delete(context: Context, objeto: Object) : Boolean

    fun update(context: Context, objeto: Object) : Boolean

}