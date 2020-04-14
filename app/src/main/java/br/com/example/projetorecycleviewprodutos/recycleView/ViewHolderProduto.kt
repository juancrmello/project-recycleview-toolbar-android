package br.com.example.projetorecycleviewprodutos.recycleView

import android.content.DialogInterface
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.example.projetorecycleviewprodutos.Produto
import br.com.example.projetorecycleviewprodutos.R
import kotlinx.android.synthetic.main.layout_recycleview_produto_item.*
import java.text.FieldPosition

class ViewHolderProduto(itemView:View) : RecyclerView.ViewHolder(itemView) {

    fun bind(produto:Produto, onItemClickListener: AdapterProduto.OnItemClickListener, position: Int ){

        var textModelo = itemView.findViewById<TextView>(R.id.layout_viewHolder_recycleView_textModelo)
        var textMarca = itemView.findViewById<TextView>(R.id.layout_viewHolder_recycleView_textMarca)
        var textDescricao = itemView.findViewById<TextView>(R.id.layout_viewHolder_recycleView_textDescricao)
        var textPreco = itemView.findViewById<TextView>(R.id.layout_viewHolder_recycleView_textPreco)
        var imageView = itemView.findViewById<ImageView>(R.id.layout_viewHolder_recycleView_imagemProduto)

        textModelo.text = produto.modelo
        textMarca.text = produto.marca
        textDescricao.text = produto.descricao
        textPreco.text = produto.preco
        imageView.setImageDrawable(ContextCompat.getDrawable(itemView.context, produto.idImagem))

        onItemClickListener.onItemClick(itemView, position)
    }
}