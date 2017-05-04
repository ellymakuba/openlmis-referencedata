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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.openlmis.referencedata.domain.TradeItem;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TradeItemDto extends BaseDto implements TradeItem.Importer, TradeItem.Exporter {

  private Set<OrderableDto> orderables;

  private String manufacturerOfTradeItem;

  private List<TradeItemClassificationDto> classifications;

  /**
   * Create new list of TradeItemDto based on given list of {@link TradeItem}
   *
   * @param tradeItems list of {@link TradeItem}
   * @return new list of TradeItemDto.
   */
  public static Set<TradeItemDto> newInstance(Iterable<TradeItem> tradeItems) {
    Set<TradeItemDto> tradeItemDtos = new HashSet<>();
    tradeItems.forEach(item -> tradeItemDtos.add(newInstance(item)));
    return tradeItemDtos;
  }

  /**
   * Creates new instance based on given {@link TradeItem}.
   *
   * @param po instance of TradeItem.
   * @return new instance of TradeItemDto.
   */
  public static TradeItemDto newInstance(TradeItem po) {
    if (po == null) {
      return null;
    }
    TradeItemDto tradeItemDto = new TradeItemDto();
    po.export(tradeItemDto);

    return tradeItemDto;
  }

}