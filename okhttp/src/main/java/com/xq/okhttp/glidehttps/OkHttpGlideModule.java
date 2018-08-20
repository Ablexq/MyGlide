package com.xq.okhttp.glidehttps;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;
import com.xq.okhttp.utils.HTTPSUtils;
import com.xq.okhttp.utils.SSLSocketClient;

import java.io.InputStream;

import okhttp3.OkHttpClient;

public class OkHttpGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

//        setBitmapPool(BitmapPool bitmapPool)
//        设置Bitmap的缓存池，用来重用Bitmap，需要实现BitmapPool接口，它的默认实现是LruBitmapPool
//
//        setMemoryCache(MemoryCache memoryCache)
//        设置内存缓存，需要实现MemoryCache接口，默认实现是LruResourceCache。
//
//        setDiskCache(DiskCache.Factory diskCacheFactory)
//        设置磁盘缓存，需要实现DiskCache.Factory，默认实现是InternalCacheDiskCacheFactory
//
//        setResizeService(ExecutorService service)
//        当资源不在缓存中时，需要通过这个Executor发起请求，默认是实现是FifoPriorityThreadPoolExecutor。
//
//        setDiskCacheService(ExecutorService service)
//        读取磁盘缓存的服务，默认实现是FifoPriorityThreadPoolExecutor。
//
//        setDecodeFormat(DecodeFormat decodeFormat)
//        用于控制Bitmap解码的清晰度，DecodeFormat可选的值有PREFER_ARGB_8888/PREFER_RGB_565，默认为PREFER_RGB_565。

    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        //注意：new HTTPSUtils(context).getInstance()为已经通过认证的okhttpclient
//        OkHttpClient mHttpClient = new HTTPSUtils(context).getInstance();

        /* 忽略HTTPS证书 */
        OkHttpClient mHttpClient = new OkHttpClient().newBuilder()
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();

        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(mHttpClient));
    }
}

/*


*/