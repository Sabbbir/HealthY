package com.example.healthy

class ExerciseModel (
    private var id: Int,
    private var name: String,
        private var image: Int,
    private var isCompleted: Boolean,
    private var isSelected: Boolean
        ){
    fun getId(): Int {
        return id
    }
    fun setId(id: Int){
        this.id = id
    }
    fun getName():String{
        return name
    }
    fun setName(name: String){
        this.name = name
    }
    fun getImage( ):Int{
        return image
    }
    fun setImage(image: Int){
        this.image = image
    }
    fun getisCompleted(isCompleted: Boolean){
        this.isCompleted = isCompleted
    }
    fun setisCompleted(): Boolean{
        return isCompleted
    }
    fun getisSelected():Boolean{
        return isSelected
    }

    fun setisSelected( ):Boolean{
        return isSelected
    }
}