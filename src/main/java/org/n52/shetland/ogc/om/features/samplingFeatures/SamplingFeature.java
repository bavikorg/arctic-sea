/*
 * Copyright 2016 52°North Initiative for Geospatial Open Source
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
package org.n52.shetland.ogc.om.features.samplingFeatures;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.n52.shetland.ogc.OGCConstants;
import org.n52.shetland.ogc.gml.AbstractFeature;
import org.n52.shetland.ogc.gml.CodeWithAuthority;
import org.n52.shetland.util.CollectionHelper;
import org.n52.shetland.ogc.om.NamedValue;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.vividsolutions.jts.geom.Geometry;

/**
 * Abstract super class for all sampling features
 *
 * @since 4.0.0
 *
 */
public class SamplingFeature extends AbstractFeature {

    /**
     * serial number
     */
    private static final long serialVersionUID = 4660755526492323288L;

    /**
     * XML document representing this feature
     */
    private String xmlDescription;

    /**
     * Feature geometry
     */
    private Geometry geometry;

    /**
     * Type of this feature
     */
    private String featureType = OGCConstants.UNKNOWN;

    /**
     * URL to feature representation, e.g. to a WFS
     */
    private String url;

    /**
     * Sampled features, domain feature
     */
    private final List<AbstractFeature> sampledFeatures = new LinkedList<AbstractFeature>();

    /**
     * Parameters
     */
    private final List<NamedValue<?>> parameters = new LinkedList<NamedValue<?>>();

    /**
     * Should this feature be encoded in response
     */
    private boolean encode = true;

    /**
     * Related sampling features
     */
    private Collection<SamplingFeatureComplex> relatedSamplingFeatures;

    /**
     * constructor
     *
     * @param featureIdentifier
     *                          identifier of sampling feature
     */
    public SamplingFeature(final CodeWithAuthority featureIdentifier) {
        super(featureIdentifier);
    }

    /**
     * constructor
     *
     * @param featureIdentifier
     *                          identifier of sampling feature
     * @param gmlId
     *                          GML of this feature
     */
    public SamplingFeature(final CodeWithAuthority featureIdentifier, final String gmlId) {
        super(featureIdentifier, gmlId);
    }

    /**
     * Get XML representation of this feature
     *
     * @return XML representation of this feature
     */
    public String getXmlDescription() {
        return xmlDescription;
    }

    /**
     * Check whether XML representation of this feature is set
     *
     * @return <code>true</code>, if XML representation of this feature is set
     */
    public boolean isSetXmlDescription() {
        return !Strings.isNullOrEmpty(getXmlDescription());
    }

    /**
     * Set XML representation of this feature
     *
     * @param xmlDescription
     *                       XML representation of this feature to set
     */
    public void setXmlDescription(final String xmlDescription) {
        this.xmlDescription = xmlDescription;
    }

    /**
     * Get feature geometry
     *
     * @return Feature geometry
     */
    public Geometry getGeometry() {
        return geometry;
    }

    /**
     * Set feature geometry, checks whether srid is valid
     *
     * @param geometry
     *                 Geometry to set
     *
     * @throws InvalidSridException
     *                              If srid is invalid
     */
    public void setGeometry(Geometry geometry) throws InvalidSridException {
        if (geometry != null && geometry.getSRID() == 0) {
            throw new InvalidSridException(0);
        }
        this.geometry = geometry;
    }

    /**
     * Check whether geometry is set
     *
     * @return <code>true</code>, if geometry is set
     */
    public boolean isSetGeometry() {
        return getGeometry() != null && !getGeometry().isEmpty();
    }

    /**
     * Get feature type
     *
     * @return Type of this feature
     */
    public String getFeatureType() {
        return featureType;
    }

    /**
     * Set feature type
     *
     * @param featureType
     *                    Type of this feature
     */
    public void setFeatureType(final String featureType) {
        this.featureType = featureType;
    }

    /**
     * Check whether feature type is set
     *
     * @return <code>true</code>, if feature type is set
     */
    public boolean isSetFeatureType() {
        return !Strings.isNullOrEmpty(getFeatureType());
    }

    /**
     * Get URL
     *
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set URL
     *
     * @param url
     *            URL to set
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * Check whether URL is set
     *
     * @return <code>true</code>, if URL is set
     */
    public boolean isSetUrl() {
        return !Strings.isNullOrEmpty(getUrl());
    }

    /**
     * Set sampled features
     *
     * @param sampledFeatures
     *                        Sampled fearure list
     */
    public void setSampledFeatures(final List<AbstractFeature> sampledFeatures) {
        this.sampledFeatures.addAll(sampledFeatures);
    }

    /**
     * Get sampled feaures
     *
     * @return Sampled feature list
     */
    public List<AbstractFeature> getSampledFeatures() {
        if (isSetSampledFeatures()) {
            return Collections.unmodifiableList(sampledFeatures);
        }
        return Collections.emptyList();
    }

    /**
     * Check whether sampled features are set
     *
     * @return <code>true</code>, if sampled features are set
     */
    public boolean isSetSampledFeatures() {
        return CollectionHelper.isNotEmpty(sampledFeatures);
    }

    /**
     * Add parameter
     *
     * @param namedValue
     *                   Parameter ro add
     */
    public void addParameter(final NamedValue<?> namedValue) {
        parameters.add(namedValue);
    }

    /**
     * Add parameters
     *
     * @param parameters
     *                   Parameters to add
     */
    public void setParameters(final List<NamedValue<?>> parameters) {
        this.parameters.addAll(parameters);
    }

    /**
     * Get parameters
     *
     * @return Parameter list
     */
    public List<NamedValue<?>> getParameters() {
        return parameters;
    }

    /**
     * Check whether parameters are set
     *
     * @return <code>true</code>, if parameters are set
     */
    public boolean isSetParameter() {
        return CollectionHelper.isNotEmpty(parameters);
    }

    /**
     * Check whether feature should be encoded
     *
     * @return <code>true</code>, if feature should be encoded
     */
    public boolean isEncode() {
        return encode;
    }

    /**
     * Set indicator if feature should be encoded
     *
     * @param encode
     *               Encoding indicator
     */
    public void setEncode(final boolean encode) {
        this.encode = encode;
    }

    /**
     * Add related sampling feature
     *
     * @param relatedSamplingFeature
     *                               Related sampling feature to add
     */
    public void addRelatedSamplingFeature(final SamplingFeatureComplex relatedSamplingFeature) {
        if (!isSetRelatedSamplingFeatures()) {
            relatedSamplingFeatures = Sets.newHashSet();
        }
        if (relatedSamplingFeature != null) {
            relatedSamplingFeatures.add(relatedSamplingFeature);
        }
    }

    /**
     * Add related sampling features
     *
     * @param relatedSamplingFeatures
     *                                Related sampling features to add
     */
    public void addAllRelatedSamplingFeatures(final Collection<SamplingFeatureComplex> relatedSamplingFeatures) {
        if (isSetRelatedSamplingFeatures()) {
            this.relatedSamplingFeatures.addAll(relatedSamplingFeatures);
        } else {
            this.relatedSamplingFeatures = relatedSamplingFeatures;
        }
    }

    /**
     * Set related sampling features
     *
     * @param relatedSamplingFeatures
     *                                Related sampling features to set
     */
    public void setRelatedSamplingFeatures(final Collection<SamplingFeatureComplex> relatedSamplingFeatures) {
        this.relatedSamplingFeatures = relatedSamplingFeatures;
    }

    /**
     * Get related sampling features
     *
     * @return Related sampling features
     */
    public List<SamplingFeatureComplex> getRelatedSamplingFeatures() {
        return Lists.newArrayList(relatedSamplingFeatures);
    }

    /**
     * Check whether related sampling features are set
     *
     * @return <code>true</code>, if related sampling features are set
     */
    public boolean isSetRelatedSamplingFeatures() {
        return CollectionHelper.isNotEmpty(relatedSamplingFeatures);
    }

    @Override
    public String toString() {
        return String
                .format("SamplingFeature [name=%s, description=%s, xmlDescription=%s, geometry=%s, featureType=%s, url=%s, sampledFeatures=%s, parameters=%s, encode=%b, relatedSamplingFeatures=%s]",
                        getName(), getDescription(), getXmlDescription(), getGeometry(), getFeatureType(), getUrl(),
                        getSampledFeatures(), getParameters(), isEncode(), getRelatedSamplingFeatures());
    }

}
