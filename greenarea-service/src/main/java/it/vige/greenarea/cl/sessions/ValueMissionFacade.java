/******************************************************************************
 * Vige, Home of Professional Open Source Copyright 2010, Vige, and           *
 * individual contributors by the @authors tag. See the copyright.txt in the  *
 * distribution for a full listing of individual contributors.                *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may    *
 * not use this file except in compliance with the License. You may obtain    *
 * a copy of the License at http://www.apache.org/licenses/LICENSE-2.0        *
 * Unless required by applicable law or agreed to in writing, software        *
 * distributed under the License is distributed on an "AS IS" BASIS,          *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 * See the License for the specific language governing permissions and        *
 * limitations under the License.                                             *
 ******************************************************************************/
package it.vige.greenarea.cl.sessions;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import it.vige.greenarea.cl.library.entities.Mission;
import it.vige.greenarea.cl.library.entities.ValueMission;
import it.vige.greenarea.cl.library.entities.ValueMission_;
import it.vige.greenarea.gtg.db.facades.AbstractFacade;

/**
 *
 * 
 */
@Stateless
public class ValueMissionFacade extends AbstractFacade<ValueMission, Integer> {
	@PersistenceContext(unitName = "GTGwebPU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public ValueMissionFacade() {
		super(ValueMission.class);
	}

	@Override
	public Integer getId(ValueMission entity) {
		return entity.getIdVM();
	}

	@Override
	public void setId(ValueMission entity, Integer id) {
	}

	public List<ValueMission> findAByMission(Mission mission) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery();
		Root<ValueMission> trRoot = cq.from(ValueMission.class);
		Predicate wherePredicate = cb.and(cb.equal(trRoot.get(ValueMission_.mission), mission));
		cq = cq.select(trRoot).where(wherePredicate);
		return getEntityManager().createQuery(cq).getResultList();
	}

}
