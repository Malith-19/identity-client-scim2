/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package io.scim2.swagger.client.api;

import com.google.gson.reflect.TypeToken;
import io.scim2.swagger.client.ScimApiClient;
import io.scim2.swagger.client.ScimApiException;
import io.scim2.swagger.client.ScimApiResponse;
import io.scim2.swagger.client.Configuration;
import org.apache.http.client.methods.HttpUriRequest;

import java.lang.reflect.Type;
import java.util.List;

public class Scimv2BulkApi extends Scimv2BaseApi {

    public Scimv2BulkApi() {
        this(Configuration.getDefaultScimApiClient());
    }

    public Scimv2BulkApi(ScimApiClient scimApiClient) {
        super(scimApiClient);
    }

    private HttpUriRequest createBulkValidateBeforeCall(List<String> attributes, List<String> excludedAttributes, String body)
            throws ScimApiException {

        return createResourceCall(attributes, excludedAttributes, body);
    }

    /**
     * Return the bulk which was created.
     * Returns HTTP 201 if the bulk is successfully created.
     *
     * @param attributes         SCIM defined attributes parameter. (optional)
     * @param excludedAttributes SCIM defined excludedAttribute parameter. (optional)
     * @param body               (optional)
     * @return String
     * @throws ScimApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public String createBulk(List<String> attributes, List<String> excludedAttributes, String body)
            throws ScimApiException {
        ScimApiResponse<String> resp = createBulkWithHttpInfo(attributes, excludedAttributes, body);
        return resp.getData();
    }

    /**
     * Return the bulk which was created.
     * Returns HTTP 201 if the bulk is successfully created.
     *
     * @param attributes         SCIM defined attributes parameter. (optional)
     * @param excludedAttributes SCIM defined excludedAttribute parameter. (optional)
     * @param body               (optional)
     * @return ScimApiResponse&lt;String&gt;
     * @throws ScimApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ScimApiResponse<String> createBulkWithHttpInfo(List<String> attributes, List<String> excludedAttributes,
                                                          String body) throws ScimApiException {
        HttpUriRequest call = createBulkValidateBeforeCall(attributes, excludedAttributes, body);
        Type localVarReturnType = new TypeToken<String>() {}.getType();
        return scimApiClient.execute(call, localVarReturnType);
    }
}
