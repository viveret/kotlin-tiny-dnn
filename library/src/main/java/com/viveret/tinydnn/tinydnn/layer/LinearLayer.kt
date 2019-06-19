package com.viveret.tinydnn.tinydnn.layer

import android.text.InputType
import com.viveret.tinydnn.R
import com.viveret.tinydnn.R2
import com.viveret.tinydnn.reflection.annotations.CustomUserField
import com.viveret.tinydnn.reflection.annotations.UserConstructor
import com.viveret.tinydnn.reflection.annotations.UserField
import com.viveret.tinydnn.reflection.annotations.UserFields

class LinearLayer private constructor(nativeObjectHandle: Long) : LayerBase(nativeObjectHandle) {
    /**
     * @param dim   [in] number of elements
     * @param scale [in] factor by which to multiply
     * @param bias  [in] bias term
     **/
    @UserConstructor(R2.string.layer_linear, 0)
    constructor(@UserField(UserFields.InDim) dim: Long,
                @CustomUserField(R2.string.scale, R2.string.scale_hint, InputType.TYPE_NUMBER_FLAG_DECIMAL) scale: Double,
                @UserField(UserFields.Bias) bias: Double) :
            this(staticConstructor(dim, scale, bias)) {
        // backend_t backend_type = core::default_engine()
    }

    /**
     * @param dim   [in] number of elements
     * @param scale [in] factor by which to multiply
     * @param bias  [in] bias term
     **/
    @UserConstructor(R2.string.layer_linear, 0)
    constructor(@UserField(UserFields.PreviousLayer) prevLayer: LayerBase,
                @CustomUserField(R2.string.scale, R2.string.scale_hint, InputType.TYPE_NUMBER_FLAG_DECIMAL) scale: Double,
                @UserField(UserFields.Bias) bias: Double) :
            this(prevLayer.out_data_size(), scale, bias) {
        // backend_t backend_type = core::default_engine()
    }

    companion object {
        /**
         * @param dim   [in] number of elements
         * @param scale [in] factor by which to multiply
         * @param bias  [in] bias term
         **/
        @JvmStatic
        external fun staticConstructor(dim: Long, scale: Double, bias: Double): Long

        fun wrap(handle: Long): LinearLayer = LinearLayer(handle)
    }
}