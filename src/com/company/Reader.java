package com.company;

import com.company.config.Config;

import java.net.ServerSocket;
import java.sql.ResultSet;
import java.util.Scanner;

public class Reader {
    Scanner scanner;
    public Reader(Config config)
    {
        String typer = config.getReader();
        switch (typer)
        {
            case "com": scanner = new Scanner(System.in); break;
           // case "sql": scanner = new Scanner(ResultSet ne)

        }

    }
    public String ScanHash() throws Exception
    {
        System.out.print("PRINT HASH: ");
        String hash =  scanner.nextLine();
        if(hash.isEmpty()) throw new Exception("NO HASH");
        return hash;
    }

}
