package com.titusnangi.chucknorrisjokes;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {

    //this class is for implementing the app executors for background tasks

    //creating a singleton pattern
    private static AppExecutors instance;

    public static AppExecutors getInstance(){
        if (instance == null){
            instance = new AppExecutors();
        }
        return instance;
    }

    // to execute retrofit calls in the background, with 3 as the
    // number of threads that going to execute
    private final ScheduledExecutorService mNetworkIO = Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService networkIO(){
        return mNetworkIO;
    }



}
