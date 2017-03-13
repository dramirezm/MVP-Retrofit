package diego.ramirez.com.mvp.interactors;

import java.util.List;

import diego.ramirez.com.mvp.entities.Photo;
import diego.ramirez.com.mvp.interfaces.MainInteractor;
import diego.ramirez.com.mvp.interfaces.MainPresenter;
import diego.ramirez.com.mvp.interfaces.services.PhotosRequest;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Diego-Lap on 12/03/2017.
 */

public class MainInteractorImpl implements MainInteractor {

    MainPresenter presenter;
    String data;
    PhotosRequest photosRequest;

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    public MainInteractorImpl(MainPresenter presenter)
    {
        this.presenter = presenter;
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)//Setting the Root URL
                .build(); // building the adapter
         photosRequest = adapter.create(PhotosRequest.class);
    }

    @Override
    public void getData() {
                photosRequest.getPhotos(new Callback<List<Photo>>() {
                    @Override
                    public void success(List<Photo> photos, Response response) {
                        presenter.onSuccess(photos.toString());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        presenter.onError(error.getMessage());
                    }
                });
    }



}
