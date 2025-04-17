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
 * - statusCode: 0 (successful), 1 (card communication error), 2 (server is not ready), 3 (card
 *   rejected), 4 (please present the same card).
 * - message: error message
 */
data class SelectAppAndLoadContractOutputDto(var statusCode: Int, var message: String)
