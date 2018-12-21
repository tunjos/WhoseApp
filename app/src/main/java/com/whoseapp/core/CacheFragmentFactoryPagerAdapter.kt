package com.whoseapp.core

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.SparseArray
import com.whoseapp.R

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
abstract class CacheFragmentFactoryPagerAdapter(private val fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val fragments: SparseArray<Fragment> = SparseArray()
    private val factories: SparseArray<() -> Fragment> = SparseArray()

    override fun getItem(position: Int): android.support.v4.app.Fragment {
        // the Fragment may already be present after config changes
        var fragment: Fragment? = fragmentManager.findFragmentByTag(makeFragmentName(position))
        fragment.let { fragments.put(position, it) }

        fragment = fragments.get(position)
        if (fragment == null) {
            val factory = factories.get(position)
            fragment = factory.invoke()
            fragments.put(position, fragment)
        }

        return fragment
    }

    /**
     * Copied from *private* super method [super.makeFragmentName]
     *
     * @param position the position of the Fragment whose tag name is to be retrieved
     * @return a unique tag name for the given `position`
     */
    private fun makeFragmentName(position: Int): String {
        return "android:switcher:" + R.id.view_pager + ":" + position
    }

    override fun getCount(): Int {
        return factories.size()
    }

    protected fun addTab(tab: Int, factory: () -> Fragment) {
        factories.put(tab, factory)
    }
}
