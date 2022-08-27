package br.com.yugiohpontos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JogadorViewModel : ViewModel() {

    private val _pontosDeVida: MutableLiveData<Int> = MutableLiveData(8880)
    val pontosDeVida: LiveData<Int>
        get() = _pontosDeVida

    private val _listaHistoDano: MutableLiveData<MutableList<Int>> = MutableLiveData(mutableListOf())
    val listaHistoDano: LiveData<MutableList<Int>>
        get() = _listaHistoDano

    fun subtraiPontosDeVida(dano: String){
        if(dano.isNotEmpty()) {
            val danoEmInt = dano.toInt()
            _pontosDeVida.value = _pontosDeVida.value?.minus(danoEmInt)
            } else "0"
    }

    fun somaPontosDeVida(){
        TODO()
    }
}