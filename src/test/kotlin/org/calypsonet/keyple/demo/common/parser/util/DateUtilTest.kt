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
package org.calypsonet.keyple.demo.common.parser.util

import java.util.Calendar
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DateUtilTest {

  @Test
  fun dateToDateCompact() {

    val calendar = Calendar.getInstance()
    calendar.set(2010, 0, 1, 0, 0, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val date1 = calendar.time

    calendar.set(Calendar.DAY_OF_MONTH, 2)
    val date2 = calendar.time

    calendar.set(Calendar.DAY_OF_MONTH, 3)
    val date3 = calendar.time

    calendar.set(Calendar.DAY_OF_MONTH, 4)
    val date4 = calendar.time

    val nb1 = DateUtil.dateToDateCompact(date1)
    val nb2 = DateUtil.dateToDateCompact(date2)
    val nb3 = DateUtil.dateToDateCompact(date3)
    val nb4 = DateUtil.dateToDateCompact(date4)

    assertThat(nb1).isEqualTo(0)
    assertThat(nb2).isEqualTo(1)
    assertThat(nb3).isEqualTo(2)
    assertThat(nb4).isEqualTo(3)
  }

  @Test
  fun dateToTimeCompact() {

    val calendar = Calendar.getInstance()
    calendar.set(2021, Calendar.JANUARY, 14, 0, 0, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val date1 = calendar.time

    calendar.set(Calendar.MINUTE, 1)
    val date2 = calendar.time

    calendar.set(Calendar.MINUTE, 2)
    val date3 = calendar.time

    calendar.set(Calendar.MINUTE, 3)
    val date4 = calendar.time

    calendar.set(Calendar.HOUR_OF_DAY, 1)
    calendar.set(Calendar.MINUTE, 0)
    val date5 = calendar.time

    val nb1 = DateUtil.dateToTimeCompact(date1)
    val nb2 = DateUtil.dateToTimeCompact(date2)
    val nb3 = DateUtil.dateToTimeCompact(date3)
    val nb4 = DateUtil.dateToTimeCompact(date4)
    val nb5 = DateUtil.dateToTimeCompact(date5)

    assertThat(nb1).isEqualTo(0)
    assertThat(nb2).isEqualTo(1)
    assertThat(nb3).isEqualTo(2)
    assertThat(nb4).isEqualTo(3)
    assertThat(nb5).isEqualTo(60)
  }
}
