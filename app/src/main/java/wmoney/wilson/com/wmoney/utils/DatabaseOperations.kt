package utils

import android.content.Context

interface DatabaseOperations {

    fun save(objeto: Object) : Boolean

    fun delete(context: Context, objeto: Object) : Boolean

    fun update(context: Context, objeto: Object) : Boolean

}