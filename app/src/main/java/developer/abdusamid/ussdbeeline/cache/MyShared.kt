package developer.abdusamid.ussdbeeline.cache

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MyShare {
    private const val NAME = "my_cache_file"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var name: String?
        get() = sharedPreferences.getString("key", "")
        set(value) = sharedPreferences.edit {
            it.putString("key", value)
        }

    var dataList: ArrayList<ClassData>?
        get() = gsonToArray(sharedPreferences.getString("dataList", "[]")!!)
        set(value) = sharedPreferences.edit {
            it.putString("dataList", listToGson(value!!))
        }

    private fun gsonToArray(gsonString: String): ArrayList<ClassData> {
        val list = ArrayList<ClassData>()

        val type = object : TypeToken<List<ClassData>>() {}.type
        list.addAll(Gson().fromJson(gsonString, type))
        return list
    }

    private fun listToGson(list: ArrayList<ClassData>): String {
        return Gson().toJson(list)
    }
}