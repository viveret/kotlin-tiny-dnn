package com.viveret.tinydnn.tinydnn.optimizer

import com.viveret.tinydnn.tinydnn.Optimizer

class MomentumOptimizer : Optimizer(staticConstructor()) {
    companion object {
        @JvmStatic
        external fun staticConstructor(): Long
    }
}