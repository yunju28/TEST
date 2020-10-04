package org.bimserver.test;

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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MkDirsRec {
	public static void main(String[] args) {
		Path base = Paths.get(args[0]);
		try {
			DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(base);
			for (Path p : newDirectoryStream) {
				String filename = p.getFileName().toString();
				filename = filename.replaceAll(" \\_", "\\_");
				if (filename.toLowerCase().endsWith(".ifc") || filename.toLowerCase().endsWith(".ifczip")) {
					filename = filename.replaceAll("\\_", "\\\\").trim();
					filename = filename.substring(0, filename.lastIndexOf("."));
					Path newPath = base.resolve(filename);
					Files.createDirectories(newPath);
					
					Files.move(p, newPath.resolve(p.getFileName().toString()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
