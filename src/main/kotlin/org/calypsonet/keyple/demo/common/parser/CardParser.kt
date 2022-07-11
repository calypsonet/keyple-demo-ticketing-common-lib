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

import org.calypsonet.keyple.demo.common.parser.dto.CardDto
import org.calypsonet.keyple.demo.common.parser.model.Card
import org.calypsonet.keyple.demo.common.parser.model.CardContract
import org.calypsonet.keyple.demo.common.parser.model.CardEvent

class CardParser : Parser<Card?> {

  fun parseCardlet(cardlet: CardDto): Card {

    /*
     * Parse environment
     */
    val environment = CardEnvironmentHolderParser().parse(cardlet.envData)

    /*
     * Parse cardContracts
     */
    val cardContracts = mutableListOf<CardContract>()
    cardlet.contractData.forEach { cardContracts.add(CardContractParser().parse(it)) }

    /*
     * Parse cardEvents
     */
    val cardEvents = mutableListOf<CardEvent>()
    cardlet.eventData.forEach { cardEvents.add(CardEventParser().parse(it)) }

    /*
     * Parse cardCounter
     */
    val counter = cardlet.counterData?.let { CardCounterParser().parse(it) }

    return Card(environment, cardContracts, cardEvents, counter)
  }

  override fun generate(content: Card?): ByteArray {
    TODO("Not yet implemented")
  }

  override fun parse(content: ByteArray): Card? = null
}
