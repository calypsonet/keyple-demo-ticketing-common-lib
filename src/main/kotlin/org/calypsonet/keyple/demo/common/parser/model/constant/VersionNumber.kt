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
package org.calypsonet.keyple.demo.common.parser.model.constant

enum class VersionNumber constructor(val key: Int, val value: String) {
  UNDEFINED(0, "Undefined (Forbidden)"),
  CURRENT_VERSION(1, "Current version"),
  RESERVED(255, "Reserved (Forbidden)"),
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
