package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddGameViewModel: ViewModel() {
    //Modo pro
    //Foto(ni puta idea)
    //Nombre del juego
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name
    //Nombre del estudio de desarrollo
    private val _nameDev = MutableLiveData<String>()
    val nameDev: LiveData<String> = _nameDev
    //Fecha de lanzamiento del juego
    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date
    //Genero del juego
    private val _type = MutableLiveData<String>()
    val type: LiveData<String> = _type
    //Edades juego
    private val _recommendedAge = MutableLiveData<String>()
    val recommendedAge: LiveData<String> = _recommendedAge
    //Funcion que engloba a todas las variables, puede parecer poco eficiente pero compose solo
    //recompone lo que cambia, lo demas ni lo toca
    fun onAddGameChanged(name: String, nameDev: String, date: String, type: String, age: String){
        _name.value = name
        _nameDev.value = nameDev
        _date.value = date
        _type.value = type
        _recommendedAge.value = age
    }
}