package npc.martin.little.service;

/*
 * Copyright 2022 bikathi_martin.
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

import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author bikathi_martin
 */

@Service
public class ConvenienceService {
    public String generateUniqueId() {
        return UUID.randomUUID().toString()
            .replace("-", "")
            .substring(0, 10);
    }
}
