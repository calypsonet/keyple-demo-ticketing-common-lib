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
import org.calypsonet.keyple.demo.common.parser.model.constant.ContractPriority
import org.calypsonet.keyple.demo.common.parser.model.constant.VersionNumber
import org.calypsonet.keyple.demo.common.parser.util.DateUtil

data class CardContract(
    val contractVersionNumber: VersionNumber,
    val contractTariff: ContractPriority,
    val contractSaleDate: Int,
    val contractValidityEndDate: Int,
    val contractSaleSam: Int?,
    val contractSaleCounter: Int?,
    val contractAuthKvc: Int?,
    val contractAuthenticator: Int?
) : Serializable {

  fun getContractSaleDateAsDate(): Date {
    return DateUtil.parseDateStamp(contractSaleDate, DateUtil.DATE_01_01_2010)
  }

  fun getContractValidityEndDateAsDate(): Date {
    return DateUtil.parseDateStamp(contractValidityEndDate, DateUtil.DATE_01_01_2010)
  }
}
