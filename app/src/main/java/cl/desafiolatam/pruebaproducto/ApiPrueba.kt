package cl.desafiolatam.pruebaproducto

import retrofit2.Call
import retrofit2.http.GET

interface ApiPrueba {
    @GET("products")
    fun getProduts(): Call<List<ProductosPojoItem>>
}