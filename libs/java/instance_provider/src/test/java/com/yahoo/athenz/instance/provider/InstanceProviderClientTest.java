/**
 * Copyright 2017 Yahoo Holdings, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.athenz.instance.provider;

import static org.testng.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.mockito.Mockito;
import org.testng.annotations.Test;

public class InstanceProviderClientTest {

    @Test
    public void testInstanceProviderClientInstanceConfirmation() {
        String url = "http://localhost:10099/instance";
        ProviderHostnameVerifier hostnameVerifier = new ProviderHostnameVerifier("athenz.provider");
        InstanceProviderClient provClient = new InstanceProviderClient(url, hostnameVerifier, 10000, 10000);

        WebTarget base = Mockito.mock(WebTarget.class);
        provClient.base = base;
        
        WebTarget target = Mockito.mock(WebTarget.class);
        Mockito.when(base.path("/instance")).thenReturn(target);

        Invocation.Builder builder = Mockito.mock(Invocation.Builder.class);
        Mockito.when(target.request("application/json")).thenReturn(builder);
        Mockito.when(builder.header("Athenz-Principal-Token", "v=S1;d=athenz;n=service;s=signature")).thenReturn(builder);

        InstanceConfirmation confirmation = new InstanceConfirmation()
                .setAttestationData("data").setDomain("athenz")
                .setProvider("provider").setService("service");
        Entity<?> entity = Entity.entity(confirmation, "application/json");
        Response response = Mockito.mock(Response.class);
        Mockito.when(builder.post(entity)).thenReturn(response);
        Mockito.when(response.getStatus()).thenReturn(200);
        Mockito.when(response.readEntity(InstanceConfirmation.class)).thenReturn(confirmation);
        
        InstanceConfirmation result = provClient.postInstanceConfirmation(confirmation);
        assertEquals(result.getAttestationData(), "data");
        assertEquals(result.getDomain(), "athenz");
        assertEquals(result.getProvider(), "provider");
        assertEquals(result.getService(), "service");
        
        provClient.close();
    }
    
    @Test
    public void testInstanceProviderClientInstanceConfirmationCookieHeader() {
        String url = "http://localhost:10099/instance";
        ProviderHostnameVerifier hostnameVerifier = new ProviderHostnameVerifier("athenz.provider");
        InstanceProviderClient provClient = new InstanceProviderClient(url, hostnameVerifier, 10000, 10000);

        WebTarget base = Mockito.mock(WebTarget.class);
        provClient.base = base;
        
        WebTarget target = Mockito.mock(WebTarget.class);
        Mockito.when(base.path("/instance")).thenReturn(target);

        Invocation.Builder builder = Mockito.mock(Invocation.Builder.class);
        Mockito.when(target.request("application/json")).thenReturn(builder);
        Mockito.when(builder.cookie("ntoken", "v=S1;d=athenz;n=service;s=signature")).thenReturn(builder);

        InstanceConfirmation confirmation = new InstanceConfirmation()
                .setAttestationData("data").setDomain("athenz")
                .setProvider("provider").setService("service");
        Entity<?> entity = Entity.entity(confirmation, "application/json");
        Response response = Mockito.mock(Response.class);
        Mockito.when(builder.post(entity)).thenReturn(response);
        Mockito.when(response.getStatus()).thenReturn(200);
        Mockito.when(response.readEntity(InstanceConfirmation.class)).thenReturn(confirmation);
        
        InstanceConfirmation result = provClient.postInstanceConfirmation(confirmation);
        assertEquals(result.getAttestationData(), "data");
        assertEquals(result.getDomain(), "athenz");
        assertEquals(result.getProvider(), "provider");
        assertEquals(result.getService(), "service");
        
        provClient.close();
    }
    
    @Test
    public void testInstanceProviderClientRefreshConfirmation() {
        String url = "http://localhost:10099/instance";
        ProviderHostnameVerifier hostnameVerifier = new ProviderHostnameVerifier("athenz.provider");
        InstanceProviderClient provClient = new InstanceProviderClient(url, hostnameVerifier, 10000, 10000);

        WebTarget base = Mockito.mock(WebTarget.class);
        provClient.base = base;
        
        WebTarget target = Mockito.mock(WebTarget.class);
        Mockito.when(base.path("/refresh")).thenReturn(target);

        Invocation.Builder builder = Mockito.mock(Invocation.Builder.class);
        Mockito.when(target.request("application/json")).thenReturn(builder);
        Mockito.when(builder.header("Athenz-Principal-Token", "v=S1;d=athenz;n=service;s=signature")).thenReturn(builder);

        InstanceConfirmation confirmation = new InstanceConfirmation()
                .setAttestationData("data").setDomain("athenz")
                .setProvider("provider").setService("service");
        Entity<?> entity = Entity.entity(confirmation, "application/json");
        Response response = Mockito.mock(Response.class);
        Mockito.when(builder.post(entity)).thenReturn(response);
        Mockito.when(response.getStatus()).thenReturn(200);
        Mockito.when(response.readEntity(InstanceConfirmation.class)).thenReturn(confirmation);
        
        InstanceConfirmation result = provClient.postRefreshConfirmation(confirmation);
        assertEquals(result.getAttestationData(), "data");
        assertEquals(result.getDomain(), "athenz");
        assertEquals(result.getProvider(), "provider");
        assertEquals(result.getService(), "service");
        
        provClient.close();
    }
    
    @Test
    public void testInstanceProviderClientRefreshConfirmationCookieHeader() {
        String url = "http://localhost:10099/instance";
        ProviderHostnameVerifier hostnameVerifier = new ProviderHostnameVerifier("athenz.provider");
        InstanceProviderClient provClient = new InstanceProviderClient(url, hostnameVerifier, 10000, 10000);
        
        WebTarget base = Mockito.mock(WebTarget.class);
        provClient.base = base;
        
        WebTarget target = Mockito.mock(WebTarget.class);
        Mockito.when(base.path("/refresh")).thenReturn(target);

        Invocation.Builder builder = Mockito.mock(Invocation.Builder.class);
        Mockito.when(target.request("application/json")).thenReturn(builder);
        Mockito.when(builder.cookie("NToken", "v=S1;d=athenz;n=service;s=signature")).thenReturn(builder);

        InstanceConfirmation confirmation = new InstanceConfirmation()
                .setAttestationData("data").setDomain("athenz")
                .setProvider("provider").setService("service");
        Entity<?> entity = Entity.entity(confirmation, "application/json");
        Response response = Mockito.mock(Response.class);
        Mockito.when(builder.post(entity)).thenReturn(response);
        Mockito.when(response.getStatus()).thenReturn(200);
        Mockito.when(response.readEntity(InstanceConfirmation.class)).thenReturn(confirmation);
        
        InstanceConfirmation result = provClient.postRefreshConfirmation(confirmation);
        assertEquals(result.getAttestationData(), "data");
        assertEquals(result.getDomain(), "athenz");
        assertEquals(result.getProvider(), "provider");
        assertEquals(result.getService(), "service");
        
        provClient.close();
    }
    
    @Test
    public void testInstanceProviderClientHostnameVerifier() {
        String url = "http://localhost:10099/instance";
        ProviderHostnameVerifier verifier = new ProviderHostnameVerifier("athenz.production");
        InstanceProviderClient provClient = new InstanceProviderClient(url, verifier, 10000, 10000);
        
        WebTarget base = Mockito.mock(WebTarget.class);
        provClient.base = base;
        
        WebTarget target = Mockito.mock(WebTarget.class);
        Mockito.when(base.path("/instance")).thenReturn(target);

        Invocation.Builder builder = Mockito.mock(Invocation.Builder.class);
        Mockito.when(target.request("application/json")).thenReturn(builder);
        Mockito.when(builder.header("Athenz-Principal-Token", "v=S1;d=athenz;n=service;s=signature")).thenReturn(builder);

        InstanceConfirmation confirmation = new InstanceConfirmation()
                .setAttestationData("data").setDomain("athenz")
                .setProvider("provider").setService("service");
        Entity<?> entity = Entity.entity(confirmation, "application/json");
        Response response = Mockito.mock(Response.class);
        Mockito.when(builder.post(entity)).thenReturn(response);
        Mockito.when(response.getStatus()).thenReturn(200);
        Mockito.when(response.readEntity(InstanceConfirmation.class)).thenReturn(confirmation);
        
        InstanceConfirmation result = provClient.postInstanceConfirmation(confirmation);
        assertEquals(result.getAttestationData(), "data");
        assertEquals(result.getDomain(), "athenz");
        assertEquals(result.getProvider(), "provider");
        assertEquals(result.getService(), "service");
        
        provClient.close();
    }
    
    @Test
    public void testInstanceProviderClientFailure() {
        String url = "http://localhost:10099/instance";
        ProviderHostnameVerifier hostnameVerifier = new ProviderHostnameVerifier("athenz.provider");
        InstanceProviderClient provClient = new InstanceProviderClient(url, hostnameVerifier, 10000, 10000);
        
        WebTarget base = Mockito.mock(WebTarget.class);
        provClient.base = base;
        
        WebTarget target = Mockito.mock(WebTarget.class);
        Mockito.when(base.path("/instance")).thenReturn(target);
        Mockito.when(base.path("/refresh")).thenReturn(target);

        Invocation.Builder builder = Mockito.mock(Invocation.Builder.class);
        Mockito.when(target.request("application/json")).thenReturn(builder);

        InstanceConfirmation confirmation = new InstanceConfirmation()
                .setAttestationData("data").setDomain("athenz")
                .setProvider("provider").setService("service");
        Entity<?> entity = Entity.entity(confirmation, "application/json");
        Response response = Mockito.mock(Response.class);
        Mockito.when(builder.post(entity)).thenReturn(response);
        Mockito.when(response.getStatus()).thenReturn(401);

        try {
            provClient.postInstanceConfirmation(confirmation);
            fail();
        } catch (ResourceException ex) {
            assertEquals(ex.getCode(), 401);
        }
        
        try {
            provClient.postRefreshConfirmation(confirmation);
            fail();
        } catch (ResourceException ex) {
            assertEquals(ex.getCode(), 401);
        }
        
        provClient.close();
    }
}
