package com.reaf.design.request.model;

import com.reaf.design.request.config.model.Config;
import com.reaf.design.request.input.model.Input;

/**
 * Created by iabramov on 12/07/2015.
 */
public class Request {

    private Input input;
    private Config config;

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "Request{" +
                "input=" + input +
                ", config=" + config +
                '}';
    }
}
