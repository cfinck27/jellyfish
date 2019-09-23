/*
 * Copyright (c) 2019 Chris Finck
 * All Rights Reserved.
 */

package projectjellyfish.debug;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class JLog
{
    
    private static String logDir = "logs/";
    public static void setLogDir(String dir)
    {
        char last = dir.charAt(dir.length() - 1);
        if (last != '\\' || last != '/')
        {
            logDir = dir + '/';
        }
        else
        {
            logDir = dir;
        }
    }
    public static String getLogDir()
    {
        return logDir;
    }
    
    private PrintStream out;
    private PrintStream fout = null;
    
    public JLog(OutputStream ostream)
    {
        out = new PrintStream(ostream);
    }
    
    public void setOutputFile(String path)
    {
        File d = new File(logDir);
        d.mkdirs();
        File f = new File(logDir + path);
        try
        {
            f.createNewFile();
            fout = new PrintStream(f);
        }
        catch (IOException ex)
        {
            out.println("LOG::ERROR: Could not set log file.");
        }
    }
    
    public void setOutputStream(OutputStream ostream)
    {
        out = new PrintStream(ostream);
    }
    
    public void print(Object o)
    {
        out.print(o.toString());
        if (fout != null)
        {
            fout.print(o.toString());
            fout.flush();
        }
    }
    
    public void println(Object o)
    {
        out.println(o.toString());
        if (fout != null)
        {
            fout.println(o.toString());
            fout.flush();
        }
    }
    
}