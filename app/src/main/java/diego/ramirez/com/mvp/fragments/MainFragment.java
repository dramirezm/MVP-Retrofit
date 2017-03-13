package diego.ramirez.com.mvp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import diego.ramirez.com.mvp.R;
import diego.ramirez.com.mvp.interactors.MainPresenterImpl;
import diego.ramirez.com.mvp.interfaces.MainFragmentView;
import diego.ramirez.com.mvp.interfaces.MainPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainFragmentView {

    View rootView;
    TextView lblData;
    ProgressBar progressBar;
    Button btnGetData;
    MainPresenter mainPresenter;

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();

        return mainFragment;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mainPresenter = new MainPresenterImpl(this);
        lblData =(TextView) rootView.findViewById(R.id.lbl_data);
        progressBar = (ProgressBar)rootView.findViewById(R.id.progress);
        btnGetData = (Button)rootView.findViewById(R.id.btn_get_data);


        btnGetData .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.getData();
            }
        });
        return rootView;
    }



    @Override
    public void onShowProgressDialog(boolean status) {
        if (status)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setData(String data) {
        lblData.setText(data);
    }

    @Override
    public void setError(String error) {
        lblData.setText(error);
    }
}
