// Copyright 2009-2013 Information & Computational Sciences, JHI. All rights
// reserved. Use is subject to the accompanying licence terms.

package flapjack.io.binning;

import java.io.*;
import java.util.*;
import java.text.*;

public class BinData
{
	private static StandardBinner binner;

	public static void main(String[] args)
		throws Exception
	{
		String method = args[0].toUpperCase();

		if (method.equals("STANDARD"))
		{
			int numBins = Integer.parseInt(args[3]);
			binner = new StandardBinner(numBins);
		}

		else if (method.equals("SPLIT"))
		{
			int lBinCount = Integer.parseInt(args[3]);
			float split = Float.parseFloat(args[4]);
			int rBinCount = Integer.parseInt(args[5]);

			// binner = new SplitBinner(...);
		}

		else if (method.equals("AUTO"))
		{
			int numBins = Integer.parseInt(args[3]);

			// binner = new AutoBinner(...);
		}

		String inFile = args[1];
		String outFile = args[2];

		writeBinFile(inFile, outFile);
	}

	private static void writeBinFile(String inFile, String outFile)
		throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader(inFile));
		BufferedWriter out = new BufferedWriter(new FileWriter(outFile));

		// Write the header lines
		for (int i = 0; i < 2; i++)
		{
			out.write(in.readLine());
			out.newLine();
		}

		// Now write all the data, binning it as we go
		String str = null;
		while ((str = in.readLine()) != null && str.length() > 0)
		{
			String[] split = str.split("\t");

			// Line name
			out.write(split[0]);

			// Ignore 1st column
			for (int i = 1; i < split.length; i++)
			{
				// Ignore empty strings
				if (split[i].isEmpty())
					out.write("\t");
				else
				{
					float value = Float.parseFloat(split[i]);
					int bin = binner.bin(value);

					out.write("\t" + bin);
				}
			}

			out.newLine();
		}

		in.close();
		out.close();
	}
}