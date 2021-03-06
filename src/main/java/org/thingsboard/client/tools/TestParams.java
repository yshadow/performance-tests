/**
 * Copyright © 2016-2017 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.client.tools;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class TestParams {
    static final String TEST_PROPERTIES = "test.properties";
    static final int DEFAULT_DEVICE_COUNT = 1000;
    static final int DEFAULT_PUBLISH_TELEMETRY_COUNT = 100;
    static final int DEFAULT_PUBLISH_TELEMETRY_PAUSE = 100;
    static final String DEFAULT_REST_URL = "http://localhost:8080";
    static final String DEFAULT_MQTT_URLS = "tcp://localhost:1883";
    static final String DEFAULT_USERNAME = "tenant@thingsboard.org";
    static final String DEFAULT_PASSWORD = "tenant";

    private Properties params = new Properties();

    public TestParams() throws IOException {
        try {
            params.load(TestParams.class.getClassLoader().getResourceAsStream(TEST_PROPERTIES));
        } catch (Exception e) {
            log.warn("Failed to read " + TEST_PROPERTIES);
        }
    }

    public int getDeviceCount() {
        return Integer.valueOf(params.getProperty("deviceCount", Integer.toString(DEFAULT_DEVICE_COUNT)));
    }

    public String getRestApiUrl() {
        return params.getProperty("restUrl", DEFAULT_REST_URL);
    }

    public String[] getMqttUrls() {
        return params.getProperty("mqttUrls", DEFAULT_MQTT_URLS).split(",");
    }

    public String getUsername() {
        return params.getProperty("username", DEFAULT_USERNAME);
    }

    public String getPassword() {
        return params.getProperty("password", DEFAULT_PASSWORD);
    }

    public int getPublishTelemetryCount() {
        return Integer.valueOf(params.getProperty("publishTelemetryCount", Integer.toString(DEFAULT_PUBLISH_TELEMETRY_COUNT)));
    }

    public int getPublishTelemetryPause() {
        return Integer.valueOf(params.getProperty("publishTelemetryPause", Integer.toString(DEFAULT_PUBLISH_TELEMETRY_PAUSE)));
    }
}
