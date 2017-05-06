package io.github.datwheat.juwan;

import android.app.Application;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.squareup.leakcanary.LeakCanary;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class JApplication extends Application {
    private static final String BASE_URL = "https://api.graph.cool/simple/v1/cj2brg6o56vkn01044qv2wwab";
    private static final String SQL_CACHE_NAME = "juwan";

    private ApolloClient apolloClient;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        super.onCreate();
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .build();

        apolloClient = ApolloClient.<ApolloCall>builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .build();
    }

    public ApolloClient apolloClient() {
        return apolloClient;
    }
}
