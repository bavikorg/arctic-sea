/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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
package org.n52.shetland.ogc.om.features;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

import org.n52.shetland.ogc.gml.AbstractFeature;
import org.n52.shetland.ogc.gml.CodeWithAuthority;
import org.n52.shetland.util.CollectionHelper;

import com.google.common.collect.Maps;

/**
 * class represents a GMl feature collection
 *
 * @since 1.0.0
 */
public class FeatureCollection extends AbstractFeature implements Iterable<AbstractFeature> {

    private static String GML_FEATURE_COLLECTION = "gml:FeatureCollection";
    /**
     * members of this feature collection
     */
    private SortedMap<String, AbstractFeature> members = Maps.<
            String,
            AbstractFeature> newTreeMap();

    /**
     * constructor
     */
    public FeatureCollection() {
        super(new CodeWithAuthority(GML_FEATURE_COLLECTION));
    }

    /**
     * constructor
     *
     * @param members
     *            collection with feature members of this collection
     */
    public FeatureCollection(final Map<String, AbstractFeature> members) {
        super(new CodeWithAuthority(GML_FEATURE_COLLECTION));
        this.members.clear();
        this.members.putAll(members);
    }

    /**
     * Get features
     *
     * @return the members
     */
    public Map<String, AbstractFeature> getMembers() {
        return members;
    }

    /**
     * Set features
     *
     * @param members
     *            the members to set
     */
    public void setMembers(Map<String, AbstractFeature> members) {
        this.members.putAll(members);
    }

    public FeatureCollection addMember(AbstractFeature member) {
        if (member.isSetIdentifier()) {
            members.put(member.getIdentifierCodeWithAuthority().getValue(), member);
            return this;
        } else if (member.isSetGmlID()) {
            members.put(member.getGmlId(), member);
            return this;
        }
        members.put(member.toString(), member);
        return this;
    }

    /**
     * @param featureIdentifier
     *            the id
     *
     * @return the removed feature
     *
     * @see Map#remove(Object)
     */
    public AbstractFeature removeMember(String featureIdentifier) {
        return members.remove(featureIdentifier);
    }

    /**
     * Check whether members are set
     *
     * @return <code>true</code>, if members are set
     */
    public boolean isSetMembers() {
        return CollectionHelper.isNotEmpty(getMembers());
    }

    @Override
    public Iterator<AbstractFeature> iterator() {
        if (isSetMembers()) {
            return getMembers().values().iterator();
        } else {
            return Collections.emptyIterator();
        }
    }
}
