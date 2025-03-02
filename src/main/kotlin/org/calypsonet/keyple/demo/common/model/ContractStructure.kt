/* ******************************************************************************
 * Copyright (c) 2022 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.calypsonet.keyple.demo.common.model

import java.io.Serializable
import org.calypsonet.keyple.demo.common.model.type.DateCompact
import org.calypsonet.keyple.demo.common.model.type.PriorityCode
import org.calypsonet.keyple.demo.common.model.type.VersionNumber

data class ContractStructure(
    var contractVersionNumber: VersionNumber,
    var contractTariff: PriorityCode,
    var contractSaleDate: DateCompact,
    var contractValidityEndDate: DateCompact,
    var contractSaleSam: Int?,
    var contractSaleCounter: Int?,
    var contractAuthKvc: Int?,
    var contractAuthenticator: Int?
) : Serializable {
  var counterValue: Int? = null
}
