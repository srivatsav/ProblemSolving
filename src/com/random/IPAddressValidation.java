package com.random;

public class IPAddressValidation {
  public static void main(String[] args) {

    String ipAddress = "172.16.254.01";
    // String ipAddress = "2001:0db8:85a3:0:0:8A2E:0370:7334";

    if (ipAddress.indexOf('.') < 0 && ipAddress.indexOf(':') < 0)
      System.out.println("Not a valid IP Address");

    String ipv4Pattern = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
    String ipv6Pattern = "\\A((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?) ::((?:[0-9A-Fa-f]{1,4}:)*)(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z";

    if (ipAddress.matches(ipv4Pattern))
      System.out.println("IPv4 Address");

    if (ipAddress.matches(ipv6Pattern))
      System.out.println("IPv6 Address");

    System.out.println("INVALID IP Address");
  }
}