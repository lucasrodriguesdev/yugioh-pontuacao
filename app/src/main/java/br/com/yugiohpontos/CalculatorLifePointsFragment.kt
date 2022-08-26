package br.com.yugiohpontos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.yugiohpontos.adapter.JogadorAdapter
import br.com.yugiohpontos.databinding.FragmentCalculatorLifePointsBinding

class CalculatorLifePointsFragment : Fragment() {

    private var _binding: FragmentCalculatorLifePointsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: JogadorViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    var historicoDano = mutableListOf<String>()
    var historicoHp = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculatorLifePointsBinding.inflate(inflater,container,false)

        recyclerView = binding.rvHistoricoLp
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        binding.subtrairVidaJogadorUm.setOnClickListener { calcularDanoJogadorUm() }
        binding.somarVidaJogadorUm.setOnClickListener { somaLpJogadorUm() }


        binding.pontosDeVidaJogadorUm.text

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.pontosDeVida.observe(viewLifecycleOwner){ lp ->
            binding.pontosDeVidaJogadorUm.text = lp.toString()
        }
    }

    private fun calcularDanoJogadorUm() {
        val dmg = binding.valorJogadorUm.text.toString()
        var dmgInt = 0
        if(dmg.isNotEmpty()) {
            dmgInt = dmg.toInt()
            val life = binding.pontosDeVidaJogadorUm.text.toString()
            val lifeInt = life.toInt()
            binding.pontosDeVidaJogadorUm.text = if(lifeInt - dmgInt > 0) {
                (lifeInt - dmgInt).toString()
            } else "0"
        }
//        if (binding.lifePoints1.text.toString()=="0"){
//            binding.lifePoints2.text = "Win!"
//        }
        binding.valorJogadorUm.text.clear()
        notificaHistorico((dmgInt*-1).toString())
    }

    private fun somaLpJogadorUm(){
        val valor = binding.valorJogadorUm.text.toString()
        var valorInt = 0
        if(valor.isNotEmpty()) {
            valorInt = valor.toInt()
            val life = binding.pontosDeVidaJogadorUm.text.toString()
            val lifeInt = life.toInt()
            binding.pontosDeVidaJogadorUm.text = (lifeInt + valorInt).toString()
            notificaHistorico(valorInt.toString())
        }
        binding.valorJogadorUm.text.clear()
    }

    private fun notificaHistorico(valor:String){
        recyclerView.adapter = JogadorAdapter(historicoDano,historicoHp )
        recyclerView.setHasFixedSize(true)
        historicoDano.add(valor)
        historicoHp.add(binding.pontosDeVidaJogadorUm.text.toString())
    }
}