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
 * - statusCode: 0 (successful), 1 (server is not ready), 2 (card rejected), 3 (please present the
 *   same card).
 * - message: error message
 */
data class SelectAppAndLoadContractOutputDto(var statusCode: Int, var message: String)
