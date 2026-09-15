package biz.shikuro.rootoverlay

import android.app.*
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.*

class OverlayService : Service() {
    private lateinit var wm: WindowManager
    private var view: OverlayView? = null
    override fun onCreate() {
        super.onCreate()
        val id="overlay"
        getSystemService(NotificationManager::class.java).createNotificationChannel(NotificationChannel(id,"Overlay",NotificationManager.IMPORTANCE_LOW))
        startForeground(1, Notification.Builder(this,id).setContentTitle("Root Overlay").setContentText("Overlay active").setSmallIcon(android.R.drawable.ic_menu_view).build())
        wm=getSystemService(WINDOW_SERVICE) as WindowManager
        view=OverlayView(this).also { v ->
            val p=WindowManager.LayoutParams(-1,-1,WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT)
            wm.addView(v,p)
            // Demo rectangles only. Feed your own legitimate coordinates via updateBoxes().
            v.updateBoxes(listOf(OverlayBox(100f,200f,300f,600f), OverlayBox(450f,300f,650f,750f)))
        }
    }
    override fun onDestroy(){ view?.let { wm.removeView(it) }; view=null; super.onDestroy() }
    override fun onBind(intent: Intent?): IBinder?=null
}
