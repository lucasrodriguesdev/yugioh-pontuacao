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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculatorLifePointsBinding.inflate(inflater, container, false)
        recyclerView = binding.rvHistoricoLp
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.subtrairVidaJogadorUm.setOnClickListener { calcularDanoJogadorUm() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.pontosDeVida.observe(viewLifecycleOwner){ lp ->
            binding.pontosDeVidaJogadorUm.text = lp.toString()
        }
        viewModel.listaHistoDano.observe(viewLifecycleOwner){

        }
    }

    private fun calcularDanoJogadorUm() {
        viewModel.subtraiPontosDeVida(binding.valorJogadorUm.text.toString())

        //notificaHistorico((dmgInt*-1))
    }

//    private fun somaLpJogadorUm(){
//        val valor = binding.valorJogadorUm.text.toString()
//        var valorInt = 0
//        if(valor.isNotEmpty()) {
//            valorInt = valor.toInt()
//            val life = binding.pontosDeVidaJogadorUm.text.toString()
//            val lifeInt = life.toInt()
//            binding.pontosDeVidaJogadorUm.text = (lifeInt + valorInt).toString()
//            notificaHistorico(valorInt.toString())
//        }
//        binding.valorJogadorUm.text.clear()
//    }

//    private fun notificaHistorico(valor: Int){
//        recyclerView.adapter = JogadorAdapter(viewModel.listaHistoDano.value, listOf())
//        recyclerView.setHasFixedSize(true)
//        viewModel.listaHistoDano.value?.add(valor)
////        historicoHp.add(binding.pontosDeVidaJogadorUm.text.toString())
//    }
}