/* ******************************************************************************
 * Copyright (c) 2022 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.calypsonet.keyple.demo.common.dto

import org.calypsonet.keyple.demo.common.model.ContractStructure

/**
 * - validContracts: List of contracts present in the card. Each contract is tied to a counter by
 *   its index.
 * - statusCode: 0 (if successful), 1 (server is not ready), 2 (card rejected).
 */
data class AnalyzeContractsOutputDto(
    var validContracts: List<ContractStructure>,
    var statusCode: Int
)
