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
package org.calypsonet.keyple.demo.common.parser.model

import java.io.Serializable
import java.util.Calendar
import java.util.Date
import org.calypsonet.keyple.demo.common.parser.model.constant.ContractPriority
import org.calypsonet.keyple.demo.common.parser.util.DateUtil

class CardEvent(
    val eventVersionNumber: Int,
    val eventDateStamp: Int,
    val eventTimeStamp: Int,
    val eventLocation: Int,
    val eventContractUsed: Int,
    val contractPriority1: ContractPriority,
    val contractPriority2: ContractPriority,
    val contractPriority3: ContractPriority,
    val contractPriority4: ContractPriority
) : Serializable {

  fun getEventDateStampAsDate(): Date {
    return DateUtil.parseDateStamp(eventDateStamp, DateUtil.DATE_01_01_2010)
  }

  fun getEventTimeStampAsDate(): Date {
    return DateUtil.parseTimeStamp(eventTimeStamp, DateUtil.DATE_01_01_2010)
  }

  fun getEventDate(): Date {
    val eventDate = DateUtil.parseDateStamp(eventDateStamp, DateUtil.DATE_01_01_2010)
    val calendar: Calendar = Calendar.getInstance()
    calendar.time = eventDate
    calendar.add(Calendar.MINUTE, eventTimeStamp)
    return calendar.time
  }
}
