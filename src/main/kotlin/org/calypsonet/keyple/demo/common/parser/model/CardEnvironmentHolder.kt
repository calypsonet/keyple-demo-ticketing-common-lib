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
import java.util.Date
import org.calypsonet.keyple.demo.common.parser.util.DateUtil

data class CardEnvironmentHolder(
    val envVersionNumber: Int,
    val envApplicationNumber: Int,
    val envIssuingDate: Int,
    val envEndDate: Int,
    val holderCompany: Int?,
    val holderIdNumber: Int?
) : Serializable {

  fun getEnvIssuingDateAsDate(): Date {
    return DateUtil.parseDateStamp(envIssuingDate, DateUtil.DATE_01_01_2010)
  }

  fun getEnvEndDateAsDate(): Date {
    return DateUtil.parseDateStamp(envEndDate, DateUtil.DATE_01_01_2010)
  }
}
