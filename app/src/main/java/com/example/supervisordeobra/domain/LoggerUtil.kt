package com.example.supervisordeobra.domain

import com.example.supervisordeobra.domain.LogUtil.getTag

object LoggerUtil {

    inline fun logD(message: () -> String) {
        android.util.Log.d(getTag(), message())
    }

    inline fun logE(message: () -> String) {
        android.util.Log.d(getTag(), message())
    }
}

object LogUtil {

    fun getTag(): String {
        return Thread.currentThread().stackTrace
            .firstOrNull { it.className.contains("com.exemple") }
            ?.className
            ?.substringAfter(".")
            ?: "UnknownClass"
    }
}
