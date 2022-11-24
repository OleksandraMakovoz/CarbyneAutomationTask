package org.makovoz.service;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.util.HashMap;

public enum AppiumService {

    SERVICE;
    private AppiumDriverLocalService server;

    public void start() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingAnyFreePort();
        HashMap<String, String> environment = new HashMap<>();
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
        serviceBuilder.withEnvironment(environment);

        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
        server.clearOutPutStreams();
    }

    public String getUrl() {
        if (server == null && !server.isRunning()) {
            start();
        }
        return server.getUrl().toString();
    }

    public void stop() {
        if (server != null && server.isRunning()) {
            server.stop();
        }
    }
}
