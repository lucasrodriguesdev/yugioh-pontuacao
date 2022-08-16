package br.com.yugiohpontos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.set
import br.com.yugiohpontos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculo1.setOnClickListener { calcularDanoJogadorUm() }
        binding.calculo2.setOnClickListener { calcularDanoJogadorDois() }
    }

    private fun calcularDanoJogadorUm() {
        val dmg = binding.damage1.text.toString()
        if(dmg.isNotEmpty()) {
            val dmgInt = dmg.toInt()
            val life = binding.lifePoints1.text.toString()
            val lifeInt = life.toInt()
            binding.lifePoints1.text = if(lifeInt - dmgInt > 0) {
                (lifeInt - dmgInt).toString()
            } else "0"
        }
        if (binding.lifePoints1.text.toString()=="0"){
            binding.vencedor.text = "AZUL venceu!"
            binding.vencedor.setTextColor(binding.damage2.currentHintTextColor)
        }
        binding.damage1.text.clear()
    }

    private fun calcularDanoJogadorDois() {
        val dmg = binding.damage2.text.toString()
        if(dmg.isNotEmpty()) {
            val dmgInt = dmg.toInt()
            val life = binding.lifePoints2.text.toString()
            val lifeInt = life.toInt()
            binding.lifePoints2.text = if(lifeInt - dmgInt > 0) {
                (lifeInt - dmgInt).toString()
            } else "0"
        }
        if (binding.lifePoints2.text.toString()=="0"){
            binding.vencedor.text = "VERMELHO venceu!"
            binding.vencedor.setTextColor(binding.damage1.currentHintTextColor)
        }
        binding.damage2.text.clear()
    }
}