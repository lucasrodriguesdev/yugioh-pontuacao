package br.com.yugiohpontos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import br.com.yugiohpontos.adapter.PlayerDoisItemAdapter
import br.com.yugiohpontos.adapter.PlayerUmItemAdapter
import br.com.yugiohpontos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var myDataSet = mutableListOf<String>()
    var myDataSet2 = mutableListOf<String>()
    lateinit var rv: RecyclerView
    lateinit var rv2: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculo1.setOnClickListener { calcularDanoJogadorUm() }
        binding.calculo2.setOnClickListener { calcularDanoJogadorDois() }

        rv = binding.rvHistoricoLp
        rv2 = binding.rvHistoricoLp2
    }

    private fun calcularDanoJogadorUm() {
        val dmg = binding.damage1.text.toString()
        var dmgInt = 0
        if(dmg.isNotEmpty()) {
            dmgInt = dmg.toInt()
            val life = binding.lifePoints1.text.toString()
            val lifeInt = life.toInt()
            binding.lifePoints1.text = if(lifeInt - dmgInt > 0) {
                (lifeInt - dmgInt).toString()
            } else "0"
        }
        if (binding.lifePoints1.text.toString()=="0"){
            binding.lifePoints1.text = "Win!"
        }
        binding.damage1.text.clear()
        historico1((dmgInt*-1).toString())
    }

    private fun calcularDanoJogadorDois() {
        val dmg = binding.damage2.text.toString()
        var dmgInt = 0
        if(dmg.isNotEmpty()) {
            dmgInt = dmg.toInt()
            val life = binding.lifePoints2.text.toString()
            val lifeInt = life.toInt()
            binding.lifePoints2.text = if(lifeInt - dmgInt > 0) {
                (lifeInt - dmgInt).toString()
            } else "0"
        }
        if (binding.lifePoints2.text.toString()=="0"){
            binding.lifePoints2.text = "Win!"
        }
        binding.damage2.text.clear()
        historico2((dmgInt*-1).toString())
    }

    fun historico1(dmg:String){
        rv.adapter = PlayerUmItemAdapter(myDataSet)
        rv.setHasFixedSize(true)
        myDataSet.add(dmg)
    }

    fun historico2(dmg:String){
        rv2.adapter = PlayerDoisItemAdapter(myDataSet2)
        rv2.setHasFixedSize(true)
        myDataSet2.add(dmg)
    }
}