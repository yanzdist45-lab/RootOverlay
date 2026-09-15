package biz.shikuro.rootoverlay

object RootShell {
    fun check(): Boolean = try {
        val p = ProcessBuilder("su", "-c", "id").redirectErrorStream(true).start()
        val out = p.inputStream.bufferedReader().readText()
        p.waitFor() == 0 && out.contains("uid=0")
    } catch (_: Throwable) { false }
}
