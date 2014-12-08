/*
 * Copyright 2014 Netflix, Inc.
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

package com.netflix.eureka2.server.channel;

import com.netflix.eureka2.registry.InstanceInfo;
import com.netflix.eureka2.server.metric.EurekaServerMetricFactory;
import com.netflix.eureka2.server.registry.EurekaServerRegistry;
import com.netflix.eureka2.service.InterestChannel;
import com.netflix.eureka2.transport.MessageConnection;

/**
 * @author Tomasz Bak
 */
public class InterestChannelFactoryImpl implements InterestChannelFactory {

    protected final EurekaServerRegistry<InstanceInfo> registry;
    protected final MessageConnection connection;

    private final EurekaServerMetricFactory metricFactory;

    public InterestChannelFactoryImpl(EurekaServerRegistry<InstanceInfo> registry,
                                      MessageConnection connection,
                                      EurekaServerMetricFactory metricFactory) {
        this.registry = registry;
        this.connection = connection;
        this.metricFactory = metricFactory;
    }

    @Override
    public InterestChannel newInterestChannel() {
        return new InterestChannelImpl(registry, connection, metricFactory.getInterestChannelMetrics());
    }
}
