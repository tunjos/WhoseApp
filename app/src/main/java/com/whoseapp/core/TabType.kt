package com.whoseapp.core

import android.support.annotation.IntDef

@Retention(AnnotationRetention.SOURCE)
@IntDef(
        TabType.TAB_CAMERA.toLong(),
        TabType.TAB_CHATS.toLong(),
        TabType.TAB_STATUS.toLong(),
        TabType.TAB_CALLS.toLong()
)
annotation class TabTypes

object TabType {
    const val TAB_CAMERA = 0
    const val TAB_CHATS = 1
    const val TAB_STATUS = 2
    const val TAB_CALLS = 3
}
