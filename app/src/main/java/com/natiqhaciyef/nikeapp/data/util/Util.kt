package com.natiqhaciyef.nikeapp.data.util

import com.natiqhaciyef.nikeapp.data.objects.Months

fun List<String>.toString(): String {
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
    for (i in item) {
        if (i != ' ') {
            temp += i
        } else {
            println(temp)
            list.add(temp)
            temp = ""
        }
    }
    return list
}

fun monthFinder(monthNumber: Int) = when (monthNumber) {
    0 -> Months.JANUARY.default
    1 -> Months.FEBRUARY.default
    2 -> Months.MARCH.default
    3 -> Months.APRIL.default
    4 -> Months.MAY.default
    5 -> Months.JUNE.default
    6 -> Months.JULY.default
    7 -> Months.AUGUST.default
    8 -> Months.SEPTEMBER.default
    9 -> Months.OCTOBER.default
    10 -> Months.NOVEMBER.default
    11 -> Months.DECEMBER.default
    else -> "Out of bound: $monthNumber is not required month"
}

fun yearFinder(yearNumber: Int) = yearNumber + 1900