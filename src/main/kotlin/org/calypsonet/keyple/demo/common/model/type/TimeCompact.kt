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
package org.calypsonet.keyple.demo.common.model.type

import java.util.*

/** Time in minutes, value = hour * 60 + minute (0 to 1,439). */
class TimeCompact {

  companion object {
    private const val NB_MILLIS_PER_MINUTE: Long = 1000 * 60
  }

  val value: Int

  constructor(value: Int) {
    this.value = value
  }

  constructor(date: Date) {
    val calendar = Calendar.getInstance()
    calendar.time = date
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val startDate = calendar.time
    this.value = ((date.time - startDate.time) / (NB_MILLIS_PER_MINUTE)).toInt()
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false
    other as TimeCompact
    if (value != other.value) return false
    return true
  }

  override fun hashCode(): Int {
    return value
  }

  override fun toString(): String {
    return "$value"
  }
}
