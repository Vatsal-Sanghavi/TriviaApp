package com.android.triviaapp.ui.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/**
 * Created  on 18/08/17.
 */

public abstract class MVPBaseBottomSheetDialogFragment<P extends MVPBasePresenter> extends BottomSheetDialogFragment implements MVPBaseView<P> {

    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getNewPresenter();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getPresenter().bindView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().unBindView();
    }

    @Override
    public boolean isAlive() {
        return getActivity() != null
                && isAdded();
    }

    public final P getPresenter() {
        return presenter;
    }

}
