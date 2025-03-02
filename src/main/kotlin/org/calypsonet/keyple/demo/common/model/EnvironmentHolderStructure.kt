/* ******************************************************************************
 * Copyright (c) 2022 Calypso Networks Association https://calypsonet.org/
 *
 * This program and the accompanying materials are made available under the
 * terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT.
 *
 * SPDX-License-Identifier: MIT
 ****************************************************************************** */
package org.calypsonet.keyple.demo.common.model

import java.io.Serializable
import org.calypsonet.keyple.demo.common.model.type.DateCompact
import org.calypsonet.keyple.demo.common.model.type.VersionNumber

data class EnvironmentHolderStructure(
    var envVersionNumber: VersionNumber,
    var envApplicationNumber: Int,
    var envIssuingDate: DateCompact,
    var envEndDate: DateCompact,
    var holderCompany: Int?,
    var holderIdNumber: Int?
) : Serializable
