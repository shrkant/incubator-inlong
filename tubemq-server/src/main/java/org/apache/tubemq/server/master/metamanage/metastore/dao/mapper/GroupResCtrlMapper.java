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

package org.apache.tubemq.server.master.metamanage.metastore.dao.mapper;

import java.util.Map;
import org.apache.tubemq.server.common.utils.ProcessResult;
import org.apache.tubemq.server.master.metamanage.metastore.dao.entity.GroupResCtrlEntity;



public interface GroupResCtrlMapper extends AbstractMapper {

    boolean addGroupResCtrlConf(GroupResCtrlEntity entity, ProcessResult result);

    boolean updGroupResCtrlConf(GroupResCtrlEntity entity, ProcessResult result);

    boolean delGroupResCtrlConf(String groupName, ProcessResult result);

    GroupResCtrlEntity getGroupResCtrlConf(String groupName);

    Map<String, GroupResCtrlEntity> getGroupResCtrlConf(GroupResCtrlEntity qryEntity);


}