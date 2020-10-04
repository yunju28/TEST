package org.bimserver.shared;

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

import java.nio.file.Path;

import org.bimserver.plugins.ResourceFetcher;

public class LocalDevelopmentResourceFetcher extends ResourceFetcher {

	public LocalDevelopmentResourceFetcher(Path workspaceDir) {
//		addPath(workspaceDir.resolve("Builds/defaultsettings/local"));
//		addPath(workspaceDir.resolve("Builds/defaultsettings/shared"));
//		addPath(workspaceDir.resolve("Builds/build/targets/local"));
//		addPath(workspaceDir.resolve("Builds/build/targets/shared"));
		addPath(workspaceDir.resolve("BimServer"));
		addPath(workspaceDir.resolve("BimServerClientLib/src/org/bimserver/client/protocolbuffers"));
	}

//	@Override
//	public Path getFile(String name) throws IOException {
//		if (name.startsWith("lib")) {
//			for (Path projectFile : PathUtils.list(Paths.get(".."))) {
//				Path file = projectFile.resolve(name);
//				if (Files.exists(file)) {
//					return file;
//				}
//			}
//		}
//		return super.getFile(name);
//	}
}