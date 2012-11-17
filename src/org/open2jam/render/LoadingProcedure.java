package org.open2jam.render;

public abstract class LoadingProcedure extends Thread implements BlockingProcedure, StatusItem {

    private boolean done = false;
    private String status = "";

    public String getStatus() {
        return status;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    public LoadingProcedure() {
    }

    @Override public final void run() {
        work();
        done = true;
    }

    @Override
    public String getText() {
        return getStatus();
    }

    @Override
    public boolean isVisible() {
        return !isDone();
    }

    @Override
    public boolean isDone() {
        return done;
    }

    protected abstract void work();

}