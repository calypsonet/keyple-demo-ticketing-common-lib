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
import org.calypsonet.keyple.demo.common.parser.model.CardEnvironmentHolder

class CardEnvironmentHolderParser : Parser<CardEnvironmentHolder> {

  override fun parse(content: ByteArray): CardEnvironmentHolder {

    val bitUtils = BitUtils(content)
    bitUtils.currentBitIndex = 0

    /*
     * envVersionNumber
     */
    val envVersionNumber = bitUtils.getNextInteger(ENV_EVN_SIZE)

    /*
     * envApplicationNumber
     */
    val envApplicationNumber = bitUtils.getNextInteger(ENV_AVN_SIZE)

    /*
     * envIssuingDate
     */
    val envIssuingDate = bitUtils.getNextInteger(ENV_ISSUING_DATE_SIZE)

    /*
     * envEndDate
     */
    val envEndDate = bitUtils.getNextInteger(ENV_END_DATE_SIZE)

    /*
     * holderCompany
     */
    val holderCompany = bitUtils.getNextInteger(ENV_HOLDER_COMPANY_SIZE)

    /*
     * holderIdNumber
     */
    val holderIdNumber = bitUtils.getNextInteger(ENV_HOLDER_ID_NUMBER_SIZE)

    return CardEnvironmentHolder(
        envVersionNumber = envVersionNumber,
        envApplicationNumber = envApplicationNumber,
        envEndDate = envEndDate,
        envIssuingDate = envIssuingDate,
        holderCompany = holderCompany,
        holderIdNumber = holderIdNumber)
  }

  override fun generate(content: CardEnvironmentHolder): ByteArray {

    val bitUtils = BitUtils(ENV_SIZE)
    /*
     * envVersionNumber
     */
    bitUtils.setNextByte(
        BigInteger.valueOf(content.envVersionNumber.toLong()).toByteArray(), ENV_EVN_SIZE)

    /*
     * envApplicationNumber
     */
    bitUtils.setNextByte(
        BigInteger.valueOf(content.envApplicationNumber.toLong()).toByteArray(), ENV_AVN_SIZE)

    /*
     * envIssuingDate
     */
    bitUtils.setNextByte(
        BigInteger.valueOf(content.envIssuingDate.toLong()).toByteArray(), ENV_ISSUING_DATE_SIZE)

    /*
     * envEndDate
     */
    bitUtils.setNextByte(
        BigInteger.valueOf(content.envEndDate.toLong()).toByteArray(), ENV_END_DATE_SIZE)

    /*
     * holderCompany
     */
    val holderCompany = content.holderCompany ?: 0
    bitUtils.setNextByte(
        BigInteger.valueOf(holderCompany.toLong()).toByteArray(), ENV_HOLDER_COMPANY_SIZE)

    /*
     * holderIdNumber
     */
    val holderIdNumber = content.holderIdNumber ?: 0
    bitUtils.setNextByte(
        BigInteger.valueOf(holderIdNumber.toLong()).toByteArray(), ENV_HOLDER_ID_NUMBER_SIZE)

    /*
     * padding
     */
    bitUtils.setNextByte(BigInteger.valueOf(0).toByteArray(), ENV_PADDING)

    return bitUtils.data
  }

  companion object {
    const val ENV_SIZE = 232

    const val ENV_EVN_SIZE = 8
    const val ENV_AVN_SIZE = 32
    const val ENV_ISSUING_DATE_SIZE = 16
    const val ENV_END_DATE_SIZE = 16
    const val ENV_HOLDER_COMPANY_SIZE = 8
    const val ENV_HOLDER_ID_NUMBER_SIZE = 32
    const val ENV_PADDING = 120
  }
}
