package com.ithub.rxjavasample.Observers;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by anoopbryan2 on 01/10/17.
 * anoopbryan2@gmail.com
 */

public class IntervalObserver {

    public static String TAG = IntervalObserver.class.getSimpleName();

    public static Observer<Long> getIntervalObserver() {
        return new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long s) {
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
}
