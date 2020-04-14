package br.com.example.projetorecycleviewprodutos

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetalhesProdutoActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_recycleview_detalhes_produto_item)

        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var idImage = findViewById<ImageView>(R.id.layout_recycleView_detalhes_imageView)
        var textModelo = findViewById<TextView>(R.id.layout_recycleView_detalhes_textModelo)
        var textMarca = findViewById<TextView>(R.id.layout_recycleView_detalhes_textMarca)
        var textDescricao = findViewById<TextView>(R.id.layout_recycleView_detalhes_textDescricao)
        var textPreco = findViewById<TextView>(R.id.layout_recycleView_detalhes_textPreco)

       var produto = intent.getSerializableExtra("produto") as Produto

        if(produto != null){

            textModelo.text = produto.modelo
            textMarca.text = produto.marca
            textDescricao.text = produto.descricao
            textPreco.text = produto.preco
            idImage.setImageResource(produto.idImagem)

        }

        supportActionBar?.setTitle(produto.modelo)
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
}