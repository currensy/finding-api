package com.reaf.design.request;

import com.reaf.design.items.handler.ItemsHandler;
import com.reaf.design.request.config.model.Config;
import com.reaf.design.request.config.model.ConfigInstructions;
import com.reaf.design.request.config.service.ConfigService;
import com.reaf.design.request.input.model.Input;
import com.reaf.design.request.input.model.InputInstructions;
import com.reaf.design.request.input.service.InputService;
import com.reaf.design.request.model.Request;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Response;

/**
 * Created by iabramov on 12/07/2015.
 */
public class RequestProcessorImpl implements RequestProcessor {

    @Autowired
    private InputService inputService;

    @Autowired
    private ConfigService configService;

    @Autowired
    private ItemsHandler itemsHandler;

    /*private InputInstructions processInput(Input input){
        return inputService.handleInput(input);
    }

    private ConfigInstructions processConfig(Config cfg){
        return configService.handleConfig(cfg);
    }

    public Response processRequest(Request req){
        return itemsHandler.getItems(processInput(req.getInput()),processConfig(req.getConfig()));
    }*/

    public InputService getInputService() {
        return inputService;
    }

    public void setInputService(InputService inputService) {
        this.inputService = inputService;
    }

    public ConfigService getConfigService() {
        return configService;
    }

    public void setConfigService(ConfigService configService) {
        this.configService = configService;
    }

    public ItemsHandler getItemsHandler() {
        return itemsHandler;
    }

    public void setItemsHandler(ItemsHandler itemsHandler) {
        this.itemsHandler = itemsHandler;
    }

    @Override
    public String toString() {
        return "RequestProcessorImpl{" +
                "inputService=" + inputService +
                ", configService=" + configService +
                ", itemsHandler=" + itemsHandler +
                '}';
    }
}
