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

/**
 * - validContracts: List of contracts present in the card. Each contract is tied to a counter by
 *   its index.
 * - statusCode: 0 (if successful), 1 (server is not ready), 2 (card rejected).
 * - message: Status message.
 */
data class SelectAppAndAnalyzeContractsOutputDto(
    var applicationSerialNumber: String,
    var validContracts: List<ContractInfo>,
    var statusCode: Int,
    var message: String
) {
  /**
   * - title: Contract name.
   * - description: Contract details.
   * - isValid: Indicates if the contract is currently usable.
   */
  data class ContractInfo(var title: String, var description: String, var isValid: Boolean)
}
