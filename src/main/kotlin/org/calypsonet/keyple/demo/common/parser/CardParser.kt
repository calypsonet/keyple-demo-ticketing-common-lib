/* **************************************************************************************
 * Copyright (c) 2022 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.calypsonet.keyple.demo.common.parser

import org.calypsonet.keyple.demo.common.model.CardStructure
import org.calypsonet.keyple.demo.common.model.ContractStructure
import org.calypsonet.keyple.demo.common.model.EventStructure
import org.calypsonet.keyple.demo.common.parser.dto.CardDto

class CardParser : Parser<CardStructure?> {

  fun parseCardlet(cardlet: CardDto): CardStructure {

    val environment = EnvironmentHolderStructureParser().parse(cardlet.envData)

    val contractStructures = mutableListOf<ContractStructure>()
    cardlet.contractData.forEach { contractStructures.add(ContractStructureParser().parse(it)) }

    val eventStructures = mutableListOf<EventStructure>()
    cardlet.eventData.forEach { eventStructures.add(EventStructureParser().parse(it)) }

    val counter = cardlet.counterData?.let { CounterStructureParser().parse(it) }

    return CardStructure(environment, contractStructures, eventStructures, counter)
  }

  override fun generate(content: CardStructure?): ByteArray {
    TODO("Not yet implemented")
  }

  override fun parse(content: ByteArray): CardStructure? = null
}
