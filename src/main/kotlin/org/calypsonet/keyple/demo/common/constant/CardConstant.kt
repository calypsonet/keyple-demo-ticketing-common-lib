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

import org.eclipse.keyple.core.util.HexUtil

object CardConstant {
  // AIDs used for selection (could be truncated)
  const val AID_KEYPLE_GENERIC = "A000000291FF9101"
  const val AID_CD_LIGHT_GTML = "315449432E49434131"
  const val AID_CALYPSO_LIGHT = "315449432E49434133"
  const val AID_NAVIGO_2013 = "A00000040401250901"
  const val AID_NORMALIZED_IDF = "A0000004040125090101"

  // expected DF Names for the corresponding AIDs
  val DFNAME_KEYPLE_GENERIC: ByteArray = HexUtil.toByteArray("A000000291FF9101")
  val DFNAME_CD_LIGHT_GTML: ByteArray = HexUtil.toByteArray("315449432E49434131")
  val DFNAME_CALYPSO_LIGHT: ByteArray = HexUtil.toByteArray("315449432E49434133")
  val DFNAME_NORMALIZED_IDF: ByteArray = HexUtil.toByteArray("A0000004040125090101")
  val DFNAME_NAVIGO_2013: ByteArray = HexUtil.toByteArray("A00000040401250901")

  const val SFI_ENVIRONMENT_AND_HOLDER = 0x07.toByte()
  const val SFI_EVENTS_LOG = 0x08.toByte()
  const val SFI_CONTRACTS = 0x09.toByte()
  const val SFI_COUNTER = 0x19.toByte()

  const val DEFAULT_KIF_PERSONALIZATION = 0x21.toByte()
  const val DEFAULT_KIF_LOAD = 0x27.toByte()
  const val DEFAULT_KIF_DEBIT = 0x30.toByte()

  const val ENVIRONMENT_HOLDER_RECORD_SIZE_BYTES = 29
  const val CONTRACT_RECORD_SIZE_BYTES = 29
  const val EVENT_RECORD_SIZE_BYTES = 29

  val ALLOWED_FILE_STRUCTURES: ByteArray =
      byteArrayOf(
          0x01, // Revision 2 minimum
          0x02, // Revision 2 minimum with MF files
          0x03, // Revision 2 extended
          0x04, // Revision 2 extended with MF files
          0x05, // CD Light/GTML Compatibility
          0x06, // CD97 Structure 2 Compatibility
          0x07, // CD97 Structure 3 Compatibility
          0x08, // Extended Ticketing with Loyalty
          0x09, // Extended Ticketing with Loyalty and Miscellaneous
          0x32, // Calypso Light Classic file structure
          0x33) // Calypso Basic file structure
}
