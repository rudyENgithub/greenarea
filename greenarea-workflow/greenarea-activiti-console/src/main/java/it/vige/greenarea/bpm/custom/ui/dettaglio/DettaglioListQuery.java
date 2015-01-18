/* Licensed under the Apache License, Version 2.0 (the "License");
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
package it.vige.greenarea.bpm.custom.ui.dettaglio;

import org.activiti.engine.task.TaskQuery;
import org.activiti.explorer.ui.task.data.AbstractTaskListQuery;

/**
 * @author Joram Barrez
 */
public class DettaglioListQuery extends AbstractTaskListQuery {

	private static final long serialVersionUID = 9158854452241433962L;

	private String id;

	public DettaglioListQuery(String id) {
		this.id = id;
	}

	@Override
	protected TaskQuery getQuery() {
		return taskService.createTaskQuery().taskAssignee(userId)
				.processInstanceId(id).orderByTaskId().asc();
	}

}
