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
