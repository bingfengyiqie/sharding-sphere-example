import java.net.InetAddress;
import java.net.UnknownHostException;

import io.shardingjdbc.core.keygen.DefaultKeyGenerator;

public class IPKeyGenerator {
    public static void main(String[] args) {
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
        } catch (final UnknownHostException e) {
            throw new IllegalStateException("Cannot get LocalHost InetAddress, please check your network!");
        }
        byte[] ipAddressByteArray = address.getAddress();

        long workerId = ((ipAddressByteArray[ipAddressByteArray.length - 2] & 0B11) << Byte.SIZE)
                + (ipAddressByteArray[ipAddressByteArray.length - 1] & 0xff);
        DefaultKeyGenerator.setWorkerId(workerId);
        print(new DefaultKeyGenerator().generateKey());
        print(new DefaultKeyGenerator().generateKey());
        print(new DefaultKeyGenerator().generateKey());
        
        print("---");
        print("address:"+address);
        print("---");
        print(workerId);
        print(0 << 10);
        print(1 << 10);// 1*2^10
        print(2 << 10);
        print(3 << 10);
        print(0B11);
        print(011);
        print(11);
        print(0x11);
        print("---");
        print(ipAddressByteArray[ipAddressByteArray.length - 2]);// 取出IP的倒数第2位
        print(ipAddressByteArray[ipAddressByteArray.length - 2] & 0B11);
        print((ipAddressByteArray[ipAddressByteArray.length - 2] & 0B11) << Byte.SIZE);// 这两个二进制数是放在第9、第10位的、因此 << 8 位  
        print(ipAddressByteArray[ipAddressByteArray.length - 1]);
        print(ipAddressByteArray[ipAddressByteArray.length - 1] & 0xff); // 取出IP的倒数第一位
        print(Integer.toBinaryString(-73));

    }

    /**
     * 
     */
    private static void print(Object object) {
        System.out.println(object);
    }
}
