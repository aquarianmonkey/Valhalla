package com.berns.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOApp
{

	public static void main(String[] args) throws IOException
	{

		// Create a path
		Path p1 = Paths.get("C:\\MyDocs\\Personal\\APE\\ape_summary.2012.pdf");
		URI uri = p1.toUri();

		File pdf = p1.getFileName().toFile();
		// long size = Files.size(p1);
		String name = "enzo";
		byte[] bytes = name.getBytes();
		
		 int ee = 'e';
		pdf.exists();


	}

}
