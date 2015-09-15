package me.rhespanhol.instalib;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import retrofit.Retrofit;

/**
 * Created by rhespanhol on 09/09/15.
 */
public class MyInstagram extends Instagram {

    private final Context context;

    public MyInstagram(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    protected Retrofit.Builder newRestAdapterBuilder() {
        OkHttpClient client = ServiceUtils.getCachingOkHttpClient(context);

        return new Retrofit.Builder().client(client);
    }

}
