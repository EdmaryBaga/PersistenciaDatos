package com.bignerdranch.android.persistenciadatos.model

data class Producto(
    var idProducto: String,
    var Nombre: String,
    var Descripcion: String,
    var PrecioVenta: String,
    var PrecioCompra: String,
    var StockInicial: String,
    var StockFinal: String,
    var Url_Imagen: String,
    var Fecha_Creacion_Modificacion: String,
    var statusOferta: String,
    var idCategoria: String,
    var idProveedor: String
)