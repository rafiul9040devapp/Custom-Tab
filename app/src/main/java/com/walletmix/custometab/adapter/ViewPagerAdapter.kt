package com.walletmix.custometab.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.walletmix.custometab.view.fragments.FridayFragment
import com.walletmix.custometab.view.fragments.MondayFragment
import com.walletmix.custometab.view.fragments.SaturdayFragment
import com.walletmix.custometab.view.fragments.SundayFragment
import com.walletmix.custometab.view.fragments.ThursdayFragment
import com.walletmix.custometab.view.fragments.TuesdayFragment
import com.walletmix.custometab.view.fragments.WednesdayFragment


class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUMBER_OF_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SundayFragment()
            1 -> MondayFragment()
            2 -> TuesdayFragment()
            3 -> WednesdayFragment()
            4 -> ThursdayFragment()
            5 -> FridayFragment()
            6 -> SaturdayFragment()
            else -> SundayFragment()
        }
    }

    companion object {
        private const val NUMBER_OF_TABS = 7
    }
}