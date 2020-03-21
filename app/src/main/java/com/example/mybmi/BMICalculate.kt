package com.example.mybmi

import java.lang.Exception

open class BMICalculate constructor(vheight: Float, vweight: Float) {

    var vheight=vheight
    var vweight=vweight
    var bmi= 0.0f

     open fun fmetric(): Float{
         bmi= vweight/vheight/vheight*10000
        return  bmi

    }
    open fun fimperial(): Float{
        bmi= 703*vweight/vheight/vheight
        return  bmi

    }
    open fun validate():Boolean{
        if (bmi<=0.0f || bmi== Float.POSITIVE_INFINITY ||bmi.isNaN()){
            return false
        }
        else{
            return true
        }
    }


}