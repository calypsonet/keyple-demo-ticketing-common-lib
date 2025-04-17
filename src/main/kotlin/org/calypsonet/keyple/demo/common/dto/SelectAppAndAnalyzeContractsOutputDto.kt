/* **************************************************************************************
 * Copyright (c) 2024 Calypso Networks Association https://calypsonet.org/
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

/**
 * - validContracts: List of contracts present in the card. Each contract is tied to a counter by
 *   its index.
 * - statusCode: 0 (if successful), 1 (card communication error), 2 (server is not ready), 3 (card
 *   rejected).
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
