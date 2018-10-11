package com.image.best.developodroid.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView
import android.graphics.Bitmap
import android.view.View


class VerticalBallLine : ImageView {

    private val paint : Paint= Paint()
    private val paintMiddleBall : Paint= Paint()
    private var lineThickness : Float = 6f
    private var outerBallSize : Float = lineThickness*3
    private var innerBallSize : Float = lineThickness*2
    private lateinit var bitmap : Bitmap

    constructor(context: Context?) : super(context){init(null,0)}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){init(attrs,0)}
    constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr){init(attrs,defStyleAttr)}

    private fun init(attrs: AttributeSet?, defStyleAttr: Int) {
        paint.color = resources.getColor(R.color.colorPrimary) // create attribute with the color
        paint.isAntiAlias = true
        paintMiddleBall.color = Color.WHITE
        paintMiddleBall.isAntiAlias = true // anti alias for better draw quality
        paint.strokeWidth= lineThickness
        bitmap = BitmapFactory.decodeResource(resources , R.drawable.logo)
        bitmap.width.div(2)

       // var rect = Rect(100,100,200,200)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 100
        val desiredHeight = 100
        val widthMode = View.MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = View.MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = View.MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = View.MeasureSpec.getSize(heightMeasureSpec)
        val width: Int
        val height: Int
        //Measure Width
        if (widthMode == View.MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize
        } else if (widthMode == View.MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize)
        } else {
            //Be whatever you want
            width = desiredWidth
        }
        //Measure Height
        if (heightMode == View.MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize
        } else if (heightMode == View.MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize)
        } else {
            //Be whatever you want
            height = desiredHeight
        }
        //MUST CALL THIS
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawLine(width.toFloat()/2, 0f, width.toFloat()/2, height.toFloat(), paint)
        canvas?.drawCircle(width.toFloat()/2,height.toFloat()/2,outerBallSize,paint)
        canvas?.drawCircle(width.toFloat()/2,height.toFloat()/2,innerBallSize,paintMiddleBall)

    }
}