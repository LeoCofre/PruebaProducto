package cl.desafiolatam.pruebaproducto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadApi()
    }
    fun loadApi(){
        val service = RetrofitClient.retrofitInstance()
        val call = service.getProduts()
        call.enqueue(object : Callback<List<ProductosPojoItem>>{
            override fun onResponse(
                call: Call<List<ProductosPojoItem>>,
                response: Response<List<ProductosPojoItem>>
            ) {
                Log.d("Adapter", "${response.body()}")
            }

            override fun onFailure(call: Call<List<ProductosPojoItem>>, t: Throwable) {
                Log.d("Adapter", "Fallo")
            }

        })
    }
}