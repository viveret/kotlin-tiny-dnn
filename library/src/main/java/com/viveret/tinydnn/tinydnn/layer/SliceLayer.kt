package com.viveret.tinydnn.tinydnn.layer

import android.text.InputType
import com.viveret.tinydnn.R
import com.viveret.tinydnn.R2
import com.viveret.tinydnn.reflection.annotations.CustomUserField
import com.viveret.tinydnn.reflection.annotations.UserConstructor
import com.viveret.tinydnn.reflection.annotations.UserField
import com.viveret.tinydnn.reflection.annotations.UserFields

class SliceLayer private constructor(nativeObjectHandle: Long) : LayerBase(nativeObjectHandle) {
    @UserConstructor(R2.string.layer_slice, 0)
    constructor(@UserField(UserFields.PreviousLayer) prevLayer: LayerBase,
                @CustomUserField(R2.string.slice_type, R2.string.slice_type_hint, InputType.TYPE_CLASS_NUMBER) slice_type: Long,
                @CustomUserField(R2.string.num_outputs, R2.string.num_outputs_hint, InputType.TYPE_CLASS_NUMBER) num_outputs: Long) :
            this(staticConstructor(prevLayer.nativeObjectHandle, slice_type, num_outputs))

    companion object {
        @JvmStatic
        external fun staticConstructor(prevLayer: Long, slice_type: Long, num_outputs: Long): Long

        fun wrap(handle: Long): SliceLayer = SliceLayer(handle)
    }
}
