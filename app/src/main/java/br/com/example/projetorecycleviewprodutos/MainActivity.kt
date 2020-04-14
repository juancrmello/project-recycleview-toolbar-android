package br.com.example.projetorecycleviewprodutos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.example.projetorecycleviewprodutos.recycleView.AdapterProduto

class MainActivity : AppCompatActivity() {

     var  produtos = ArrayList<Produto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar2))
        supportActionBar?.setTitle("Eletrônicos")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        produtos.add(Produto("Monitor", "LG", "Monitor LG Full HD 27 polegadas", "R$ 1000", R.drawable.monitorlg))
        produtos.add(Produto("Teclado", "Razer", "Teclado mecânico Razer RGB", "R$ 500", R.drawable.tecladorazer))
        produtos.add(Produto("Mouse", "Logitech", "Mouse Logitech RGB 6000Dpi", "R$ 300", R.drawable.mouselogitech))

        var recycleView = findViewById<RecyclerView>(R.id.activity_main_recycleView_produtos)

        var adapterProduto = AdapterProduto(applicationContext, produtos, onItemClickListener())
        recycleView.adapter = adapterProduto

        recycleView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        when(id){
            R.id.activity_main_menuItem_sobre->{
                Toast.makeText(this, "Juan Carlos", Toast.LENGTH_LONG).show()
            }
            android.R.id.home->{
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    fun onItemClickListener():AdapterProduto.OnItemClickListener{
        var onItemClick = object: AdapterProduto.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                view.setOnClickListener{

                    val i = Intent(applicationContext, DetalhesProdutoActivity::class.java)

                    i.putExtra("produto", produtos.get(position))
                    startActivity(i)
                }
            }


        }

        return onItemClick
    }
}






