/* ******************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.calypsonet.keyple.demo.common.dto

import org.calypsonet.keyple.demo.common.model.type.PriorityCode

data class SelectAppAndLoadContractInputDto(
    var applicationSerialNumber: String,
    var contractTariff: PriorityCode,
    var ticketToLoad: Int,
    var pluginType: String
)
