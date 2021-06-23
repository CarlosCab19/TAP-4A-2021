package com.example.pong
import android.graphics.*
import android.os.Build
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import android.os.Bundle
import android.print.PrinterInfo
import android.view.ContextMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MotionEventCompat

class Dibujar(p:MainActivity): View(p)
{
    var toque=false
    var xd=50f
    var yd=50f
    var j1x=100f
    var j1y=200f
    var j2x=10f
    var j2y=1f
    var arriba= false

    override fun onDraw(c: Canvas)
    {

        object : CountDownTimer(200, 100) {
            override fun onTick(millisUntilFinished: Long) {
                if (!arriba) {
                    //xd+=20f
                    yd += 20f
                    colision(yd, xd)
                    jugSystem(j1x,j1y)
                }

                if (arriba) {
                    //xd+=20f
                    yd -= 20f
                    colision(yd, xd)
                    jugSystem(j1x,j1y)
                }
                invalidate()
            }
            override fun onFinish() {

            }

        }.start()



        super.onDraw(c)
        val p= Paint()
        c.drawColor(Color.BLACK)
        p.color= Color.YELLOW
        c.drawCircle(xd, yd, 35f,p)
        p.color= Color.BLUE
        c.drawRoundRect(RectF(100F, 60f, 300F, 20f), j1x, j1y, p)

        p.color= Color.GREEN
        c.drawRoundRect(RectF(100f, 2060f, 300f, 2100f), j2x, j2y, p)
    }
    private fun jugSystem(x: Float, y: Float){
        j1x+= ((Math.random() * 1000).toFloat())
        invalidate()
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return when (MotionEventCompat.getActionMasked(event)) {

            // Display a Toast whenever a movement is captured on the screen
            MotionEvent.ACTION_MOVE -> {
                yd+=event.getY()
                true
            }
            else -> super.onTouchEvent(event)
        }
    }


    private fun colision(y: Float,x: Float) {
        if (yd>=2200)
        {
            yd= 2200F

            arriba=true
        }
        if (yd<=0)
        {
            yd= 0F

            arriba =false
        }

    }

}