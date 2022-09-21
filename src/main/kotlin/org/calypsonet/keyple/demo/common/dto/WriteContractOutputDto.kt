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

class WriteContractOutputDto {
  /**
   * Status code
   * - 0 successful
   * - 1 server is not ready
   * - 2 card rejected
   * - 3 please present the same card
   */
  var statusCode: Int? = null
}
