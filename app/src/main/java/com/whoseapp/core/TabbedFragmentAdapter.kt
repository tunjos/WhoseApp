package com.whoseapp.core

import android.support.v4.app.FragmentManager

import com.whoseapp.calls.CallsFragment
import com.whoseapp.chats.ChatsFragment

import com.whoseapp.core.TabType.TAB_CALLS
import com.whoseapp.core.TabType.TAB_CAMERA
import com.whoseapp.core.TabType.TAB_CHATS
import com.whoseapp.core.TabType.TAB_STATUS
import com.whoseapp.status.StatusFragment


/**
 * Fragment adapter that holds Fragments for the MainActivity.
 */
class TabbedFragmentAdapter(fm: FragmentManager) : CacheFragmentFactoryPagerAdapter(fm) {

    init {
        addTab(TAB_CAMERA) { ChatsFragment() }
        addTab(TAB_CHATS) { ChatsFragment() }
        addTab(TAB_STATUS) { StatusFragment() }
        addTab(TAB_CALLS) { CallsFragment() }
    }
}
