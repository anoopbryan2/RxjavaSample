package com.ithub.rxjavasample.Observers;

import android.util.Log;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by anoopbryan2 on 01/10/17.
 * anoopbryan2@gmail.com
 */

public class ConcatObserver {

    public static Observer<String> getObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("", " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(String value) {
                Log.d("", " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("", " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d("", " onComplete");
            }
        };
    }


}
