/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.security.reactive;

import org.junit.Test;

import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ReactiveWebApplicationContextRunner;
import org.springframework.security.web.server.WebFilterChainProxy;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link ReactiveSecurityAutoConfiguration}.
 *
 * @author Madhura Bhave
 */
public class ReactiveSecurityAutoConfigurationTests {

	private ReactiveWebApplicationContextRunner contextRunner = new ReactiveWebApplicationContextRunner();

	@Test
	public void importsConfigurationThatEnablesWebFluxSecurity() {
		this.contextRunner
				.withConfiguration(
						AutoConfigurations.of(ReactiveSecurityAutoConfiguration.class,
								ReactiveUserDetailsServiceAutoConfiguration.class))
				.run((context) -> {
					assertThat(context).getBean(WebFilterChainProxy.class).isNotNull();
					assertThat(context).getBean(WebFluxSecurityConfiguration.class)
							.isNotNull();
					assertThat(context).getBean(WebFilterChainProxy.class).isNotNull();
				});
	}

}