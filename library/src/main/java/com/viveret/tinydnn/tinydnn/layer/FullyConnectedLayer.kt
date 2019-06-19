package com.viveret.tinydnn.tinydnn.layer

import com.viveret.tinydnn.R2
import com.viveret.tinydnn.reflection.annotations.UserConstructor
import com.viveret.tinydnn.reflection.annotations.UserField
import com.viveret.tinydnn.reflection.annotations.UserFields

class FullyConnectedLayer private constructor(nativeObjectHandle: Long) : LayerBase(nativeObjectHandle) {
    @UserConstructor(R2.string.layer_fc, 0)
    constructor(@UserField(UserFields.InDim) in_dim: Long,
                @UserField(UserFields.OutDim) out_dim: Long,
                @UserField(UserFields.HasBias) has_bias: Boolean) : this(staticConstructor(in_dim, out_dim, has_bias))

    @UserConstructor(R2.string.layer_fc, 0)
    constructor(@UserField(UserFields.PreviousLayer) prevLayer: LayerBase,
                @UserField(UserFields.OutDim) out_dim: Long,
                @UserField(UserFields.HasBias) has_bias: Boolean) : this(prevLayer.out_data_size(), out_dim, has_bias)

    companion object {
        @JvmStatic
        external fun staticConstructor(in_dim: Long,
                                       out_dim: Long,
                                       has_bias: Boolean): Long

        fun wrap(handle: Long): FullyConnectedLayer = FullyConnectedLayer(handle)
    }
}
