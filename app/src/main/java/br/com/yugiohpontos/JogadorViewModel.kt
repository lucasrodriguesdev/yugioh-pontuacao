package br.com.yugiohpontos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JogadorViewModel : ViewModel() {
    private val _pontosDeVida: MutableLiveData<Int> = MutableLiveData(8880)
    val pontosDeVida: LiveData<Int>
        get() = _pontosDeVida

    fun calcularPontosDeVida(){
        _pontosDeVida.value = 9000
    }
}