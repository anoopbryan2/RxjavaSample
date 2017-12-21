package com.ithub.rxjavasample.Observers;

import android.nfc.Tag;
import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by anoopbryan2 on 01/10/17.
 * anoopbryan2@gmail.com
 */

public class JustObserver {
    public static String TAG = JustObserver.class.getSimpleName();

    public static Observer<String> getJustObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, s.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, e.toString());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };
    }

    public static Subscriber<String> getJustSubscriber() {
        return new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "subscriber" + s.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "subscriber" + e.toString());
            }

            @Override
            public void onComplete() {

                Log.d(TAG, "subscriber" + "onComplete");
            }
        };
    }


}
