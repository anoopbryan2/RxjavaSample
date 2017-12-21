package com.ithub.rxjavasample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ithub.rxjavasample.Observers.ConcatObserver;
import com.ithub.rxjavasample.Observers.FromIterableObserver;
import com.ithub.rxjavasample.Observers.IntervalObserver;
import com.ithub.rxjavasample.Observers.JustObserver;
import com.ithub.rxjavasample.Observers.MapObserver;
import com.ithub.rxjavasample.Observers.RangeObserver;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName().toString();
    List<Integer> myIntegerList = new ArrayList<>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myIntegerList.add(1);
        myIntegerList.add(2);
        myIntegerList.add(3);
        myIntegerList.add(4);
        myIntegerList.add(5);
        myIntegerList.add(6);
        Log.e(TAG, "onCreate");

        findViewById(R.id.butShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] aStrings = {"anoop", "yamini", "neeraj", "tushar"};
                final String[] bStrings = {"chanki", "sumit", "dhirru"};
                final Observable<String> aObservable = Observable.fromArray(aStrings);
                final Observable<String> bObservable = Observable.fromArray(bStrings);
                Observable.concat(aObservable, bObservable)
                        .subscribe(ConcatObserver.getObserver());
            }
        });

        findViewById(R.id.butRange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.range(1, 5)
                        .subscribe(RangeObserver.rangeObserver());
            }
        });

        findViewById(R.id.butJust).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.just("your single data")
                        .subscribe(JustObserver.getJustObserver());
            }
        });

        findViewById(R.id.butIterate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.fromIterable(myIntegerList)
                        .subscribe(FromIterableObserver.fromIterable());
            }
        });

        findViewById(R.id.butInterval).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.interval(3, TimeUnit.SECONDS).skip(3)
                        .subscribe(IntervalObserver.getIntervalObserver());
            }
        });

        findViewById(R.id.butFlowable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Flowable.just("subscribe just")
                        .subscribe(JustObserver.getJustSubscriber());
            }
        });

        findViewById(R.id.butMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.fromIterable(myIntegerList).map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integers) throws Exception {
                        return MapObserver.getSquareOfSingleNumber(integers);
                    }
                })
                        .observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
                        .subscribe(MapObserver.mapObserverForSingleNumber());
            }
        });
    }
}
