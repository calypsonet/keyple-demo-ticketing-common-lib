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

import fr.devnied.bitlib.BitUtils
import java.math.BigInteger
import org.calypsonet.keyple.demo.common.model.CounterStructure

class CounterStructureParser : Parser<CounterStructure> {

  override fun parse(content: ByteArray): CounterStructure {
    val bitUtils = BitUtils(content)
    val counterValue = bitUtils.getNextInteger(COUNTER_SIZE)
    return CounterStructure(counterValue = counterValue)
  }

  override fun generate(content: CounterStructure): ByteArray {
    val bitUtils = BitUtils(COUNTER_SIZE)
    bitUtils.setNextByte(
        BigInteger.valueOf(content.counterValue.toLong()).toByteArray(), COUNTER_SIZE)
    return bitUtils.data
  }

  companion object {
    const val COUNTER_SIZE = 24
  }
}
