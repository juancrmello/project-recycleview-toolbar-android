package br.com.example.projetorecycleviewprodutos

import java.io.Serializable

class Produto(var modelo:String, var marca:String, var descricao:String, var preco:String, var idImagem: Int): Serializable {
}