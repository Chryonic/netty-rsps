package com.runescape;

import java.applet.Applet;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class SignLink implements Runnable {

    public static final int clientVersion = 317;
    public static int userID;
    public static int storeID = 32;
    public static RandomAccessFile cacheDataFile = null;
    public static final RandomAccessFile[] cacheIndexFiles = new RandomAccessFile[5];
    public static boolean isUsingJava;
    public static final Applet applet = null;
    private static boolean isActive;
    private static int threadID;
    private static InetAddress socketAddress;
    private static int socketPort;
    private static Socket socket = null;
    private static int threadPriority = 1;
    private static Runnable threadName = null;
    private static String dnsAddress = null;
    public static String dns = null;
    private static String urlreq = null;
    private static DataInputStream urlstream = null;
    private static int fileLength;
    private static String fileName = null;
    private static byte[] fileBuffer = null;
    private static boolean isPlayingMidi;
    private static int filePosition;
    public static String midiFile = null;
    public static int midiVolume;
    public static int midiFade;
    private static boolean isPlayingWave;
    public static int waveVolume;
    public static boolean isReportingError = true;
    public static String errorName = "";

    private SignLink() {}

    public static void initialize(InetAddress inetaddress) {
        threadID = (int)(Math.random() * 99999999D);
        if(isActive) {
            try {
                Thread.sleep(500L);
            } catch(Exception _ex) {}
            isActive = false;
        }
        socketPort = 0;
        threadName = null;
        dnsAddress = null;
        fileName = null;
        urlreq = null;
        socketAddress = inetaddress;
        Thread thread = new Thread(new SignLink());
        thread.setDaemon(true);
        thread.start();
        while(!isActive) {
            try {
                Thread.sleep(50L);
            } catch(InterruptedException _ex) {}
        }
    }

    public void run() {
    	isActive = true;
        String directory = findCacheDirectory();
        userID = getUserID(directory);
        try {
            File file = new File(directory + "main_file_cache.dat");
            if(file.exists() && file.length() > 0x3200000L) {
                file.delete();
            }
            cacheDataFile = new RandomAccessFile(directory + "main_file_cache.dat", "rw");
            for(int j = 0; j < 5; j++) {
                cacheIndexFiles[j] = new RandomAccessFile(directory + "main_file_cache.idx" + j, "rw");
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        for(int id = threadID; threadID == id;) {
            if(socketPort != 0) {
                try {
                    socket = new Socket(socketAddress, socketPort);
                } catch(Exception _ex) {
                    socket = null;
                }
                socketPort = 0;
            } else if(threadName != null) {
                Thread thread = new Thread(threadName);
                thread.setDaemon(true);
                thread.start();
                thread.setPriority(threadPriority);
                threadName = null;
            } else if(dnsAddress != null) {
                try {
                    dns = InetAddress.getByName(dnsAddress).getHostName();
                } catch(Exception _ex) {
                    dns = "unknown";
                }
                dnsAddress = null;
            } else if(fileName != null) {
                if(fileBuffer != null) {
                    try {
                        FileOutputStream fileoutputstream = new FileOutputStream(directory + fileName);
                        fileoutputstream.write(fileBuffer, 0, fileLength);
                        fileoutputstream.close();
                    } catch(Exception _ex) {}
                }
                if(isPlayingWave) {
                	isPlayingWave = false;
                }
                if(isPlayingMidi) {
                    midiFile = directory + fileName;
                    isPlayingMidi = false;
                }
                fileName = null;
            } else if(urlreq != null) {
                try {
                    System.out.println("urlstream");
                    urlstream = new DataInputStream((new URL(applet.getCodeBase(), urlreq)).openStream());
                } catch(Exception _ex) {
                    urlstream = null;
                }
                urlreq = null;
            }
            try {
                Thread.sleep(50L);
            } catch(Exception _ex) {}
        }
    }

    private static String findCacheDirectory() {
        return "./cache/";
    }

    private static int getUserID(String s) {
        try {
            File file = new File(s + "uid.dat");
            if(!file.exists() || file.length() < 4L) {
                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(s + "uid.dat"));
                dataoutputstream.writeInt((int)(Math.random() * 99999999D));
                dataoutputstream.close();
            }
        } catch(Exception _ex) {}
        try {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(s + "uid.dat"));
            int i = datainputstream.readInt();
            datainputstream.close();
            return i + 1;
        } catch(Exception _ex) {
            return 0;
        }
    }

    public static synchronized Socket openSocket(int port) throws IOException {
        for(socketPort = port; socketPort != 0;) {
            try {
                Thread.sleep(50L);
            } catch(Exception _ex) {}
        }
        if(socket == null) {
            throw new IOException("could not open socket");
        } else {
            return socket;
    	}
    }

    public static synchronized DataInputStream openURL(String s) throws IOException {
        for(urlreq = s; urlreq != null;) {
            try {
                Thread.sleep(50L);
            } catch(Exception _ex) {}
        }
        if(urlstream == null) {
            throw new IOException("could not open: " + s);
        } else {
            return urlstream;
        }
    }

    public static synchronized void openDNS(String address) {
        dns = address;
        dnsAddress = address;
    }

    public static synchronized void startThread(Runnable name, int priority) {
        threadPriority = priority;
        threadName = name;
    }

    public static synchronized boolean saveWaveFile(byte[] buffer, int i) {
        if(i > 0x1e8480) {
            return false;
        }
        if(fileName != null) {
            return false;
        } else {
        	filePosition = (filePosition + 1) % 5;
        	fileLength = i;
            fileBuffer = buffer;
            isPlayingWave = true;
            fileName = "sound" + filePosition + ".wav";
            return true;
        }
    }

    public static synchronized boolean replayWaveFile() {
        if(fileName != null) {
            return false;
        } else {
            fileBuffer = null;
            isPlayingWave = true;
            fileName = "sound" + filePosition + ".wav";
            return true;
        }
    }

    public static synchronized void saveMidiFile(byte[] buffer, int length) {
        if(length > 0x1e8480) {
            return;
        }
        if(fileName != null) {
        } else {
        	filePosition = (filePosition + 1) % 5;
            fileLength = length;
            fileBuffer = buffer;
            isPlayingMidi = true;
            fileName = "jingle" + filePosition + ".mid";
        }
    }

    public static void reportError(String error) {
        System.out.println("Error: " + error);
    }
}