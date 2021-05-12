package com.android.triviaapp.ui.base;

/**
 * Created on 27/10/16.
 */

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.triviaapp.R;

/**
 * BaseFragment for all fragments
 * - Has all common functionalites needed in all fragments
 */

public abstract class BaseFragment<P extends MVPBasePresenter> extends MVPBaseFragment<P> {

    /**
     * Returns screen name of current screen
     * Used in analytics
     *
     * @return
     */

    public void startFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}
