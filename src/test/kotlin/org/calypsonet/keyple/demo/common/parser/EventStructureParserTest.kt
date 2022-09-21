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
import org.calypsonet.keyple.demo.common.model.EventStructure
import org.calypsonet.keyple.demo.common.model.type.DateCompact
import org.calypsonet.keyple.demo.common.model.type.PriorityCode
import org.calypsonet.keyple.demo.common.model.type.TimeCompact
import org.calypsonet.keyple.demo.common.model.type.VersionNumber
import org.junit.jupiter.api.Test

class EventStructureParserTest {

  private val eventStructureParser = EventStructureParser()
  private val sdf: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy_HH:mm:ss")

  @Test
  fun parseEvent1() {
    val content = BytesUtils.fromString(DATA_EVENT_1)

    val event = eventStructureParser.parse(content)

    assertThat(event).isNotNull
    assertThat(event.eventVersionNumber).isEqualTo(VersionNumber.CURRENT_VERSION)
    assertThat(event.eventDateStamp.value).isEqualTo(4031)
    assertThat(event.eventTimeStamp.value).isEqualTo(840)
    assertThat(event.eventDateStamp.date).isEqualTo(sdf.parse("14/01/2021_00:00:00"))
    assertThat(event.eventDatetime).isEqualTo(sdf.parse("14/01/2021_14:00:00"))
    assertThat(event.eventLocation).isEqualTo(1)
    assertThat(event.eventContractUsed).isEqualTo(1)
    assertThat(event.contractPriority1).isEqualTo(PriorityCode.SEASON_PASS)
    assertThat(event.contractPriority2).isEqualTo(PriorityCode.FORBIDDEN)
    assertThat(event.contractPriority3).isEqualTo(PriorityCode.FORBIDDEN)
    assertThat(event.contractPriority4).isEqualTo(PriorityCode.FORBIDDEN)
  }

  @Test
  fun generateEvent1() {
    val calendar = Calendar.getInstance()

    calendar.set(2021, Calendar.JANUARY, 14, 14, 0, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val eventDate = calendar.time

    val eventStructure =
        EventStructure(
            eventVersionNumber = VersionNumber.CURRENT_VERSION,
            eventDateStamp = DateCompact(eventDate),
            eventTimeStamp = TimeCompact(eventDate),
            eventLocation = 1,
            eventContractUsed = 1,
            contractPriority1 = PriorityCode.SEASON_PASS,
            contractPriority2 = PriorityCode.FORBIDDEN,
            contractPriority3 = PriorityCode.FORBIDDEN,
            contractPriority4 = PriorityCode.FORBIDDEN)

    val content = EventStructureParser().generate(eventStructure)

    assertThat(BytesUtils.bytesToString(content)).isEqualTo(DATA_EVENT_1)
  }

  companion object {
    private const val DATA_EVENT_1 =
        "01 0F BF 03 48 00 00 00 01 01 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00"
  }
}
