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

object CardConstant {

  const val AID_1TIC_ICA_1 = "315449432e49434131"
  const val AID_1TIC_ICA_3 = "315449432E49434133"
  const val AID_CALYPSO_LIGHT_CL = "315449432E49434133"
  const val AID_CD_LIGHT_GTML = "315449432E49434131"
  const val AID_NAVIGO_2013 = "A00000040401250901"
  const val AID_NORMALIZED_IDF = "A0000004040125090101"
  const val AID_OTHER = "Other"

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
}
