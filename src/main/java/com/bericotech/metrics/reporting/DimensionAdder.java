/*
 * Copyright Iconology, Inc. 2012. All rights reserved.
 */

package com.bericotech.metrics.reporting;

import java.util.Collection;

import com.amazonaws.services.cloudwatch.model.Dimension;
import com.yammer.metrics.core.Metric;
import com.yammer.metrics.core.MetricName;

/**
 * Adds CloudWatch dimensions to sent metrics.  See {@link CloudWatchReporter.Enabler#withDimensionAdder} to use.
 */
public interface DimensionAdder {
    /**
     * Return dimensions to be added to the given metric. May conditionally return no dimensions if not all metrics
     * should have the same dimensions.
     * @param name the metric's name
     * @param metric the metric
     * @return dimensions to add to the metric's values in CloudWatch
     */
    Collection<Dimension> generate(MetricName name, Metric metric);

    /**
     * Return dimensions to be added to JVM metrics. May conditionally return no dimensions if not all metrics
     * should have the same dimensions.
     * @return dimensions to add to all JVM metrics sent to CloudWatch
     */
    Collection<Dimension> generateJVMDimensions();
}
