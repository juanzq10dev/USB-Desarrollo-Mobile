package com.example.myapplication

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class Vehicle: BaseObservable() {

    @get:Bindable // Allows android studio to hear changes
    var year: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.year)
        }

    @get:Bindable
    var model: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.model)
        }
}
