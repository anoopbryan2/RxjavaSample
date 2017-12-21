package com.ithub.rxjavasample.Observers;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by anoopbryan2 on 20/12/17.
 * anoopbryan2@gmail.com
 */

public class MapObserver {

    public static Observer<List<Integer>> mapObserver() {
        return new Observer<List<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Integer> integers) {
                for (int i : integers) {
                    Log.e("observer ite", integers + "");
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    public static Observer<Integer> mapObserverForSingleNumber() {
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integers) {
                    Log.e("observer ite", integers + "");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("observer ite", e.getMessage() + "");
            }

            @Override
            public void onComplete() {

            }
        };
    }

    public static List<Integer> getSquare(List<Integer> numberList) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            list.add(i, Integer.parseInt(numberList.get(i) * numberList.get(i) + ""));
        }
        return list;
    }

    public static Integer getSquareOfSingleNumber(Integer numberList) {
        return numberList * numberList;
    }
}
