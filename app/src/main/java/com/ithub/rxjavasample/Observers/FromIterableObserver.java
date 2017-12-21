package com.ithub.rxjavasample.Observers;

import android.database.Observable;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by anoopbryan2 on 01/10/17.
 * anoopbryan2@gmail.com
 */

public class FromIterableObserver {
    public static String TAG = FromIterableObserver.class.getSimpleName();

    public static Observer<Integer> fromIterable() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onNext" + String.valueOf(integer));

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onNext" + String.valueOf(e.getMessage()));
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "oncomplete");
            }
        };
    }
}
