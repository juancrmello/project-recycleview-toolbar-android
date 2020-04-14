package br.com.example.projetorecycleviewprodutos.recycleView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.example.projetorecycleviewprodutos.Produto
import br.com.example.projetorecycleviewprodutos.R
import kotlinx.android.synthetic.main.activity_main.view.*

class AdapterProduto(var context: Context, var produtos:List<Produto>, var onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ViewHolderProduto>() {

    interface OnItemClickListener{
        public fun onItemClick(view:View, position:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProduto {
        var view = LayoutInflater.from(context).inflate(R.layout.layout_recycleview_produto_item, parent, false)
        return ViewHolderProduto(view)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    override fun onBindViewHolder(holder: ViewHolderProduto, position: Int) {
        var produto = produtos.get(position)
        holder.bind(produto, onItemClickListener, position)
    }
}