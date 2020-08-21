package st235.com.github.xcalc_android_wrapper.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors

internal interface ThreadMarshaller {

    fun post(runnable: Runnable)

}

internal class MainThreadMarshaller: ThreadMarshaller {

    private val handler = Handler(Looper.getMainLooper())

    override fun post(runnable: Runnable) {
        handler.post(runnable)
    }
}

internal class BackgroundThreadMarshaller: ThreadMarshaller {

    private val executor = Executors.newSingleThreadExecutor()

    override fun post(runnable: Runnable) {
        executor.execute(runnable)
    }
}
