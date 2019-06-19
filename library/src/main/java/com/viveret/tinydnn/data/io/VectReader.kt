package com.viveret.tinydnn.data.io

import com.viveret.tinydnn.tinydnn.Vect

interface VectReader : SimpleReader<Vect> {
    fun read(destination: Array<Vect>, maxLength: Long): Int
}