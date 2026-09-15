package biz.shikuro.rootoverlay

import android.app.*
import android.content.*
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.*

class MainActivity : Activity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b); setContentView(R.layout.activity_main)
        val status=findViewById<TextView>(R.id.status)
        findViewById<Button>(R.id.root).setOnClickListener { Thread { val ok=RootShell.check(); runOnUiThread { status.text=if(ok) "Root: OK" else "Root: unavailable/denied" } }.start() }
        findViewById<Button>(R.id.permission).setOnClickListener { startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName"))) }
        findViewById<Button>(R.id.start).setOnClickListener {
            if(!Settings.canDrawOverlays(this)){ status.text="Grant overlay permission first"; return@setOnClickListener }
            startForegroundService(Intent(this,OverlayService::class.java)); status.text="Overlay started"
        }
        findViewById<Button>(R.id.stop).setOnClickListener { stopService(Intent(this,OverlayService::class.java)); status.text="Overlay stopped" }
    }
}
