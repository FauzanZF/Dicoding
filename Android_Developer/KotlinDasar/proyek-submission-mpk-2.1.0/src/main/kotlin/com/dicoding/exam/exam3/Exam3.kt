package com.dicoding.exam.exam3

// TODO
fun <T> checkType(args: T): String {
    return when (args){
        is String -> "Yes! it's String"
        is Boolean -> "Yes! it's Boolean"
        is Int -> "Yes! it's Integer"
        is Double -> "Yes! it's Double"
        is Map<*,*> -> "Yes! it's Map"
        is List<*> -> "Yes! it's List"
        else -> "false"
    }
}