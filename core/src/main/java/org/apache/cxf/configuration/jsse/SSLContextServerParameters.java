/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cxf.configuration.jsse;

import java.util.Arrays;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/**
 * Allows to supply to the HTTP Server the complete SSLContext already preconfigured.
 */
public class SSLContextServerParameters extends TLSServerParameters {
    private final SSLContext sslContext;

    public SSLContextServerParameters(SSLContext sslContext) {
        this.sslContext = sslContext;
        setSecureSocketProtocol(sslContext.getProtocol());
        setJsseProvider(sslContext.getProvider().getName());
        setCipherSuites(Arrays.asList(sslContext.getServerSocketFactory().getSupportedCipherSuites()));
    }

    public SSLContext getSslContext() {
        return sslContext;
    }
    
    @Override
    public TrustManager[] getTrustManagers() {
        throw new UnsupportedOperationException("The operation is not supported by SSLContextServerParameters");
    }
    
    @Override
    public KeyManager[] getKeyManagers() {
        throw new UnsupportedOperationException("The operation is not supported by SSLContextServerParameters");
    }
}
