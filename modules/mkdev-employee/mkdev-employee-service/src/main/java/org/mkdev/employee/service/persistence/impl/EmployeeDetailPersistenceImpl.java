/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.mkdev.employee.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import org.mkdev.employee.exception.NoSuchEmployeeDetailException;
import org.mkdev.employee.model.EmployeeDetail;
import org.mkdev.employee.model.impl.EmployeeDetailImpl;
import org.mkdev.employee.model.impl.EmployeeDetailModelImpl;
import org.mkdev.employee.service.persistence.EmployeeDetailPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the employee detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailPersistence
 * @see org.mkdev.employee.service.persistence.EmployeeDetailUtil
 * @generated
 */
@ProviderType
public class EmployeeDetailPersistenceImpl extends BasePersistenceImpl<EmployeeDetail>
	implements EmployeeDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmployeeDetailUtil} to access the employee detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmployeeDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EmployeeDetailModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the employee details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching employee details
	 */
	@Override
	public List<EmployeeDetail> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @return the range of matching employee details
	 */
	@Override
	public List<EmployeeDetail> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee details
	 */
	@Override
	public List<EmployeeDetail> findByUuid(String uuid, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee details where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching employee details
	 */
	@Override
	public List<EmployeeDetail> findByUuid(String uuid, int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<EmployeeDetail> list = null;

		if (retrieveFromCache) {
			list = (List<EmployeeDetail>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetail employeeDetail : list) {
					if (!uuid.equals(employeeDetail.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<EmployeeDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmployeeDetail>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail findByUuid_First(String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = fetchByUuid_First(uuid,
				orderByComparator);

		if (employeeDetail != null) {
			return employeeDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchEmployeeDetailException(msg.toString());
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUuid_First(String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		List<EmployeeDetail> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail findByUuid_Last(String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = fetchByUuid_Last(uuid, orderByComparator);

		if (employeeDetail != null) {
			return employeeDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchEmployeeDetailException(msg.toString());
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUuid_Last(String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetail> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee details before and after the current employee detail in the ordered set where uuid = &#63;.
	 *
	 * @param empId the primary key of the current employee detail
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail[] findByUuid_PrevAndNext(long empId, String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {
		uuid = Objects.toString(uuid, "");

		EmployeeDetail employeeDetail = findByPrimaryKey(empId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetail[] array = new EmployeeDetailImpl[3];

			array[0] = getByUuid_PrevAndNext(session, employeeDetail, uuid,
					orderByComparator, true);

			array[1] = employeeDetail;

			array[2] = getByUuid_PrevAndNext(session, employeeDetail, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeDetail getByUuid_PrevAndNext(Session session,
		EmployeeDetail employeeDetail, String uuid,
		OrderByComparator<EmployeeDetail> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EmployeeDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employeeDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmployeeDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee details where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EmployeeDetail employeeDetail : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employeeDetail);
		}
	}

	/**
	 * Returns the number of employee details where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching employee details
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "employeeDetail.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "employeeDetail.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(employeeDetail.uuid IS NULL OR employeeDetail.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			EmployeeDetailModelImpl.UUID_COLUMN_BITMASK |
			EmployeeDetailModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail findByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = fetchByUUID_G(uuid, groupId);

		if (employeeDetail == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEmployeeDetailException(msg.toString());
		}

		return employeeDetail;
	}

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the employee detail where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof EmployeeDetail) {
			EmployeeDetail employeeDetail = (EmployeeDetail)result;

			if (!Objects.equals(uuid, employeeDetail.getUuid()) ||
					(groupId != employeeDetail.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<EmployeeDetail> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					EmployeeDetail employeeDetail = list.get(0);

					result = employeeDetail;

					cacheResult(employeeDetail);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EmployeeDetail)result;
		}
	}

	/**
	 * Removes the employee detail where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the employee detail that was removed
	 */
	@Override
	public EmployeeDetail removeByUUID_G(String uuid, long groupId)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = findByUUID_G(uuid, groupId);

		return remove(employeeDetail);
	}

	/**
	 * Returns the number of employee details where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching employee details
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "employeeDetail.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "employeeDetail.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(employeeDetail.uuid IS NULL OR employeeDetail.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "employeeDetail.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			EmployeeDetailModelImpl.UUID_COLUMN_BITMASK |
			EmployeeDetailModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching employee details
	 */
	@Override
	public List<EmployeeDetail> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @return the range of matching employee details
	 */
	@Override
	public List<EmployeeDetail> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee details
	 */
	@Override
	public List<EmployeeDetail> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<EmployeeDetail> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching employee details
	 */
	@Override
	public List<EmployeeDetail> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<EmployeeDetail> list = null;

		if (retrieveFromCache) {
			list = (List<EmployeeDetail>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EmployeeDetail employeeDetail : list) {
					if (!uuid.equals(employeeDetail.getUuid()) ||
							(companyId != employeeDetail.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<EmployeeDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmployeeDetail>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (employeeDetail != null) {
			return employeeDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchEmployeeDetailException(msg.toString());
	}

	/**
	 * Returns the first employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		List<EmployeeDetail> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (employeeDetail != null) {
			return employeeDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchEmployeeDetailException(msg.toString());
	}

	/**
	 * Returns the last employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<EmployeeDetail> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee details before and after the current employee detail in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param empId the primary key of the current employee detail
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail[] findByUuid_C_PrevAndNext(long empId, String uuid,
		long companyId, OrderByComparator<EmployeeDetail> orderByComparator)
		throws NoSuchEmployeeDetailException {
		uuid = Objects.toString(uuid, "");

		EmployeeDetail employeeDetail = findByPrimaryKey(empId);

		Session session = null;

		try {
			session = openSession();

			EmployeeDetail[] array = new EmployeeDetailImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, employeeDetail, uuid,
					companyId, orderByComparator, true);

			array[1] = employeeDetail;

			array[2] = getByUuid_C_PrevAndNext(session, employeeDetail, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmployeeDetail getByUuid_C_PrevAndNext(Session session,
		EmployeeDetail employeeDetail, String uuid, long companyId,
		OrderByComparator<EmployeeDetail> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(EmployeeDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employeeDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmployeeDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee details where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (EmployeeDetail employeeDetail : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employeeDetail);
		}
	}

	/**
	 * Returns the number of employee details where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching employee details
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPLOYEEDETAIL_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "employeeDetail.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "employeeDetail.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(employeeDetail.uuid IS NULL OR employeeDetail.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "employeeDetail.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPLOYEEID = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmployeeId", new String[] { Long.class.getName() },
			EmployeeDetailModelImpl.EMPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEEID = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the employee detail where empId = &#63; or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	 *
	 * @param empId the emp ID
	 * @return the matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail findByEmployeeId(long empId)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = fetchByEmployeeId(empId);

		if (employeeDetail == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("empId=");
			msg.append(empId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEmployeeDetailException(msg.toString());
		}

		return employeeDetail;
	}

	/**
	 * Returns the employee detail where empId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param empId the emp ID
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByEmployeeId(long empId) {
		return fetchByEmployeeId(empId, true);
	}

	/**
	 * Returns the employee detail where empId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param empId the emp ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByEmployeeId(long empId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { empId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					finderArgs, this);
		}

		if (result instanceof EmployeeDetail) {
			EmployeeDetail employeeDetail = (EmployeeDetail)result;

			if ((empId != employeeDetail.getEmpId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				List<EmployeeDetail> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"EmployeeDetailPersistenceImpl.fetchByEmployeeId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeeDetail employeeDetail = list.get(0);

					result = employeeDetail;

					cacheResult(employeeDetail);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EmployeeDetail)result;
		}
	}

	/**
	 * Removes the employee detail where empId = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @return the employee detail that was removed
	 */
	@Override
	public EmployeeDetail removeByEmployeeId(long empId)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = findByEmployeeId(empId);

		return remove(employeeDetail);
	}

	/**
	 * Returns the number of employee details where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the number of matching employee details
	 */
	@Override
	public int countByEmployeeId(long empId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEEID;

		Object[] finderArgs = new Object[] { empId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPLOYEEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEEID_EMPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPID_2 = "employeeDetail.empId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USEREMAIL = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED,
			EmployeeDetailImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserEmail",
			new String[] { String.class.getName(), String.class.getName() },
			EmployeeDetailModelImpl.FIRSTNAME_COLUMN_BITMASK |
			EmployeeDetailModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USEREMAIL = new FinderPath(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserEmail",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the employee detail where firstName = &#63; and email = &#63; or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	 *
	 * @param firstName the first name
	 * @param email the email
	 * @return the matching employee detail
	 * @throws NoSuchEmployeeDetailException if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail findByUserEmail(String firstName, String email)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = fetchByUserEmail(firstName, email);

		if (employeeDetail == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("firstName=");
			msg.append(firstName);

			msg.append(", email=");
			msg.append(email);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEmployeeDetailException(msg.toString());
		}

		return employeeDetail;
	}

	/**
	 * Returns the employee detail where firstName = &#63; and email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param firstName the first name
	 * @param email the email
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUserEmail(String firstName, String email) {
		return fetchByUserEmail(firstName, email, true);
	}

	/**
	 * Returns the employee detail where firstName = &#63; and email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param firstName the first name
	 * @param email the email
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching employee detail, or <code>null</code> if a matching employee detail could not be found
	 */
	@Override
	public EmployeeDetail fetchByUserEmail(String firstName, String email,
		boolean retrieveFromCache) {
		firstName = Objects.toString(firstName, "");
		email = Objects.toString(email, "");

		Object[] finderArgs = new Object[] { firstName, email };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USEREMAIL,
					finderArgs, this);
		}

		if (result instanceof EmployeeDetail) {
			EmployeeDetail employeeDetail = (EmployeeDetail)result;

			if (!Objects.equals(firstName, employeeDetail.getFirstName()) ||
					!Objects.equals(email, employeeDetail.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE);

			boolean bindFirstName = false;

			if (firstName.isEmpty()) {
				query.append(_FINDER_COLUMN_USEREMAIL_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_USEREMAIL_FIRSTNAME_2);
			}

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_USEREMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_USEREMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (bindEmail) {
					qPos.add(email);
				}

				List<EmployeeDetail> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_USEREMAIL,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"EmployeeDetailPersistenceImpl.fetchByUserEmail(String, String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					EmployeeDetail employeeDetail = list.get(0);

					result = employeeDetail;

					cacheResult(employeeDetail);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USEREMAIL,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EmployeeDetail)result;
		}
	}

	/**
	 * Removes the employee detail where firstName = &#63; and email = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param email the email
	 * @return the employee detail that was removed
	 */
	@Override
	public EmployeeDetail removeByUserEmail(String firstName, String email)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = findByUserEmail(firstName, email);

		return remove(employeeDetail);
	}

	/**
	 * Returns the number of employee details where firstName = &#63; and email = &#63;.
	 *
	 * @param firstName the first name
	 * @param email the email
	 * @return the number of matching employee details
	 */
	@Override
	public int countByUserEmail(String firstName, String email) {
		firstName = Objects.toString(firstName, "");
		email = Objects.toString(email, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_USEREMAIL;

		Object[] finderArgs = new Object[] { firstName, email };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPLOYEEDETAIL_WHERE);

			boolean bindFirstName = false;

			if (firstName.isEmpty()) {
				query.append(_FINDER_COLUMN_USEREMAIL_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_USEREMAIL_FIRSTNAME_2);
			}

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_USEREMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_USEREMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (bindEmail) {
					qPos.add(email);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USEREMAIL_FIRSTNAME_1 = "employeeDetail.firstName IS NULL AND ";
	private static final String _FINDER_COLUMN_USEREMAIL_FIRSTNAME_2 = "employeeDetail.firstName = ? AND ";
	private static final String _FINDER_COLUMN_USEREMAIL_FIRSTNAME_3 = "(employeeDetail.firstName IS NULL OR employeeDetail.firstName = '') AND ";
	private static final String _FINDER_COLUMN_USEREMAIL_EMAIL_1 = "employeeDetail.email IS NULL";
	private static final String _FINDER_COLUMN_USEREMAIL_EMAIL_2 = "employeeDetail.email = ?";
	private static final String _FINDER_COLUMN_USEREMAIL_EMAIL_3 = "(employeeDetail.email IS NULL OR employeeDetail.email = '')";

	public EmployeeDetailPersistenceImpl() {
		setModelClass(EmployeeDetail.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the employee detail in the entity cache if it is enabled.
	 *
	 * @param employeeDetail the employee detail
	 */
	@Override
	public void cacheResult(EmployeeDetail employeeDetail) {
		entityCache.putResult(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailImpl.class, employeeDetail.getPrimaryKey(),
			employeeDetail);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { employeeDetail.getUuid(), employeeDetail.getGroupId() },
			employeeDetail);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID,
			new Object[] { employeeDetail.getEmpId() }, employeeDetail);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USEREMAIL,
			new Object[] {
				employeeDetail.getFirstName(), employeeDetail.getEmail()
			}, employeeDetail);

		employeeDetail.resetOriginalValues();
	}

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	@Override
	public void cacheResult(List<EmployeeDetail> employeeDetails) {
		for (EmployeeDetail employeeDetail : employeeDetails) {
			if (entityCache.getResult(
						EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeDetailImpl.class, employeeDetail.getPrimaryKey()) == null) {
				cacheResult(employeeDetail);
			}
			else {
				employeeDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employee details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeDetailImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee detail.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeDetail employeeDetail) {
		entityCache.removeResult(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailImpl.class, employeeDetail.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EmployeeDetailModelImpl)employeeDetail, true);
	}

	@Override
	public void clearCache(List<EmployeeDetail> employeeDetails) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmployeeDetail employeeDetail : employeeDetails) {
			entityCache.removeResult(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeDetailImpl.class, employeeDetail.getPrimaryKey());

			clearUniqueFindersCache((EmployeeDetailModelImpl)employeeDetail,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeDetailModelImpl employeeDetailModelImpl) {
		Object[] args = new Object[] {
				employeeDetailModelImpl.getUuid(),
				employeeDetailModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			employeeDetailModelImpl, false);

		args = new Object[] { employeeDetailModelImpl.getEmpId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args,
			employeeDetailModelImpl, false);

		args = new Object[] {
				employeeDetailModelImpl.getFirstName(),
				employeeDetailModelImpl.getEmail()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_USEREMAIL, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_USEREMAIL, args,
			employeeDetailModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		EmployeeDetailModelImpl employeeDetailModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					employeeDetailModelImpl.getUuid(),
					employeeDetailModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((employeeDetailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					employeeDetailModelImpl.getOriginalUuid(),
					employeeDetailModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { employeeDetailModelImpl.getEmpId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);
		}

		if ((employeeDetailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPLOYEEID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					employeeDetailModelImpl.getOriginalEmpId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMPLOYEEID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
					employeeDetailModelImpl.getFirstName(),
					employeeDetailModelImpl.getEmail()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USEREMAIL, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USEREMAIL, args);
		}

		if ((employeeDetailModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USEREMAIL.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					employeeDetailModelImpl.getOriginalFirstName(),
					employeeDetailModelImpl.getOriginalEmail()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USEREMAIL, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USEREMAIL, args);
		}
	}

	/**
	 * Creates a new employee detail with the primary key. Does not add the employee detail to the database.
	 *
	 * @param empId the primary key for the new employee detail
	 * @return the new employee detail
	 */
	@Override
	public EmployeeDetail create(long empId) {
		EmployeeDetail employeeDetail = new EmployeeDetailImpl();

		employeeDetail.setNew(true);
		employeeDetail.setPrimaryKey(empId);

		String uuid = PortalUUIDUtil.generate();

		employeeDetail.setUuid(uuid);

		employeeDetail.setCompanyId(companyProvider.getCompanyId());

		return employeeDetail;
	}

	/**
	 * Removes the employee detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empId the primary key of the employee detail
	 * @return the employee detail that was removed
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail remove(long empId)
		throws NoSuchEmployeeDetailException {
		return remove((Serializable)empId);
	}

	/**
	 * Removes the employee detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee detail
	 * @return the employee detail that was removed
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail remove(Serializable primaryKey)
		throws NoSuchEmployeeDetailException {
		Session session = null;

		try {
			session = openSession();

			EmployeeDetail employeeDetail = (EmployeeDetail)session.get(EmployeeDetailImpl.class,
					primaryKey);

			if (employeeDetail == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employeeDetail);
		}
		catch (NoSuchEmployeeDetailException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmployeeDetail removeImpl(EmployeeDetail employeeDetail) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeDetail)) {
				employeeDetail = (EmployeeDetail)session.get(EmployeeDetailImpl.class,
						employeeDetail.getPrimaryKeyObj());
			}

			if (employeeDetail != null) {
				session.delete(employeeDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employeeDetail != null) {
			clearCache(employeeDetail);
		}

		return employeeDetail;
	}

	@Override
	public EmployeeDetail updateImpl(EmployeeDetail employeeDetail) {
		boolean isNew = employeeDetail.isNew();

		if (!(employeeDetail instanceof EmployeeDetailModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employeeDetail.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(employeeDetail);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employeeDetail proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EmployeeDetail implementation " +
				employeeDetail.getClass());
		}

		EmployeeDetailModelImpl employeeDetailModelImpl = (EmployeeDetailModelImpl)employeeDetail;

		if (Validator.isNull(employeeDetail.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			employeeDetail.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (employeeDetail.getCreateDate() == null)) {
			if (serviceContext == null) {
				employeeDetail.setCreateDate(now);
			}
			else {
				employeeDetail.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!employeeDetailModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				employeeDetail.setModifiedDate(now);
			}
			else {
				employeeDetail.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (employeeDetail.isNew()) {
				session.save(employeeDetail);

				employeeDetail.setNew(false);
			}
			else {
				employeeDetail = (EmployeeDetail)session.merge(employeeDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EmployeeDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { employeeDetailModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					employeeDetailModelImpl.getUuid(),
					employeeDetailModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((employeeDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeDetailModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { employeeDetailModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((employeeDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeDetailModelImpl.getOriginalUuid(),
						employeeDetailModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						employeeDetailModelImpl.getUuid(),
						employeeDetailModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}
		}

		entityCache.putResult(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeDetailImpl.class, employeeDetail.getPrimaryKey(),
			employeeDetail, false);

		clearUniqueFindersCache(employeeDetailModelImpl, false);
		cacheUniqueFindersCache(employeeDetailModelImpl);

		employeeDetail.resetOriginalValues();

		return employeeDetail;
	}

	/**
	 * Returns the employee detail with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee detail
	 * @return the employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeDetailException {
		EmployeeDetail employeeDetail = fetchByPrimaryKey(primaryKey);

		if (employeeDetail == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employeeDetail;
	}

	/**
	 * Returns the employee detail with the primary key or throws a {@link NoSuchEmployeeDetailException} if it could not be found.
	 *
	 * @param empId the primary key of the employee detail
	 * @return the employee detail
	 * @throws NoSuchEmployeeDetailException if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail findByPrimaryKey(long empId)
		throws NoSuchEmployeeDetailException {
		return findByPrimaryKey((Serializable)empId);
	}

	/**
	 * Returns the employee detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee detail
	 * @return the employee detail, or <code>null</code> if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeDetailImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EmployeeDetail employeeDetail = (EmployeeDetail)serializable;

		if (employeeDetail == null) {
			Session session = null;

			try {
				session = openSession();

				employeeDetail = (EmployeeDetail)session.get(EmployeeDetailImpl.class,
						primaryKey);

				if (employeeDetail != null) {
					cacheResult(employeeDetail);
				}
				else {
					entityCache.putResult(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeDetailImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employeeDetail;
	}

	/**
	 * Returns the employee detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empId the primary key of the employee detail
	 * @return the employee detail, or <code>null</code> if a employee detail with the primary key could not be found
	 */
	@Override
	public EmployeeDetail fetchByPrimaryKey(long empId) {
		return fetchByPrimaryKey((Serializable)empId);
	}

	@Override
	public Map<Serializable, EmployeeDetail> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EmployeeDetail> map = new HashMap<Serializable, EmployeeDetail>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EmployeeDetail employeeDetail = fetchByPrimaryKey(primaryKey);

			if (employeeDetail != null) {
				map.put(primaryKey, employeeDetail);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeDetailImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EmployeeDetail)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EMPLOYEEDETAIL_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (EmployeeDetail employeeDetail : (List<EmployeeDetail>)q.list()) {
				map.put(employeeDetail.getPrimaryKeyObj(), employeeDetail);

				cacheResult(employeeDetail);

				uncachedPrimaryKeys.remove(employeeDetail.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EmployeeDetailModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeDetailImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the employee details.
	 *
	 * @return the employee details
	 */
	@Override
	public List<EmployeeDetail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @return the range of employee details
	 */
	@Override
	public List<EmployeeDetail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee details
	 */
	@Override
	public List<EmployeeDetail> findAll(int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the employee details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployeeDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee details
	 * @param end the upper bound of the range of employee details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of employee details
	 */
	@Override
	public List<EmployeeDetail> findAll(int start, int end,
		OrderByComparator<EmployeeDetail> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EmployeeDetail> list = null;

		if (retrieveFromCache) {
			list = (List<EmployeeDetail>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EMPLOYEEDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEDETAIL;

				if (pagination) {
					sql = sql.concat(EmployeeDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmployeeDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EmployeeDetail>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the employee details from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EmployeeDetail employeeDetail : findAll()) {
			remove(employeeDetail);
		}
	}

	/**
	 * Returns the number of employee details.
	 *
	 * @return the number of employee details
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMPLOYEEDETAIL);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeDetailModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee detail persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EmployeeDetailImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EMPLOYEEDETAIL = "SELECT employeeDetail FROM EmployeeDetail employeeDetail";
	private static final String _SQL_SELECT_EMPLOYEEDETAIL_WHERE_PKS_IN = "SELECT employeeDetail FROM EmployeeDetail employeeDetail WHERE empId IN (";
	private static final String _SQL_SELECT_EMPLOYEEDETAIL_WHERE = "SELECT employeeDetail FROM EmployeeDetail employeeDetail WHERE ";
	private static final String _SQL_COUNT_EMPLOYEEDETAIL = "SELECT COUNT(employeeDetail) FROM EmployeeDetail employeeDetail";
	private static final String _SQL_COUNT_EMPLOYEEDETAIL_WHERE = "SELECT COUNT(employeeDetail) FROM EmployeeDetail employeeDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmployeeDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmployeeDetail exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EmployeeDetailPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}