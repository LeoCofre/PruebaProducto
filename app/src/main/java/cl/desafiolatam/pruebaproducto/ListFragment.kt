package cl.desafiolatam.pruebaproducto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list.*
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListFragment : Fragment() {
    var listaProductos = ArrayList<ProductosPojoItem>()
    lateinit var adapter: AdapterProducts


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
        Log.d("Lista", "$listaProductos")


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listaProductos = loadApi()
        adapter = AdapterProducts(listaProductos)
        recycler_productos.adapter = adapter
    }

    fun loadApi(): ArrayList<ProductosPojoItem> {
        val service = RetrofitClient.retrofitInstance()
        val call = service.getProduts()
        call.enqueue(object : Callback<List<ProductosPojoItem>> {
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
        return listaProductos
    }


}