package com.natiqhaciyef.nikeapp.data.util

fun List<String>.toString(): String{
    var result = ""
    this.forEach {
        result += "$it "
    }
    return result
}

fun String.toList(): List<String> {
    val list = mutableListOf<String>()
    val item = this.toMutableList()
    item.add(' ')
    var temp = ""
    for (i in item){
        if (i != ' '){
            temp += i
        }else{
            println(temp)
            list.add(temp)
            temp = ""
        }
    }
    return list
}
