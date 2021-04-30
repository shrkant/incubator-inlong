/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.tubemq.server.master.web;

import java.io.IOException;
import java.net.InetSocketAddress;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tubemq.corebase.utils.TStringUtils;
import org.apache.tubemq.server.master.TMaster;
import org.apache.tubemq.server.master.metamanage.MetaDataManager;




public class MasterStatusCheckFilter implements Filter {

    private TMaster master;
    private MetaDataManager metaDataManager;

    public MasterStatusCheckFilter(TMaster master) {
        this.master = master;
        this.metaDataManager =
                this.master.getDefMetaDataManager();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (!metaDataManager.isSelfMaster()) {
            InetSocketAddress masterAddr =
                    metaDataManager.getMasterAddress();
            if (masterAddr == null) {
                throw new IOException("Not found the master node address!");
            }
            StringBuilder sBuilder = new StringBuilder(512).append("http://")
                    .append(masterAddr.getAddress().getHostAddress())
                    .append(":").append(master.getMasterConfig().getWebPort())
                    .append(req.getRequestURI());
            if (TStringUtils.isNotBlank(req.getQueryString())) {
                sBuilder.append("?").append(req.getQueryString());
            }
            resp.sendRedirect(sBuilder.toString());
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
