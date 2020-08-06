package com.dcj.state.v1;

public abstract class CarState {
    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
}
