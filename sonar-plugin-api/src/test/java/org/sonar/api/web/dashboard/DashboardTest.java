/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2011 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.api.web.dashboard;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class DashboardTest {

  @Test
  public void shouldCreateDashboardAndWidget() throws Exception {
    Dashboard dashboard = Dashboard.createDashboard("fake-dashboard", "Fake", DashboardLayout.TWO_COLUMNS_30_70);
    assertThat(dashboard.getId(), is("fake-dashboard"));
    assertThat(dashboard.getName(), is("Fake"));
    assertThat(dashboard.getLayout(), is(DashboardLayout.TWO_COLUMNS_30_70));
    assertThat(dashboard.getDescription(), is(""));

    Widget widget = dashboard.addWidget("fake-widget", 12, 13);
    assertThat(widget.getId(), is("fake-widget"));
    assertThat(widget.getColumnIndex(), is(12));
    assertThat(widget.getRowIndex(), is(13));

    widget.addProperty("fake-property", "fake_metric");
    Set<Entry<String, String>> properties = widget.getProperties().entrySet();
    assertThat(properties.size(), is(1));
    Entry<String, String> property = properties.iterator().next();
    assertThat(property.getKey(), is("fake-property"));
    assertThat(property.getValue(), is("fake_metric"));
  }

  @Test
  public void shouldAddWidget() throws Exception {
    Dashboard dashboard = Dashboard.createDashboard("fake-dashboard", "Fake", DashboardLayout.TWO_COLUMNS_30_70);
    dashboard.addWidget("fake-widget", 12, 13);

    Widget widget = dashboard.getWidgets().iterator().next();

    assertThat(widget.getId(), is("fake-widget"));
    assertThat(widget.getColumnIndex(), is(12));
    assertThat(widget.getRowIndex(), is(13));
  }

}
