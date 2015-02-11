package com.netflix.eureka2.server.config;

import com.netflix.eureka2.registry.datacenter.LocalDataCenterInfo;
import com.netflix.eureka2.registry.eviction.EvictionStrategyProvider.StrategyType;
import com.netflix.eureka2.transport.EurekaTransports;
import com.netflix.governator.annotations.Configuration;

/**
 * @author David Liu
 */
public class BridgeServerConfig extends WriteServerConfig {

    public static final int DEFAULT_REFRESH_INTERVAL_SEC = 30;

    @Configuration("eureka.services.bridge.refreshRateSec")
    private int refreshRateSec = DEFAULT_REFRESH_INTERVAL_SEC;

    // For property injection
    protected BridgeServerConfig() {
    }

    protected BridgeServerConfig(
            // common server configs
            ResolverType resolverType,
            String[] serverList,
            String appName,
            String vipAddress,
            LocalDataCenterInfo.DataCenterType dataCenterType,
            int dataCenterResolveIntervalSec,
            int shutDownPort,
            int webAdminPort,
            int discoveryPort,
            long heartbeatIntervalMs,
            long connectionAutoTimeoutMs,
            EurekaTransports.Codec codec,
            long evictionTimeoutMs,
            StrategyType evictionStrategyType,
            String evictionStrategyValue,
            int registrationPort,
            int replicationPort,
            long replicationReconnectDelayMillis,
            // bridge server configs
            int refreshRateSec
    ) {
        super(
                resolverType,
                serverList,
                appName,
                vipAddress,
                dataCenterType,
                dataCenterResolveIntervalSec,
                shutDownPort,
                webAdminPort,
                discoveryPort,
                heartbeatIntervalMs,
                connectionAutoTimeoutMs,
                codec,
                evictionTimeoutMs,
                evictionStrategyType,
                evictionStrategyValue,
                registrationPort,
                replicationPort,
                replicationReconnectDelayMillis
        );

        this.refreshRateSec = refreshRateSec;
    }

    public int getRefreshRateSec() {
        return refreshRateSec;
    }

    public static BridgeServerConfigBuilder newBuilder() {
        return new BridgeServerConfigBuilder();
    }


    // builder
    public static class BridgeServerConfigBuilder
            extends WriteServerConfig.AbstractWriteServerConfigBuilder<BridgeServerConfig, BridgeServerConfigBuilder> {

        protected int refreshRateSec = DEFAULT_REFRESH_INTERVAL_SEC;

        protected BridgeServerConfigBuilder() {}

        public BridgeServerConfigBuilder withRefreshRateSec(int refreshRateSec) {
            this.refreshRateSec = refreshRateSec;
            return self();
        }

        public BridgeServerConfig build() {
            return new BridgeServerConfig(
                    resolverType,
                    serverList,
                    appName,
                    vipAddress,
                    dataCenterType,
                    dataCenterResolveIntervalSec,
                    shutDownPort,
                    webAdminPort,
                    discoveryPort,
                    heartbeatIntervalMs,
                    connectionAutoTimeoutMs,
                    codec,
                    evictionTimeoutMs,
                    evictionStrategyType,
                    evictionStrategyValue,
                    registrationPort,
                    replicationPort,
                    replicationReconnectDelayMillis,
                    // bridge server configs
                    refreshRateSec
            );
        }
    }
}