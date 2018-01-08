/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.shetland.ogc.om.series.wml;

import javax.xml.namespace.QName;

import org.n52.janmayen.http.MediaType;
import org.n52.shetland.ogc.OGCConstants;
import org.n52.shetland.w3c.SchemaLocation;

/**
 * @since 1.0.0
 * @see <a href="http://www.opengeospatial.org/standards/waterml">http://www.opengeospatial.org/standards/waterml</a>
 */
public interface WaterMLConstants {
    String NS_WML_20 = "http://www.opengis.net/waterml/2.0";

    String NS_WML_20_DR = "http://www.opengis.net/waterml-dr/2.0";

    String NS_WML_20_PREFIX = "wml2";

    String NS_WML_20_DR_PREFIX = "wml2dr";

    String NS_WML_20_PROCEDURE_ENCODING = "http://www.opengis.net/waterml/2.0/observationProcess";

    String PROCESS_TYPE_SIMULATION = "http://www.opengis.net/def/waterml/2.0/processType/Simulation";

    String PROCESS_TYPE_MANUAL_METHOD = "http://www.opengis.net/def/waterml/2.0/processType/ManualMethod";

    String PROCESS_TYPE_SENSOR = "http://www.opengis.net/def/waterml/2.0/processType/Sensor";

    String PROCESS_TYPE_ALGORITHM = "http://www.opengis.net/def/waterml/2.0/processType/Algorithm";

    String PROCESS_TYPE_UNKNOWN = OGCConstants.UNKNOWN;

    String OBSERVATION_TYPE_MEASURMENT_TVP =
            "http://www.opengis.net/def/observationType/waterml/2.0/MeasurementTimeseriesTVPObservation";

    String OBSERVATION_TYPE_CATEGORICAL_TVP =
            "http://www.opengis.net/def/observationType/waterml/2.0/CategoricalTVPTimeseriesObservation";

    String OBSERVATION_TYPE_MEASURMENT_TDR =
            "http://www.opengis.net/def/observationType/waterml/2.0/measurementDRTimeseriesObservation";

    String OBSERVATION_TYPE_CATEGORICAL_TDR =
            "http://www.opengis.net/def/observationType/waterml/2.0/categoricalDRTimeseriesObservation";

    String TEXT = "text";

    String XML = "xml";

    String SUBTYPE = "subtype";

    MediaType WML_CONTENT_TYPE = new MediaType(TEXT, XML, SUBTYPE, "waterml/2.0");

    MediaType WML_DR_CONTENT_TYPE = new MediaType(TEXT, XML, SUBTYPE, "waterml-dr/2.0");

    String SCHEMA_LOCATION_URL_WML_20 = "http://schemas.opengis.net/waterml/2.0/waterml2.xsd";

    String SCHEMA_LOCATION_URL_WML_20_DR =
            "http://schemas.opengis.net/waterml/2.0/domain-range-informative/timeseries-domain-range.xsd";

    String SCHEMA_LOCATION_URL_WML_20_TS = "http://schemas.opengis.net/waterml/2.0/timeseries.xsd";

    String SCHEMA_LOCATION_URL_WML_20_MP = "http://schemas.opengis.net/waterml/2.0/monitoringPoint.xsd";

    SchemaLocation WML_20_SCHEMA_LOCATION = new SchemaLocation(NS_WML_20, SCHEMA_LOCATION_URL_WML_20);

    SchemaLocation WML_20_TS_SCHEMA_LOCATION = new SchemaLocation(NS_WML_20, SCHEMA_LOCATION_URL_WML_20_TS);

    SchemaLocation WML_20_DR_SCHEMA_LOCATION = new SchemaLocation(NS_WML_20_DR, SCHEMA_LOCATION_URL_WML_20_DR);

    SchemaLocation WML_20_MP_SCHEMA_LOCATION = new SchemaLocation(NS_WML_20, SCHEMA_LOCATION_URL_WML_20_MP);

    String EN_POINT = "point";

    String EN_MEASUREMENT_TVP = "MeasurementTVP";

    String EN_TIME = "time";

    String EN_VALUE = "value";

    String EN_METADATA = "metadata";

    String EN_TVP_MEASUREMENT_METADATA = "TVPMeasurementMetadata";

    String EN_NIL_REASON = "nilReason";

    String EN_MEASUREMENT_TIMESERIES = "MeasurementTimeseries";

    String EN_TIMESERIES_METADATA = "TimeseriesMetadata";

    String EN_MEASUREMENT_TIMESERIES_METADATA = "MeasurementTimeseriesMetadata";

    String EN_TEMPORAL_EXTENT = "temporalExtent";

    String EN_DEFAULT_POINT_METADATA = "defaultPointMetadata";

    String EN_DEFAULT_TVP_MEASUREMENT_METADATA = "DefaultTVPMeasurementMetadata";

    String EN_INTERPOLATION_TYPE = "interpolationType";

    String EN_CUMULATIVE = "cumulative";

    String EN_UOM = "uom";

    QName QN_POINT = new QName(NS_WML_20, EN_POINT, NS_WML_20_PREFIX);

    QName QN_MEASUREMENT_TVP = new QName(NS_WML_20, EN_MEASUREMENT_TVP, NS_WML_20_PREFIX);

    QName QN_TIME = new QName(NS_WML_20, EN_TIME, NS_WML_20_PREFIX);

    QName QN_VALUE = new QName(NS_WML_20, EN_VALUE, NS_WML_20_PREFIX);

    QName QN_METADATA = new QName(NS_WML_20, EN_METADATA, NS_WML_20_PREFIX);

    QName QN_TVP_MEASUREMENT_METADATA = new QName(NS_WML_20, EN_TVP_MEASUREMENT_METADATA, NS_WML_20_PREFIX);

    QName QN_NIL_REASON = new QName(NS_WML_20, EN_NIL_REASON, NS_WML_20_PREFIX);

    QName QN_MEASUREMENT_TIMESERIES = new QName(NS_WML_20, EN_MEASUREMENT_TIMESERIES, NS_WML_20_PREFIX);

    QName QN_TIMESERIES_METADATA = new QName(NS_WML_20, EN_TIMESERIES_METADATA, NS_WML_20_PREFIX);

    QName QN_MEASUREMENT_TIMESERIES_METADATA =
            new QName(NS_WML_20, EN_MEASUREMENT_TIMESERIES_METADATA, NS_WML_20_PREFIX);

    QName QN_TEMPORAL_EXTENT = new QName(NS_WML_20, EN_TEMPORAL_EXTENT, NS_WML_20_PREFIX);

    QName QN_DEFAULT_POINT_METADATA = new QName(NS_WML_20, EN_DEFAULT_POINT_METADATA, NS_WML_20_PREFIX);

    QName QN_DEFAULT_TVP_MEASUREMENT_METADATA =
            new QName(NS_WML_20, EN_DEFAULT_TVP_MEASUREMENT_METADATA, NS_WML_20_PREFIX);

    QName QN_INTERPOLATION_TYPE = new QName(NS_WML_20, EN_INTERPOLATION_TYPE, NS_WML_20_PREFIX);

    QName QN_CUMULATIVE = new QName(NS_WML_20, EN_CUMULATIVE, NS_WML_20_PREFIX);

    QName UOM = new QName(NS_WML_20, EN_UOM, NS_WML_20_PREFIX);

    /**
     * @see MeasurementTimeseriesMetadata#isCumulative()
     */
    String SERIES_METADATA_CUMULATIVE = NS_WML_20 + "/cumulative";

    String INTERPOLATION_TYPE = "http://www.opengis.net/def/waterml/2.0/interpolationType";

    /**
     * Hold allowed values for element <code>interpolationType</code>.
     *
     * See <code>/req/xsd-measurement-timeseries-tvp/interpolation-type</code>.
     *
     * @author <a href="mailto:e.h.juerrens@52north.org">Eike Hinderk
     *         J&uuml;rrens</a>
     * @since 1.0.0
     */
    enum InterpolationType {

        /**
         * Continuous/Instantaneous
         * http://www.opengis.net/def/waterml/2.0/interpolationType/Continuous
         */
        Continuous,
        /**
         * http://www.opengis.net/def/waterml/2.0/interpolationType/
         * Discontinuous
         */
        Discontinuous,
        /**
         * Instantaneous total
         * http://www.opengis.net/def/waterml/2.0/interpolationType/InstantTotal
         */
        InstantTotal,
        /**
         * Average in preceding interval
         * http://www.opengis.net/def/waterml/2.0/interpolationType/AveragePrec
         */
        AveragePrec,
        /**
         * Maximum in preceding interval
         * http://www.opengis.net/def/waterml/2.0/interpolationType/MaxPrec
         */
        MaxPrec,
        /**
         * Minimum in preceding interval
         * http://www.opengis.net/def/waterml/2.0/interpolationType/MinPrec
         */
        MinPrec,
        /**
         * Preceding total
         * http://www.opengis.net/def/waterml/2.0/interpolationType/TotalPrec
         */
        TotalPrec,
        /**
         * Average in succeeding interval
         * http://www.opengis.net/def/waterml/2.0/interpolationType/AverageSucc
         */
        AverageSucc,
        /**
         * Succeeding total
         * http://www.opengis.net/def/waterml/2.0/interpolationType/TotalSucc
         */
        TotalSucc,
        /**
         * Minimum in succeeding interval
         * http://www.opengis.net/def/waterml/2.0/interpolationType/MinSucc
         */
        MinSucc,
        /**
         * Maximum in succeeding interval
         * http://www.opengis.net/def/waterml/2.0/interpolationType/MaxSucc
         */
        MaxSucc,
        /**
         * Constant in preceding interval
         * http://www.opengis.net/def/waterml/2.0/interpolationType/ConstPrec
         */
        ConstPrec,
        /**
         * Constant in succeeding interval
         * http://www.opengis.net/def/waterml/2.0/interpolationType/ConstSucc
         */
        ConstSucc,
        /**
         * Statistical
         * http://www.opengis.net/def/waterml/2.0/interpolationType/Statistical
         */
        Statistical;

        public String getIdentifier() {
            return INTERPOLATION_TYPE + "/" + this.toString();
        }

        public String getTitle() {
            return this.toString();
        }

        public static InterpolationType from(String v) {
            return valueOf(v.replace(INTERPOLATION_TYPE + "/", ""));
        }
    }
}
