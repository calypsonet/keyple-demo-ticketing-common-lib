/* ******************************************************************************
 * Copyright (c) 2022 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.calypsonet.keyple.demo.common.model.type

enum class VersionNumber constructor(val key: Int, val value: String) {
  UNDEFINED(0, "Forbidden (undefined)"),
  CURRENT_VERSION(1, "Current version"),
  RESERVED(255, "Forbidden (reserved)"),
  UNKNOWN(-1, "Unknown");

  companion object {
    fun findEnumByKey(key: Int): VersionNumber {
      for (versionNumber in values()) {
        if (versionNumber.key == key) {
          return versionNumber
        }
      }
      return UNKNOWN
    }
  }
}
