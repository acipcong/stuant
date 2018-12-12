package management.stuant.com.stuant.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.TextView;

import management.stuant.com.stuant.R;

/**
 * Created by USER on 11/25/2018.
 */

public class BaseFragment extends Fragment {

    TextView headerTitle;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        headerTitle = (TextView) view.findViewById(R.id.title);
    }

    public void setHeaderTitle(String title){
        if(title != null){
            headerTitle.setText(title);
        }
    }

    public void replaceFragment(BaseFragment fragment, int layout){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(layout, fragment).commit();
    }

}
