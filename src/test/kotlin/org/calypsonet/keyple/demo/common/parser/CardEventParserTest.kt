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

import fr.devnied.bitlib.BytesUtils
import java.text.SimpleDateFormat
import java.util.Calendar
import org.assertj.core.api.Assertions.assertThat
import org.calypsonet.keyple.demo.common.parser.model.CardEvent
import org.calypsonet.keyple.demo.common.parser.model.constant.ContractPriority
import org.calypsonet.keyple.demo.common.parser.util.DateUtil
import org.junit.jupiter.api.Test

class CardEventParserTest {

  private val cardEventParser = CardEventParser()
  private val sdf: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy_HH:mm:ss")

  @Test
  fun parseEvent1() {
    val content = BytesUtils.fromString(DATA_EVENT_1)

    val event = cardEventParser.parse(content)

    assertThat(event).isNotNull
    assertThat(event.eventVersionNumber).isEqualTo(1)
    assertThat(event.eventDateStamp).isEqualTo(4031)
    assertThat(event.eventTimeStamp).isEqualTo(840)
    assertThat(event.getEventDateStampAsDate()).isEqualTo(sdf.parse("14/01/2021_00:00:00"))
    assertThat(event.getEventTimeStampAsDate()).isEqualTo(sdf.parse("01/01/2010_14:00:00"))
    assertThat(event.getEventDate()).isEqualTo(sdf.parse("14/01/2021_14:00:00"))
    assertThat(event.eventLocation).isEqualTo(1)
    assertThat(event.eventContractUsed).isEqualTo(1)
    assertThat(event.contractPriority1).isEqualTo(ContractPriority.SEASON_PASS)
    assertThat(event.contractPriority2).isEqualTo(ContractPriority.FORBIDDEN)
    assertThat(event.contractPriority3).isEqualTo(ContractPriority.FORBIDDEN)
    assertThat(event.contractPriority4).isEqualTo(ContractPriority.FORBIDDEN)
  }

  @Test
  fun generateEvent1() {
    val calendar = Calendar.getInstance()

    calendar.set(2021, Calendar.JANUARY, 14, 14, 0, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val eventDate = calendar.time

    val cardEvent =
        CardEvent(
            eventVersionNumber = 1,
            eventDateStamp = DateUtil.dateToDateCompact(eventDate),
            eventTimeStamp = DateUtil.dateToTimeCompact(eventDate),
            eventLocation = 1,
            eventContractUsed = 1,
            contractPriority1 = ContractPriority.SEASON_PASS,
            contractPriority2 = ContractPriority.FORBIDDEN,
            contractPriority3 = ContractPriority.FORBIDDEN,
            contractPriority4 = ContractPriority.FORBIDDEN)

    val content = CardEventParser().generate(cardEvent)

    assertThat(BytesUtils.bytesToString(content)).isEqualTo(DATA_EVENT_1)
  }

  companion object {
    private const val DATA_EVENT_1 =
        "01 0F BF 03 48 00 00 00 01 01 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00"
  }
}
