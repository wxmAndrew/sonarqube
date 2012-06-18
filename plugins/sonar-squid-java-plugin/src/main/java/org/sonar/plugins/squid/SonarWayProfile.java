/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2012 SonarSource
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
package org.sonar.plugins.squid;

import org.sonar.api.resources.Java;

import com.google.common.collect.ImmutableList;
import org.sonar.api.profiles.AnnotationProfileParser;
import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.utils.ValidationMessages;
import org.sonar.java.ast.check.CommentedOutCodeLineCheck;

import java.util.Collection;

public class SonarWayProfile extends ProfileDefinition {
  private final AnnotationProfileParser annotationProfileParser;

  public SonarWayProfile(AnnotationProfileParser annotationProfileParser) {
    this.annotationProfileParser = annotationProfileParser;
  }

  @Override
  public RulesProfile createProfile(ValidationMessages messages) {
    Collection<Class> rules = ImmutableList.<Class> of(CommentedOutCodeLineCheck.class);

    return annotationProfileParser.parse(SquidConstants.REPOSITORY_KEY, RulesProfile.SONAR_WAY_NAME, Java.KEY, rules, messages);
  }
}