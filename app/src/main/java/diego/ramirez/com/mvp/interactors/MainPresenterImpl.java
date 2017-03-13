package diego.ramirez.com.mvp.interactors;

import diego.ramirez.com.mvp.interfaces.MainFragmentView;
import diego.ramirez.com.mvp.interfaces.MainInteractor;
import diego.ramirez.com.mvp.interfaces.MainPresenter;

/**
 * Created by Diego-Lap on 12/03/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    MainFragmentView view;
    MainInteractor interactor;

    public MainPresenterImpl(MainFragmentView view)
    {
        this.view = view;
        interactor = new MainInteractorImpl(this);
    }


    @Override
    public void getData() {
        if (view != null)
        {
            view.onShowProgressDialog(true);
            interactor.getData();
        }
    }

    @Override
    public void onSuccess(String data) {
        if (view != null)
        {
            view.onShowProgressDialog(false);
            view.setData(data);
        }
    }

    @Override
    public void onError(String error) {
        if (view != null)
        {
            view.onShowProgressDialog(false);
            view.setError(error);
        }
    }
}
