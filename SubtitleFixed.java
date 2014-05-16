package com.spr.subtitles;

import java.io.BufferedReader;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.OutputStreamWriter;

import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SubtitleFixed {

	String[] wrds;
	String ln, from, to;
	int seconds;

	static String charset = "ISO-8859-1";

	public static void main(String[] args) {

		Charset windows1252 = Charset.forName("windows-1252");

		// TODO Auto-generated method stub
		if (args.length != 3) {
			System.out.println("Usage: in seconds out");
			System.exit(1);
		}
		String inFile = args[0];

		String outfile = args[2];

		// String inFile = "c:\\Users\\Walker\\Downloads\\anchorman.srt.txt";

		// 00:02:05,209 --> 00:02:08,045
		BufferedReader br = null;
		SubtitleFixed sline = new SubtitleFixed();
		sline.seconds = Integer.parseInt(args[1]);
		// sline.seconds = 5;

		FileOutputStream out = null;
		Writer writer = null;

		FileWriter fstream = null;
		try {
			out = new FileOutputStream(outfile);
			writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
			// fstream = new FileWriter(outfile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	 

		String sCurrentLine, modline;

		try {

			br = new BufferedReader(new FileReader(inFile));
			

			String s = null;

			while ((sCurrentLine = br.readLine()) != null) {

			 

			sline.setline(sCurrentLine);
			modline = sline.getLine();

			writer.write(modline + "\r\n");
			System.out.println(modline);
			}

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	 

				

 

	// 00:02:05,209 --> 00:02:08,045

	void setline(String s) {
		ln = s;
	}

	String getLine() {

		if (ln.matches("2081.*")) {
			int i = 1;
			i++;

		}

		if (ln.matches("(\\d\\d:\\d\\d).*")) {
			wrds = ln.split(" --> ");
			from = adjustTime(wrds[0]);
			to = adjustTime(wrds[1]);
			return from + " --> " + to;

		} else {
			return ln;
		}

	}

	String adjustTime(String s) {

		// 00:00:00,000
		Calendar cal = new GregorianCalendar();
		String[] wrds = s.split(",");
		String left = wrds[0];
		String[] wrds2 = left.split(":");

		int year = 2014;
		int month = 3;
		int date = 19;
		int hour = Integer.parseInt(wrds2[0]);
		int minute = Integer.parseInt(wrds2[1]);
		int second = Integer.parseInt(wrds2[2]);

		cal.set(year, month, date, hour, minute, second);

		cal.add(Calendar.SECOND, seconds);

		Date time = cal.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String stime = sdf.format(cal.getTime());

		return stime + "," + wrds[1];
	}

}
