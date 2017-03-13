package diego.ramirez.com.mvp.interfaces;

/**
 * Created by Diego-Lap on 12/03/2017.
 */

public interface MainFragmentView {

    void onShowProgressDialog(boolean status);
    void setData(String data);
    void setError(String error);
}
