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

import java.text.SimpleDateFormat
import java.util.*

/**
 * Number of days since January 1st, 2010 (being date 0).<br> Maximum value is 16,383, last complete
 * year being 2053.<br> All dates are in legal local time.
 */
class DateCompact {

  companion object {
    private val REF_TIMESTAMP: Long = SimpleDateFormat("yyyy-MM-dd").parse("2010-01-01").time
    private const val NB_MILLIS_PER_DAY: Long = 1000 * 60 * 60 * 24
  }

  val value: Int
  val date: Date

  constructor(value: Int) {
    this.value = value
    this.date = Date(REF_TIMESTAMP + (value * NB_MILLIS_PER_DAY))
  }

  constructor(date: Date) {
    this.value = ((date.time - REF_TIMESTAMP) / NB_MILLIS_PER_DAY).toInt()
    this.date = date
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false
    other as DateCompact
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
