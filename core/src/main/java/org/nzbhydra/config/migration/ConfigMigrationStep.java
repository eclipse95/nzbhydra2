/*
 *  (C) Copyright 2017 TheOtherP (theotherp@gmx.de)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.nzbhydra.config.migration;

import java.util.List;
import java.util.Map;

public interface ConfigMigrationStep extends Comparable<ConfigMigrationStep> {

    int forVersion();

    Map<String, Object> migrate(Map<String, Object> map);

    @Override
    default int compareTo(ConfigMigrationStep o) {
        return Integer.compare(forVersion(), o.forVersion());
    }

    default Map<String, Object> getFromMap(Map<String, Object> map, String key) {
        return (Map<String, Object>)map.get(key);
    }

    default List<Map<String, Object>> getListFromMap(Map<String, Object> map, String key) {
        return (List<Map<String, Object>>) map.get(key);
    }
}
