package diego.ramirez.com.mvp.interfaces;

/**
 * Created by Diego-Lap on 12/03/2017.
 */

public interface MainPresenter {
    void getData();
    void onSuccess(String data);
    void onError(String error);
}
