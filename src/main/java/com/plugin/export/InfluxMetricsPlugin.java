package com.plugin.export;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.influx.InfluxConfig;
import io.micrometer.influx.InfluxMeterRegistry;
import org.apache.activemq.artemis.core.server.metrics.ActiveMQMetricsPlugin;

import java.util.HashMap;
import java.util.Map;

public class InfluxMetricsPlugin implements ActiveMQMetricsPlugin {

    private final Map<String, String> props = new HashMap<String, String>();

    private final InfluxConfig influxConfig = props::get;

    public ActiveMQMetricsPlugin init(Map<String, String> map) {
        props.putAll(map);
        return this;
    }

    public MeterRegistry getRegistry() {
        return InfluxMeterRegistry.builder(influxConfig).build();
    }
}
