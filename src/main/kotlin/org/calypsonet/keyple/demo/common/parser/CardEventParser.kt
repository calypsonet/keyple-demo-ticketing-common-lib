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
import fr.devnied.bitlib.BytesUtils
import java.math.BigInteger
import org.calypsonet.keyple.demo.common.parser.model.CardEvent
import org.calypsonet.keyple.demo.common.parser.model.constant.ContractPriority

class CardEventParser : Parser<CardEvent> {

  override fun parse(content: ByteArray): CardEvent {

    val bitUtils = BitUtils(content)
    bitUtils.currentBitIndex = 0

    /*
     * eventVersionNumber
     */
    val eventVersionNumber = bitUtils.getNextInteger(EVENT_VERSION_NUMBER_SIZE)

    /*
     * eventDateStamp & eventTimeStamp
     */
    val eventDateStamp = bitUtils.getNextInteger(EVENT_DATE_STAMP_SIZE)
    val eventTimeStamp = bitUtils.getNextInteger(EVENT_TIME_STAMP_SIZE)

    /*
     * eventLocation
     */
    val eventLocation = bitUtils.getNextInteger(EVENT_LOCATION_SIZE)
    BytesUtils.bytesToString(bitUtils.data)

    /*
     * eventContractUsed
     */
    val eventContractUsed = bitUtils.getNextInteger(EVENT_CONTRACT_USED_SIZE)
    BytesUtils.bytesToString(bitUtils.data)

    /*
     * contractPriority
     */
    val contractPriority1 =
        ContractPriority.findEnumByKey(bitUtils.getNextInteger(EVENT_CONTRACT_PRIORITY_SIZE))
    val contractPriority2 =
        ContractPriority.findEnumByKey(bitUtils.getNextInteger(EVENT_CONTRACT_PRIORITY_SIZE))
    val contractPriority3 =
        ContractPriority.findEnumByKey(bitUtils.getNextInteger(EVENT_CONTRACT_PRIORITY_SIZE))
    val contractPriority4 =
        ContractPriority.findEnumByKey(bitUtils.getNextInteger(EVENT_CONTRACT_PRIORITY_SIZE))

    return CardEvent(
        eventVersionNumber = eventVersionNumber,
        eventDateStamp = eventDateStamp,
        eventTimeStamp = eventTimeStamp,
        eventLocation = eventLocation,
        eventContractUsed = eventContractUsed,
        contractPriority1 = contractPriority1,
        contractPriority2 = contractPriority2,
        contractPriority3 = contractPriority3,
        contractPriority4 = contractPriority4)
  }

  override fun generate(content: CardEvent): ByteArray {
    val bitUtils = BitUtils(EVENT_SIZE)

    /*
     * eventVersionNumber
     */
    bitUtils.setNextByte(
        BigInteger.valueOf(content.eventVersionNumber.toLong()).toByteArray(),
        EVENT_VERSION_NUMBER_SIZE)

    /*
     * eventDateStamp & eventTimeStamp
     */
    bitUtils.setNextByte(
        BigInteger.valueOf(content.eventDateStamp.toLong()).toByteArray(), EVENT_DATE_STAMP_SIZE)
    bitUtils.setNextByte(
        BigInteger.valueOf(content.eventTimeStamp.toLong()).toByteArray(), EVENT_TIME_STAMP_SIZE)

    /*
     * eventLocation
     */
    bitUtils.setNextByte(
        BigInteger.valueOf(content.eventLocation.toLong()).toByteArray(), EVENT_LOCATION_SIZE)

    /*
     * eventContractUsed
     */
    bitUtils.setNextByte(
        BigInteger.valueOf(content.eventContractUsed.toLong()).toByteArray(),
        EVENT_CONTRACT_USED_SIZE)
    /*
     * contractPriority
     */
    bitUtils.setNextByte(
        BigInteger.valueOf(content.contractPriority1.key.toLong()).toByteArray(),
        EVENT_CONTRACT_PRIORITY_SIZE)
    bitUtils.setNextByte(
        BigInteger.valueOf(content.contractPriority2.key.toLong()).toByteArray(),
        EVENT_CONTRACT_PRIORITY_SIZE)
    bitUtils.setNextByte(
        BigInteger.valueOf(content.contractPriority3.key.toLong()).toByteArray(),
        EVENT_CONTRACT_PRIORITY_SIZE)
    bitUtils.setNextByte(
        BigInteger.valueOf(content.contractPriority4.key.toLong()).toByteArray(),
        EVENT_CONTRACT_PRIORITY_SIZE)

    /*
     * Padding
     */
    bitUtils.setNextByte(BigInteger.valueOf(0).toByteArray(), EVENT_PADDING)

    return bitUtils.data
  }

  companion object {
    const val EVENT_SIZE = 232

    const val EVENT_VERSION_NUMBER_SIZE = 8
    const val EVENT_DATE_STAMP_SIZE = 16
    const val EVENT_TIME_STAMP_SIZE = 16
    const val EVENT_LOCATION_SIZE = 32
    const val EVENT_CONTRACT_USED_SIZE = 8
    const val EVENT_CONTRACT_PRIORITY_SIZE = 8
    const val EVENT_PADDING = 120
  }
}
