package com.openplugins.tntrun.utils;

public enum State {

    LOBBY(true),WARMUP(false),INGAME(true),OVER(false);

    private boolean join;

    State(boolean join) {
        this.join=join;
    }

    public boolean isJoin() {
        return join;
    }
}
