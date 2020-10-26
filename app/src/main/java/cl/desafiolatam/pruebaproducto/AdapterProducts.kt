package cl.desafiolatam.pruebaproducto

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_productos.view.*

class AdapterProducts(private val listaProductos : MutableList<ProductosPojoItem>) : RecyclerView.Adapter<AdapterProducts.ProductoViewHolder>(){


    class ProductoViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

        var nombre = itemView.name_product
        var precio = itemView.precio
        var imagen = itemView.imageView
        var button = itemView.button

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_productos, parent, false)
        return ProductoViewHolder(view)
    }
        var productoSelected =MutableLiveData<ProductosPojoItem>()

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {

        holder.nombre.text = listaProductos.get(position).name
        holder.precio.text = listaProductos.get(position).price.toString()
        Picasso.get().load(listaProductos.get(position).image).into(holder.imagen)
        holder.button.setOnClickListener {
        productoSelected.value = listaProductos.get(position)
            Log.d("Selección", "${listaProductos.get(position)}")

        }

     }

    override fun getItemCount(): Int {

        return listaProductos.size
    }
}