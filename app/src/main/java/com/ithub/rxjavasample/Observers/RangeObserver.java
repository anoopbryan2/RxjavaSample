package com.ithub.rxjavasample.Observers;

import android.util.Log;
import android.widget.Toast;

import com.ithub.rxjavasample.MainActivity;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by anoopbryan2 on 01/10/17.
 * anoopbryan2@gmail.com
 */

public class RangeObserver {
    public static String TAG=RangeObserver.class.getSimpleName();

    public static Observer<Integer> rangeObserver() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe");
            }

            @Override
            public void onNext(Integer integer) {
                Log.e(TAG, "onNext" + String.valueOf(integer));
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, "onError" + t.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete");
            }
        };
    }
}
