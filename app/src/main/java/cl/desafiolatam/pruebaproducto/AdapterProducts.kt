package cl.desafiolatam.pruebaproducto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_productos.view.*

class AdapterProducts(private val listaProductos : MutableList<ProductosPojoItem>) : RecyclerView.Adapter<AdapterProducts.ProductoViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterProducts.ProductoViewHolder {
        val list = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list, parent, false)
        return ProductoViewHolder(list)
    }

    override fun onBindViewHolder(holder: AdapterProducts.ProductoViewHolder, position: Int) {
       holder.nombre.text = listaProductos.get(position).name
       holder.precio.text = listaProductos.get(position).price.toString()
        Picasso.get().load(listaProductos[position].image).into(holder.imagen)
    }

    override fun getItemCount(): Int {
      return listaProductos.size
    }

    class ProductoViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

        var nombre = itemView.name_product
        var precio = itemView.precio
        var imagen = itemView.imageView
        var boton = itemView.button
    }
}