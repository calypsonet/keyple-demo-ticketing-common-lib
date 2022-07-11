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
import org.calypsonet.keyple.demo.common.parser.model.CardEnvironmentHolder
import org.calypsonet.keyple.demo.common.parser.util.DateUtil
import org.junit.jupiter.api.Test

class CardEnvironmentHolderParserTest {

  private val envParser = CardEnvironmentHolderParser()
  private val sdf: SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy")

  @Test
  fun parseEnv1() {
    val content = BytesUtils.fromString(DATA_ENV_1)

    val environment = envParser.parse(content)

    assertThat(environment).isNotNull
    assertThat(environment.envVersionNumber).isEqualTo(9)
    assertThat(environment.envApplicationNumber).isEqualTo(1)
    assertThat(environment.envIssuingDate).isEqualTo(4091)
    assertThat(environment.envEndDate).isEqualTo(7314)
    assertThat(environment.getEnvIssuingDateAsDate()).isEqualTo(sdf.parse("15/03/2021"))
    assertThat(environment.getEnvEndDateAsDate()).isEqualTo(sdf.parse("10/01/2030"))
    assertThat(environment.holderCompany).isEqualTo(7)
    assertThat(environment.holderIdNumber).isEqualTo(8)
  }

  @Test
  fun generateEnv1() {
    val calendar = Calendar.getInstance()

    calendar.set(2021, Calendar.MARCH, 15, 0, 0, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val envIssuingDate = calendar.time

    calendar.set(2030, Calendar.JANUARY, 10, 0, 0, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val envEndDate = calendar.time

    val environment =
        CardEnvironmentHolder(
            envVersionNumber = 9,
            envApplicationNumber = 1,
            envIssuingDate = DateUtil.dateToDateCompact(envIssuingDate),
            envEndDate = DateUtil.dateToDateCompact(envEndDate),
            holderCompany = 7,
            holderIdNumber = 8)

    val content = CardEnvironmentHolderParser().generate(environment)

    assertThat(BytesUtils.bytesToString(content)).isEqualTo(DATA_ENV_1)
  }

  @Test
  fun parseEnv2() {
    val content = BytesUtils.fromString(DATA_ENV_2)

    val environment = envParser.parse(content)

    assertThat(environment).isNotNull
    assertThat(environment.envVersionNumber).isEqualTo(1)
    assertThat(environment.envApplicationNumber).isEqualTo(1)
    assertThat(environment.envIssuingDate).isEqualTo(4031)
    assertThat(environment.envEndDate).isEqualTo(6222)
    assertThat(environment.getEnvIssuingDateAsDate()).isEqualTo(sdf.parse("14/01/2021"))
    assertThat(environment.getEnvEndDateAsDate()).isEqualTo(sdf.parse("14/01/2027"))
    assertThat(environment.holderCompany).isZero
    assertThat(environment.holderIdNumber).isZero
  }

  @Test
  fun generateEnv2() {
    val calendar = Calendar.getInstance()

    calendar.set(2021, Calendar.JANUARY, 14, 0, 0, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val envIssuingDate = calendar.time

    calendar.set(2027, Calendar.JANUARY, 14, 0, 0, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val envEndDate = calendar.time

    val environment =
        CardEnvironmentHolder(
            envVersionNumber = 1,
            envApplicationNumber = 1,
            envIssuingDate = DateUtil.dateToDateCompact(envIssuingDate),
            envEndDate = DateUtil.dateToDateCompact(envEndDate),
            holderIdNumber = 0,
            holderCompany = 0)

    assertThat(environment).isNotNull
    assertThat(environment.envVersionNumber).isEqualTo(1)
    assertThat(environment.envApplicationNumber).isEqualTo(1)
    assertThat(environment.envIssuingDate).isEqualTo(4031)
    assertThat(environment.envEndDate).isEqualTo(6222)
    assertThat(environment.getEnvIssuingDateAsDate()).isEqualTo(sdf.parse("14/01/2021"))
    assertThat(environment.getEnvEndDateAsDate()).isEqualTo(sdf.parse("14/01/2027"))
    assertThat(environment.holderCompany).isZero
    assertThat(environment.holderIdNumber).isZero

    val content = CardEnvironmentHolderParser().generate(environment)

    assertThat(BytesUtils.bytesToString(content)).isEqualTo(DATA_ENV_2)
  }

  companion object {
    private const val DATA_ENV_1 =
        "09 00 00 00 01 0F FB 1C 92 07 00 00 00 08 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00"

    private const val DATA_ENV_2 =
        "01 00 00 00 01 0F BF 18 4E 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00"
  }
}
