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
package org.calypsonet.keyple.demo.common.model

import java.io.Serializable
import java.util.Date
import org.calypsonet.keyple.demo.common.model.type.DateCompact
import org.calypsonet.keyple.demo.common.model.type.PriorityCode
import org.calypsonet.keyple.demo.common.model.type.TimeCompact
import org.calypsonet.keyple.demo.common.model.type.VersionNumber

class EventStructure(
    val eventVersionNumber: VersionNumber,
    val eventDateStamp: DateCompact,
    val eventTimeStamp: TimeCompact,
    val eventLocation: Int,
    val eventContractUsed: Int,
    val contractPriority1: PriorityCode,
    val contractPriority2: PriorityCode,
    val contractPriority3: PriorityCode,
    val contractPriority4: PriorityCode
) : Serializable {

  val eventDatetime: Date = Date(eventDateStamp.date.time + (eventTimeStamp.value * 1000 * 60))
}
