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
package org.n52.shetland.ogc.sensorML.v20;

import org.n52.shetland.ogc.ows.exception.OwsExceptionReport;
import org.n52.iceland.ogc.swe.SweConstants.SweDataComponentType;
import org.n52.shetland.ogc.swe.SweAbstractDataComponent;
import org.n52.shetland.ogc.swe.SweDataComponentVisitor;
import org.n52.shetland.ogc.swe.SweDataRecord;
import org.n52.shetland.ogc.swe.VoidSweDataComponentVisitor;

/**
 * @author <a href="mailto:e.h.juerrens@52north.org">Eike Hinderk
 *         J&uuml;rrens</a>
 *
 * @since 4.3.0
 */
public class SmlDataInterface extends SweAbstractDataComponent {

    private SmlDataStreamPropertyType smlDataStreamPropertyType;

    private SweDataRecord inputParameters;

    @Override
    public SweDataComponentType getDataComponentType() {
        return null;
    }

    public SmlDataStreamPropertyType getData() {
        return smlDataStreamPropertyType;
    }

    public void setData(SmlDataStreamPropertyType smlDataStreamPropertyType) {
        this.smlDataStreamPropertyType = smlDataStreamPropertyType;
    }

    public Boolean isSetInterfaceParameters() {
        return inputParameters != null;
    }

    public SweDataRecord getInterfaceParameters() {
        return inputParameters;
    }

    public void setInputParameters(SweDataRecord inputParameters) {
        this.inputParameters = inputParameters;
    }

    @Override
    public <T> T accept(SweDataComponentVisitor<T> visitor) throws OwsExceptionReport {
        return visitor.visit(this);
    }

    @Override
    public void accept(VoidSweDataComponentVisitor visitor) throws OwsExceptionReport {
        visitor.visit(this);
    }

    @Override
    public SmlDataInterface clone() throws CloneNotSupportedException {
        SmlDataInterface clone = new SmlDataInterface();
        copyValueTo(clone);
        clone.setData(getData());
        if (isSetInterfaceParameters()) {
            clone.setInputParameters(getInterfaceParameters().clone());
        }
        return clone;
    }

}
