package diego.ramirez.com.mvp.interfaces.services;

import java.util.List;

import diego.ramirez.com.mvp.entities.Photo;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Diego-Lap on 12/03/2017.
 */

public interface PhotosRequest {

    @GET("/photos")
    void getPhotos(Callback<List<Photo>> photoCallback);
}
