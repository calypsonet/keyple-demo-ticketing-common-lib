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
import org.calypsonet.keyple.demo.common.parser.model.CardContract
import org.calypsonet.keyple.demo.common.parser.model.constant.ContractPriority
import org.calypsonet.keyple.demo.common.parser.model.constant.VersionNumber
import org.calypsonet.keyple.demo.common.parser.util.DateUtil
import org.junit.jupiter.api.Test

class CardContractParserTest {

  private val cardContractParser = CardContractParser()
  private val sdf: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")

  @Test
  fun parseContract1() {
    val content = BytesUtils.fromString(DATA_CONTRACT_1)

    val contract = cardContractParser.parse(content)

    assertThat(contract).isNotNull
    assertThat(contract.contractVersionNumber).isEqualTo(VersionNumber.CURRENT_VERSION)
    assertThat(contract.contractTariff).isEqualTo(ContractPriority.SEASON_PASS)
    assertThat(contract.contractSaleDate).isEqualTo(4031)
    assertThat(contract.contractValidityEndDate).isEqualTo(4061)
    assertThat(contract.getContractSaleDateAsDate()).isEqualTo(sdf.parse("14/01/2021"))
    assertThat(contract.getContractValidityEndDateAsDate()).isEqualTo(sdf.parse("13/02/2021"))
    assertThat(contract.contractSaleSam).isZero
    assertThat(contract.contractSaleCounter).isZero
    assertThat(contract.contractAuthKvc).isZero
    assertThat(contract.contractAuthenticator).isZero
  }

  @Test
  fun generateContract1() {
    val calendar = Calendar.getInstance()

    calendar.set(2021, Calendar.JANUARY, 14, 0, 0, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val contractSaleDate = calendar.time

    calendar.set(Calendar.MONTH, Calendar.FEBRUARY)
    calendar.set(Calendar.DAY_OF_MONTH, 13)
    val contractValidityEndDate = calendar.time

    val cardContract =
        CardContract(
            contractVersionNumber = VersionNumber.CURRENT_VERSION,
            contractTariff = ContractPriority.SEASON_PASS,
            contractSaleDate = DateUtil.dateToDateCompact(contractSaleDate),
            contractValidityEndDate = DateUtil.dateToDateCompact(contractValidityEndDate),
            contractSaleSam = 0,
            contractSaleCounter = 0,
            contractAuthKvc = 0,
            contractAuthenticator = 0)

    val content = CardContractParser().generate(cardContract)

    assertThat(BytesUtils.bytesToString(content)).isEqualTo(DATA_CONTRACT_1)
  }

  companion object {
    private const val DATA_CONTRACT_1 =
        "01 01 0F BF 0F DD 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00"
  }
}
