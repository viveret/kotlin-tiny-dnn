package com.viveret.tinydnn.tinydnn

import com.viveret.tinydnn.util.JniObject

interface Node : JniObject {
    val prevNodes: List<Node>

    val nextNodes: List<Node>

    val next: List<Edge>

    val prev: List<Edge>
}
