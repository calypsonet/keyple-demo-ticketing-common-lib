/* ******************************************************************************
 * Copyright (c) 2022 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.calypsonet.keyple.demo.common.constant

enum class RemoteServiceId {

  // Suitable for C# Keyple-less clients
  SELECT_APP_AND_READ_CONTRACTS,
  SELECT_APP_AND_INCREASE_CONTRACT_COUNTER,

  // Suitable for Android Keyple clients
  READ_CARD_AND_ANALYZE_CONTRACTS,
  READ_CARD_AND_WRITE_CONTRACT,
  PERSONALIZE_CARD,

  // Suitable for Kotlin Multiplaform Keyple-less client
  SELECT_APP_AND_ANALYZE_CONTRACTS,
  SELECT_APP_AND_LOAD_CONTRACT,
  SELECT_APP_AND_PERSONALIZE_CARD
}
