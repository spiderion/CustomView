package com.image.best.developodroid.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class VerticalBallLine : View {

    private val paint : Paint= Paint()
    private val paintMiddleBall : Paint= Paint()
    private var lineThickness : Float = 6f
    private var outerBallSize : Float = lineThickness*3
    private var innerBallSize : Float = lineThickness*2

    constructor(context: Context?) : super(context){init(null,0)}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){init(attrs,0)}
    constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr){init(attrs,defStyleAttr)}

    private fun init(attrs: AttributeSet?, defStyleAttr: Int) {
        paint.color = resources.getColor(R.color.colorPrimary) // create attribute with the color 
        paint.isAntiAlias = true
        paintMiddleBall.color = Color.WHITE
        paintMiddleBall.isAntiAlias = true // anti alias for better draw quality
        paint.strokeWidth= lineThickness

    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawLine(width.toFloat()/2, 0f, width.toFloat()/2, height.toFloat(), paint)
        canvas?.drawCircle(width.toFloat()/2,height.toFloat()/2,outerBallSize,paint)
        canvas?.drawCircle(width.toFloat()/2,height.toFloat()/2,innerBallSize,paintMiddleBall)
    }

}