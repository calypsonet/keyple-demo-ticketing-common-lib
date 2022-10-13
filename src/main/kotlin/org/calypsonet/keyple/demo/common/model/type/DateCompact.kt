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

import java.time.Duration
import java.time.LocalDate

/**
 * Number of days since January 1st, 2010 (being date 0).<br> Maximum value is 16,383, last complete
 * year being 2053.<br> All dates are in legal local time.
 */
class DateCompact {

  companion object {
    private val REF_DATE = LocalDate.of(2010, 1, 1)
  }

  val value: Long
  val date: LocalDate

  constructor(value: Long) {
    this.value = value
    this.date = REF_DATE.plusDays(value)
  }

  constructor(date: LocalDate) {
    this.value = Duration.between(REF_DATE.atStartOfDay(), date.atStartOfDay()).toDays()
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
    return value.hashCode()
  }

  override fun toString(): String {
    return "$value"
  }
}
