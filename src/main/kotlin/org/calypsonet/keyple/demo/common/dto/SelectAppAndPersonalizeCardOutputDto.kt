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
 * - statusCode: 0 (if successful), 1 (card communication error), >1 (other error).
 * - message: error message
 */
data class SelectAppAndPersonalizeCardOutputDto(var statusCode: Int, var message: String)
