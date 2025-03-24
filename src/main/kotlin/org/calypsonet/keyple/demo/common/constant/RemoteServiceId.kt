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
package org.calypsonet.keyple.demo.common.constant

enum class RemoteServiceId {

  // Suitable for C# non-Keyple clients
  SELECT_APP_AND_READ_CONTRACTS,
  SELECT_APP_AND_INCREASE_CONTRACT_COUNTER,

  // Suitable for Android Keyple clients
  READ_CARD_AND_ANALYZE_CONTRACTS,
  READ_CARD_AND_WRITE_CONTRACT,
  PERSONALIZE_CARD,

  // Suitable for Kotlin Multiplatform non-Keyple client
  SELECT_APP_AND_ANALYZE_CONTRACTS,
  SELECT_APP_AND_LOAD_CONTRACT,
  SELECT_APP_AND_PERSONALIZE_CARD
}
