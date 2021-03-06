/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2017 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Affero General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details. You should have received a copy of
 * the GNU Affero General Public License along with this program. If not, see
 * http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org.
 */

package org.openlmis.referencedata.dto;

import static org.mockito.Mockito.mock;

import com.vividsolutions.jts.geom.Point;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

public class FacilityDtoTest {

  @Test
  public void equalsContract() throws Exception {
    EqualsVerifier
        .forClass(FacilityDto.class)
        .withRedefinedSuperclass()
        .withPrefabValues(
            Point.class,
            mock(Point.class),
            mock(Point.class))
        .withPrefabValues(GeographicZoneSimpleDto.class,
            new GeographicZoneSimpleDto("code1", null, null, null, null, null, null),
            new GeographicZoneSimpleDto("code2", null, null, null, null, null, null))
        .suppress(Warning.NONFINAL_FIELDS) // we can't make fields as final in DTO
        .verify();
  }


}
