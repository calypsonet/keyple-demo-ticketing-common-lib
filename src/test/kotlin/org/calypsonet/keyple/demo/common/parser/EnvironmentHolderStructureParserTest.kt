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
import java.time.LocalDate
import java.time.Month
import org.assertj.core.api.Assertions.assertThat
import org.calypsonet.keyple.demo.common.model.EnvironmentHolderStructure
import org.calypsonet.keyple.demo.common.model.type.DateCompact
import org.calypsonet.keyple.demo.common.model.type.VersionNumber
import org.junit.jupiter.api.Test

class EnvironmentHolderStructureParserTest {

  private val envParser = EnvironmentHolderStructureParser()

  @Test
  fun parseEnv1() {
    val content = BytesUtils.fromString(DATA_ENV_1)

    val environment = envParser.parse(content)

    assertThat(environment).isNotNull
    assertThat(environment.envVersionNumber).isEqualTo(VersionNumber.CURRENT_VERSION)
    assertThat(environment.envApplicationNumber).isEqualTo(1)
    assertThat(environment.envIssuingDate.value).isEqualTo(4091)
    assertThat(environment.envEndDate.value).isEqualTo(7314)
    assertThat(environment.envIssuingDate.date).isEqualTo(LocalDate.of(2021, Month.MARCH.value, 15))
    assertThat(environment.envEndDate.date).isEqualTo(LocalDate.of(2030, Month.JANUARY.value, 10))
    assertThat(environment.holderCompany).isEqualTo(7)
    assertThat(environment.holderIdNumber).isEqualTo(8)
  }

  @Test
  fun generateEnv1() {
    val envIssuingDate = LocalDate.of(2021, Month.MARCH.value, 15)
    val envEndDate = LocalDate.of(2030, Month.JANUARY.value, 10)

    val environment =
        EnvironmentHolderStructure(
            envVersionNumber = VersionNumber.CURRENT_VERSION,
            envApplicationNumber = 1,
            envIssuingDate = DateCompact(envIssuingDate),
            envEndDate = DateCompact(envEndDate),
            holderCompany = 7,
            holderIdNumber = 8)

    val content = EnvironmentHolderStructureParser().generate(environment)

    assertThat(BytesUtils.bytesToString(content)).isEqualTo(DATA_ENV_1)
  }

  @Test
  fun parseEnv2() {
    val content = BytesUtils.fromString(DATA_ENV_2)

    val environment = envParser.parse(content)

    assertThat(environment).isNotNull
    assertThat(environment.envVersionNumber).isEqualTo(VersionNumber.CURRENT_VERSION)
    assertThat(environment.envApplicationNumber).isEqualTo(1)
    assertThat(environment.envIssuingDate.value).isEqualTo(4031)
    assertThat(environment.envEndDate.value).isEqualTo(6222)
    assertThat(environment.envIssuingDate.date)
        .isEqualTo(LocalDate.of(2021, Month.JANUARY.value, 14))
    assertThat(environment.envEndDate.date).isEqualTo(LocalDate.of(2027, Month.JANUARY.value, 14))
    assertThat(environment.holderCompany).isZero
    assertThat(environment.holderIdNumber).isZero
  }

  @Test
  fun generateEnv2() {
    val envIssuingDate = LocalDate.of(2021, Month.JANUARY.value, 14)
    val envEndDate = LocalDate.of(2027, Month.JANUARY.value, 14)

    val environment =
        EnvironmentHolderStructure(
            envVersionNumber = VersionNumber.CURRENT_VERSION,
            envApplicationNumber = 1,
            envIssuingDate = DateCompact(envIssuingDate),
            envEndDate = DateCompact(envEndDate),
            holderIdNumber = 0,
            holderCompany = 0)

    assertThat(environment).isNotNull
    assertThat(environment.envVersionNumber).isEqualTo(VersionNumber.CURRENT_VERSION)
    assertThat(environment.envApplicationNumber).isEqualTo(1)
    assertThat(environment.envIssuingDate.value).isEqualTo(4031)
    assertThat(environment.envEndDate.value).isEqualTo(6222)
    assertThat(environment.envIssuingDate.date)
        .isEqualTo(LocalDate.of(2021, Month.JANUARY.value, 14))
    assertThat(environment.envEndDate.date).isEqualTo(LocalDate.of(2027, Month.JANUARY.value, 14))
    assertThat(environment.holderCompany).isZero
    assertThat(environment.holderIdNumber).isZero

    val content = EnvironmentHolderStructureParser().generate(environment)

    assertThat(BytesUtils.bytesToString(content)).isEqualTo(DATA_ENV_2)
  }

  companion object {
    private const val DATA_ENV_1 =
        "01 00 00 00 01 0F FB 1C 92 07 00 00 00 08 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00"

    private const val DATA_ENV_2 =
        "01 00 00 00 01 0F BF 18 4E 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00"
  }
}
