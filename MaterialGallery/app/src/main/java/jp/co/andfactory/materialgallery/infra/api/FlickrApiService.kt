package jp.co.andfactory.materialgallery.infra.api

import io.reactivex.Observable
import jp.co.andfactory.materialgallery.BuildConfig
import jp.co.andfactory.materialgallery.infra.entity.FlickrPhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by watanabe on 2017/12/19.
 */
interface FlickrApiService {

    /**
     * https://www.flickr.com/services/api/flickr.photos.search.html
     */
    @GET("/services/rest?method=flickr.photos.search&api_key=" + BuildConfig.FLICKR_API_KEY + "&format=json&nojsoncallback=1")
    fun photoSearch(@Query("text") text: String,
                    @Query("page") page: Int?,
                    @Query("per_page") perpage: Int?,
                    @Query("sort") sort: String): Observable<FlickrPhotoResponse>
}