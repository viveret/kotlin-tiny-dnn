package com.viveret.tinydnn.tinydnn.util

import com.viveret.tinydnn.tinydnn.Layer
import com.viveret.tinydnn.tinydnn.model.INetworkModelWithWeights
import java.util.*

class TestResult {
    val numSuccess: Int
        external get
    val numTotal: Int
        external get

    internal fun accuracy(): Float = -1f

    internal fun printSummary(): String? = null

    internal fun print_detail(): String? = null

    fun labels(): HashSet<Long>? = null
    //
    //    INetworkModelWithWeights<SequentialNetworkModelWithWeights> (INetworkModelWithWeights<SequentialNetworkModelWithWeights> n, Layer l) {
    //        return null;
    //    }

    external fun construct_graph(graph: INetworkModelWithWeights, inputs: List<Layer<*>>, outputs: List<Layer<*>>)
}
