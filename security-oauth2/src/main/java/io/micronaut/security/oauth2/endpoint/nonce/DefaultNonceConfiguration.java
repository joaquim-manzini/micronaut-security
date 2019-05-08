/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.micronaut.security.oauth2.endpoint.nonce;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.security.oauth2.configuration.OauthConfigurationProperties.OpenIdConfigurationProperties;

import java.util.Optional;

/**
 * Configuration properties implementation of nonce validation configuration.
 *
 * @author James Kleeh
 * @since 1.2.0
 */
@ConfigurationProperties(DefaultNonceConfiguration.PREFIX)
public class DefaultNonceConfiguration implements NonceConfiguration {

    public static final String PREFIX = OpenIdConfigurationProperties.PREFIX + ".nonce";

    private static final boolean DEFAULT_ENABLED = true;

    private String persistence;
    private boolean enabled = DEFAULT_ENABLED;

    @Override
    public Optional<String> getPersistence() {
        return Optional.ofNullable(persistence);
    }

    /**
     * Sets the mechanism to persist the nonce for later retrieval for validation.
     * Only "session" is supported by default.
     *
     * @param persistence The persistence mechanism
     */
    public void setPersistence(String persistence) {
        this.persistence = persistence;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets whether nonce validation is enabled. Default ({@value #DEFAULT_ENABLED}).
     *
     * @param enabled The enabled flag
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
