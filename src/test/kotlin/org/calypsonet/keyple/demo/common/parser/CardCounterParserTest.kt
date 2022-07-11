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
import org.assertj.core.api.Assertions.assertThat
import org.calypsonet.keyple.demo.common.parser.model.CardCounter
import org.junit.jupiter.api.Test

class CardCounterParserTest {

  private val cardCounterParser = CardCounterParser()

  @Test
  fun parseContract1() {
    val content = BytesUtils.fromString(DATA_COUNTER_1)
    val counter = cardCounterParser.parse(content)
    assertThat(counter).isNotNull
    assertThat(counter.counterValue).isEqualTo(10)
  }

  @Test
  fun generateContract1() {
    val cardCounter = CardCounter(counterValue = 10)
    val content = CardCounterParser().generate(cardCounter)
    assertThat(BytesUtils.bytesToString(content)).isEqualTo(DATA_COUNTER_1)
  }

  companion object {
    private const val DATA_COUNTER_1 = "00 00 0A"
  }
}
