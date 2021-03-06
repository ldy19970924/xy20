package cn.xy.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SendSMS {

	public static String sendCode(String phone,int code) throws ServerException, ClientException {
		   DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GCvT91Avu9ZgguoF6rA", "pP0zjZjgxYUisU5ANZtPIJBDa0MHBe");
	       IAcsClient client = new DefaultAcsClient(profile);
	       DefaultProfile.addEndpoint("cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
	       //创建短信发送服务的请求对象
           SendSmsRequest request = new SendSmsRequest();
           request.setMethod(MethodType.POST);
           request.setVersion("2017-05-25");
           request.setPhoneNumbers(phone);
           request.setSignName("新教育");
           request.setTemplateCode("SMS_197870399");//${code}
           request.setTemplateParam("{\"code\":"+code+"}");
           //创建短信服务的响应
           SendSmsResponse response = client.getAcsResponse(request);
           if(response.getCode()!= null && response.getCode().equals("OK")) {
        	   return "发送成功!";
           }else {
        	   // getMessage() :返回造成发送失败的文本错误信息
        	   return response.getMessage();
           }	       
	}
	     

}
