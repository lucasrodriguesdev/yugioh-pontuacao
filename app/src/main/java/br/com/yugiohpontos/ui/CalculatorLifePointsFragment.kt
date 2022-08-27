package br.com.yugiohpontos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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
        viewModel.pontosDeVida.observe(viewLifecycleOwner) { lp ->
            binding.pontosDeVidaJogadorUm.text = lp.toString()
        }
    }

    private fun calcularDanoJogadorUm() {
        viewModel.subtraiPontosDeVida(binding.valorJogadorUm.text.toString())
        binding.valorJogadorUm.text.toString().let {
            if(it.isNotEmpty())
                notificaHistorico(it.toInt())
        }
        binding.valorJogadorUm.text.clear()
    }

    private fun notificaHistorico(valor: Int) {
        recyclerView.adapter = JogadorAdapter(viewModel.listaHistoDano.value)
        recyclerView.setHasFixedSize(true)
        viewModel.atualizaListaDano(valor)
    }

}
