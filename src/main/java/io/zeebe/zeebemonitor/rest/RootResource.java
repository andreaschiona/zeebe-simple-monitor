/*
 * Copyright © 2017 camunda services GmbH (info@camunda.com)
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
package io.zeebe.zeebemonitor.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import io.zeebe.zeebemonitor.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/")
public class RootResource
{
    @Autowired
    private ConfigurationRepository configurationRepository;

    @RequestMapping("/")
    public String get(HttpServletResponse httpResponse) throws IOException
    {
        if (configurationRepository.getConfiguration().isPresent())
        {
            httpResponse.sendRedirect("/index.html");
        }
        else
        {
            httpResponse.sendRedirect("/setup.html");
        }
        return null;
    }
}
