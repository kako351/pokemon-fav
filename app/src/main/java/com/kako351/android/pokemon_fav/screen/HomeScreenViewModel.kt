package com.kako351.android.pokemon_fav.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {
    init {
        Log.i("HomeScreenViewModel", "init")
    }
}
