package com.dicoding.exam.optionalexam3

// TODO
fun manipulateString(str: String, int: Int): String {
    val numberS = str.filter{it.isDigit()}
    val textS = str.filter {it.isLetter()}

    return if(numberS.isNotEmpty()){
        val number = numberS.toInt()* int
        textS + number
    }else {
        textS + int
    }
}
