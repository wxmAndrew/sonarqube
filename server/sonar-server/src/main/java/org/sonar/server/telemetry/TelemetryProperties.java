/*
 * SonarQube
 * Copyright (C) 2009-2017 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package org.sonar.server.telemetry;

import org.sonar.api.Properties;
import org.sonar.api.Property;

@Properties({
  @Property(
    key = TelemetryProperties.PROP_ENABLE,
    defaultValue = "true",
    name = "Share SonarQube statistics",
    global = false),
   @Property(
    key = TelemetryProperties.PROP_FREQUENCY,
    // 6 hours in seconds
    defaultValue = "21600",
    name = "Frequency of telemetry checks, in seconds",
    global = false),
  @Property(
    key = TelemetryProperties.PROP_URL,
    defaultValue = "https://telemetry.sonarsource.com/sonarqube",
    name = "URL where telemetry data is sent",
    global = false)
})
public class TelemetryProperties {
  static final String PROP_ENABLE = "sonar.telemetry.enable";
  static final String PROP_FREQUENCY = "sonar.telemetry.frequency";
  static final String PROP_URL = "sonar.telemetry.url";
}
