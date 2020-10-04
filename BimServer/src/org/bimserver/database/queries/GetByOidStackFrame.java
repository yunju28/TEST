package org.bimserver.database.queries;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.io.IOException;

import org.bimserver.BimserverDatabaseException;
import org.bimserver.database.queries.om.QueryException;
import org.bimserver.database.queries.om.QueryPart;
import org.bimserver.shared.HashMapVirtualObject;
import org.bimserver.shared.QueryContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class GetByOidStackFrame extends DatabaseReadingStackFrame {

	private long oid;

	public GetByOidStackFrame(QueryContext reusable, QueryObjectProvider queryObjectProvider, QueryPart queryPart, long oid) {
		super(reusable, queryObjectProvider, queryPart);
		this.oid = oid;
	}

	@Override
	boolean process() throws BimserverDatabaseException, QueryException, JsonParseException, JsonMappingException, IOException {
		HashMapVirtualObject byOid = getByOid(oid);
		return false;
	}
}
