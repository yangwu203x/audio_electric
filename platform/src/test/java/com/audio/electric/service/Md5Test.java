package com.audio.electric.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/6 0006 15:04
 */
public class Md5Test {
    private byte[] digest;
    private byte[] kIpad;
    private byte[] kOpad;
    private MessageDigest md5;
    private MessageDigest innerMD5;

    public Md5Test(byte[] paramArrayOfByte)
            throws NoSuchAlgorithmException
    {
        this.md5 = MessageDigest.getInstance("MD5");
        this.innerMD5 = MessageDigest.getInstance("MD5");
        int i = paramArrayOfByte.length;

        if (i > 64)
        {
            this.md5.update(paramArrayOfByte);
            paramArrayOfByte = this.md5.digest();
        }

        this.kIpad = new byte[64];

        this.kOpad = new byte[64];

        System.arraycopy(paramArrayOfByte, 0, this.kIpad, 0, i);
        System.arraycopy(paramArrayOfByte, 0, this.kOpad, 0, i);

        for (int j = 0; j < 64; j++)
        {
            int tmp95_94 = j;
            byte[] tmp95_91 = this.kIpad; tmp95_91[tmp95_94] = (byte)(tmp95_91[tmp95_94] ^ 0x36);
            int tmp107_106 = j;
            byte[] tmp107_103 = this.kOpad; tmp107_103[tmp107_106] = (byte)(tmp107_103[tmp107_106] ^ 0x5C);
        }

        clear();
    }

    public void addData(byte[] paramArrayOfByte)
    {
        addData(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public void addData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
        this.innerMD5.update(paramArrayOfByte, paramInt1, paramInt2);
    }

    public void clear()
    {
        this.innerMD5.reset();
        this.innerMD5.update(this.kIpad);

        this.digest = null;
    }

    public static void main(String[] paramArrayOfString)
    {
        System.out.println("Test Vectors from RFC 2104 - HMAC: Keyed-Hashing for Message Authentication");
        System.out.println("This test uses HMAC-MD5.");

        System.out.println();
        System.out.println("Test #1:");

        byte[] arrayOfByte2 = {
                11, 11, 11, 11, 11, 11, 11, 11,
                11, 11, 11, 11, 11, 11, 11, 11 };

        String str2 = "Hi There";
        String str1 = "0X9294727A3638BB1C13F48EF8158BFC9D";
        try
        {
            Md5Test localHMAC_MD5 = new Md5Test(str1.getBytes());
            localHMAC_MD5.addData(str2.getBytes());
            byte[] arrayOfByte1 = localHMAC_MD5.sign();

            System.out.println("Calculated hash 0X = " + localHMAC_MD5.toString());
//            System.out.println("  Expected hash " + str1);
//
//            System.out.println();
//            System.out.println("Test #2:");
//
//            byte[] arrayOfByte3 = "Jefe".getBytes();
//            String str3 = "what do ya want for nothing?";
//            str1 = "0X750C783E6AB0B503EAA86E310A5DB738";
//
//            localHMAC_MD5 = new HMAC_MD5(arrayOfByte3);
//            localHMAC_MD5.addData(str3.getBytes());
//            arrayOfByte1 = localHMAC_MD5.sign();
//            System.out.println("Calculated hash 0X" + localHMAC_MD5);
//            System.out.println("  Expected hash " + str1);
//
//            System.out.println();
//            System.out.println("Test #3:");
//
//            byte[] arrayOfByte4 = {
//                    -86, -86, -86, -86, -86, -86, -86, -86,
//                    -86, -86, -86, -86, -86, -86, -86, -86 };
//
//            byte[] arrayOfByte5 = {
//                    -35, -35, -35, -35, -35, -35, -35, -35,
//                    -35, -35, -35, -35, -35, -35, -35, -35,
//                    -35, -35, -35, -35, -35, -35, -35, -35,
//                    -35, -35, -35, -35, -35, -35, -35, -35,
//                    -35, -35, -35, -35, -35, -35, -35, -35,
//                    -35, -35, -35, -35, -35, -35, -35, -35,
//                    -35, -35 };
//
//            str1 = "0X56BE34521D144C88DBB8C733F0E8B3F6";
//            byte[] arrayOfByte6 = {
//                    86, -66, 52, 82, 29, 20, 76, -120,
//                    -37, -72, -57, 51, -16, -24, -77, -10 };
//
//            localHMAC_MD5 = new HMAC_MD5(arrayOfByte4);
//            localHMAC_MD5.addData(arrayOfByte5);
//            arrayOfByte1 = localHMAC_MD5.sign();
//            System.out.println("Calculated hash 0X" + localHMAC_MD5);
//            System.out.println("  Expected hash " + str1);
//            System.out.println("Signature Verification: " + localHMAC_MD5.verify(arrayOfByte6));
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        }
    }

    public byte[] sign()
    {
        this.md5.reset();

        this.digest = this.innerMD5.digest();

        this.md5.reset();
        this.md5.update(this.kOpad);
        this.md5.update(this.digest);
        this.digest = this.md5.digest();

        return this.digest;
    }

    public String toString()
    {
        if (this.digest == null) {
            sign();
        }
        StringBuffer localStringBuffer = new StringBuffer();
        String str = "0123456789ABCDEF";
        byte[] arrayOfByte = this.digest;

        for (int i = 0; i < 16; i++)
        {
            int j = arrayOfByte[i] >>> 4 & 0xF;
            localStringBuffer.append("0123456789ABCDEF"
                    .charAt(j));
            j = arrayOfByte[i] & 0xF;
            localStringBuffer.append("0123456789ABCDEF"
                    .charAt(j));
        }

        return localStringBuffer.toString();
    }

    public boolean verify(byte[] paramArrayOfByte)
    {
        if (this.digest == null) {
            sign();
        }
        int i = paramArrayOfByte.length;
        int j = this.digest.length;

        if (i != j) {
            return false;
        }
        for (int k = 0; k < i; k++) {
            if (paramArrayOfByte[k] != this.digest[k])
                return false;
        }
        return true;
    }
}
