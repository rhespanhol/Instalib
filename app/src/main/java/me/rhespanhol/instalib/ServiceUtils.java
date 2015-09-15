/*
 * Copyright 2014 Uwe Trottmann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.rhespanhol.instalib;

import android.content.Context;
import android.os.StatFs;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Helper methods to interact with third-party services trakt and The Movie Database used within
 * SeriesGuide.
 */
public final class ServiceUtils {

    public static final String TAG = "Service Utils";

    static final int CONNECT_TIMEOUT_MILLIS = 15 * 1000; // 15s
    static final int READ_TIMEOUT_MILLIS = 20 * 1000; // 20s
    private static final String API_CACHE = "api-cache";
    private static final int MIN_DISK_API_CACHE_SIZE = 2 * 1024 * 1024; // 2MB
    private static final int MAX_DISK_API_CACHE_SIZE = 10 * 1024 * 1024; // 10MB

    private static OkHttpClient cachingHttpClient;

    /* This class is never initialized */
    private ServiceUtils() {
    }

    /**
     * Returns this apps {@link OkHttpClient} with enabled response cache.
     * Should be used with API calls.
     */
    public static synchronized OkHttpClient getCachingOkHttpClient(Context context) {
        if (cachingHttpClient == null) {
            cachingHttpClient = new OkHttpClient();
            cachingHttpClient.setConnectTimeout(CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            cachingHttpClient.setReadTimeout(READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            File cacheDir = createApiCacheDir(context);
            cachingHttpClient.setCache(
                    new Cache(cacheDir, calculateApiDiskCacheSize(cacheDir)));
        }
        return cachingHttpClient;
    }

    static File createApiCacheDir(Context context) {
        File cache = new File(context.getApplicationContext().getCacheDir(), API_CACHE);
        if (!cache.exists()) {
            cache.mkdirs();
        }
        return cache;
    }

    static long calculateApiDiskCacheSize(File dir) {
        long size = MIN_DISK_API_CACHE_SIZE;

        try {
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            long available = ((long) statFs.getBlockCount()) * statFs.getBlockSize();
            // Target 2% of the total space.
            size = available / 50;
        } catch (IllegalArgumentException ignored) {
        }

        // Bound inside min/max size for disk cache.
        return Math.max(Math.min(size, MAX_DISK_API_CACHE_SIZE), MIN_DISK_API_CACHE_SIZE);
    }
}
