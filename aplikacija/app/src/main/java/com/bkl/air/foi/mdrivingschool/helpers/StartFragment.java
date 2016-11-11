package com.bkl.air.foi.mdrivingschool.helpers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;

import com.bkl.air.foi.mdrivingschool.R;

/**
 * Created by Bunic on 11.11.2016..
 */

public class StartFragment {
    /**StartFragment
     * Metoda prima tri parametra. Dobiveni fragment pokreće i sprema ga na BackStack pod prosljeđenim
     * tagom
     *
     * @param fragment tip Fragment
     * @param mActivity tip Activity
     * @param tag   tip String
     */
    public static void StartNewFragment (Fragment fragment, String tag, Activity mActivity){
        FragmentTransaction fm = mActivity.getFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container, fragment);
        fm.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fm.addToBackStack(tag);
        fm.commit();
    }
}