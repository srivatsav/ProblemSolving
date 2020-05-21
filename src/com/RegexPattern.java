  package com;

  import java.util.ArrayList;
  import java.util.List;
  import java.util.regex.Matcher;
  import java.util.regex.Pattern;

  public class RegexPattern {

    public static void main(String[] args) {

      String str =
          "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:bsvc=\"urn:com.workday/bsvc\">\n"
              + "   <soapenv:Header>\n"
              + "      <!--header-->\n"
              + "      <bsvc:Workday_Common_Header>\n"
              + "         <bsvc:Include_Reference_Descriptors_In_Response>true</bsvc:Include_Reference_Descriptors_In_Response>\n"
              + "      </bsvc:Workday_Common_Header>\n"
              + "   </soapenv:Header>\n"
              + "   <soapenv:Body>\n"
              + "      <bsvc:Get_Job_Postings_Request bsvc:version=\"v32.1\">\n"
              + "         <bsvc:Request_Criteria>\n"
              + "            <bsvc:Show_Only_Active_Job_Postings>true</bsvc:Show_Only_Active_Job_Postings>\n"
              + "         </bsvc:Request_Criteria>\n"
              + "         <bsvc:Response_Filter>\n"
              + "            <bsvc:Page>1</bsvc:Page>\n"
              + "<bsvc:Count>499</bsvc:Count>\n"
              + "         </bsvc:Response_Filter>\n"
              + "         <bsvc:Response_Group>\n"
              + "         </bsvc:Response_Group>\n"
              + "      </bsvc:Get_Job_Postings_Request>\n"
              + "   </soapenv:Body>\n"
              + "</soapenv:Envelope>\n";

      Pattern pattern =
          Pattern.compile("(.*:Page>)(\\d+)(</.*:Page>)(\\n?)(.*:Count>)(\\d+)(</.*:Count.*)", Pattern.DOTALL | Pattern.MULTILINE);
      Matcher matcher = pattern.matcher(str);
      if (matcher.find()) {

        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
        System.out.println(matcher.group(3));
        System.out.println(matcher.group(4));
        System.out.println(matcher.group(5));
        System.out.println(matcher.group(6));
        System.out.println(matcher.group(7));

      }
    }
  }
