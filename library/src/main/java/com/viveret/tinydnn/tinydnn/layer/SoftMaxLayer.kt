package com.viveret.tinydnn.tinydnn.layer

import android.text.InputType
import com.viveret.tinydnn.R
import com.viveret.tinydnn.R2
import com.viveret.tinydnn.reflection.annotations.CustomUserField
import com.viveret.tinydnn.reflection.annotations.UserConstructor
import com.viveret.tinydnn.reflection.annotations.UserField
import com.viveret.tinydnn.reflection.annotations.UserFields

class SoftMaxLayer private constructor(nativeObjectHandle: Long) : LayerBase(nativeObjectHandle) {
    @UserConstructor(R2.string.layer_soft_max, 0)
    constructor(@UserField(UserFields.InDim) in_dim: Long,
                @UserField(UserFields.OutDim) out_dim: Long) : this(staticConstructor(in_dim, out_dim))

    @UserConstructor(R2.string.layer_soft_max, 0)
    constructor(@UserField(UserFields.InWidth) width: Long,
                @UserField(UserFields.InHeight) height: Long,
                @CustomUserField(R2.string.nmaps, R2.string.nmaps_hint, InputType.TYPE_CLASS_NUMBER) nmaps: Long) : this(staticConstructor(width, height, nmaps))

    companion object {
        @JvmStatic
        external fun staticConstructor(inDim: Long, outDim: Long): Long

        @JvmStatic
        external fun staticConstructor(width: Long, height: Long, inChannels: Long): Long

        fun attach(handle: Long): SoftMaxLayer = SoftMaxLayer(handle)
    }
}
