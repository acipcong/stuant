package management.stuant.com.stuant.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import management.stuant.com.stuant.R;
import management.stuant.com.stuant.models.DashboardItem;
import management.stuant.com.stuant.views.adapters.DashboardAdapter;

/**
 * Created by USER on 11/25/2018.
 */

public class HomeFragment extends BaseFragment/* implements OnMapReadyCallback*/ {

    View mView;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_home, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
