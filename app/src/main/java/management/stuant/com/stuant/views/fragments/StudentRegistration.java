package management.stuant.com.stuant.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import management.stuant.com.stuant.R;

/**
 * Created by USER on 12/5/2018.
 */

public class StudentRegistration extends BaseFragment {

    View mView;
    public static StudentRegistration newInstance() {
        return new StudentRegistration();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_student_registration, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
