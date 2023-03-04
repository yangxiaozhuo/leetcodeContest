import java.lang.reflect.Proxy;

/**
 * @author yangxiaozhuo
 * @date 2023/02/21
 */
public class Main {
    public static void main(String[] args) {
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsService o = (SmsService)Proxy.newProxyInstance(smsService.getClass().getClassLoader(), smsService.getClass().getInterfaces(), new DebugInvocationHandler(smsService));
        o.send("aaa");
    }

    public interface SmsService {
        String send(String message);
    }

    static public class SmsServiceImpl implements SmsService {
        @Override
        public String send(String message) {
            System.out.println("send message:" + message);
            return message;
        }
    }
}