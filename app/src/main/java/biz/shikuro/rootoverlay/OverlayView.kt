package biz.shikuro.rootoverlay

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View

data class OverlayBox(val left: Float, val top: Float, val right: Float, val bottom: Float)

class OverlayView(context: Context) : View(context) {
    private val boxes = mutableListOf<OverlayBox>()
    private val paint = Paint().apply { style = Paint.Style.STROKE; strokeWidth = 4f; isAntiAlias = true }

    fun updateBoxes(items: List<OverlayBox>) { boxes.clear(); boxes.addAll(items); invalidate() }
    override fun onDraw(canvas: Canvas) { super.onDraw(canvas); boxes.forEach { canvas.drawRect(it.left,it.top,it.right,it.bottom,paint) } }
}
