package com.kichu.androidreferences.data

data class OuterData (
    val outerText : String,
    val innerList : List<InnerData>
        ) {
    data class InnerData(
        val innerText : String
    )
}