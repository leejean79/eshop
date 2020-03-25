package com.leejean.kafkaconsumer;

import java.util.TimerTask;

/**
 * 关闭线程池
 */
public class CloseFSOuputStreamTask extends TimerTask{
    public void run() {
        HDFSOutputStreamPool pool = HDFSOutputStreamPool.getInstance();
        pool.releasePool();
    }
}