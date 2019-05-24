package com.qrCode;

import com.other.RandNum;
import com.swetake.util.Qrcode;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreateQRCode {

    //计算二维码图片的高宽比
    // API文档规定计算图片宽高的方式 ，v是本次测试的版本号
    private static final int version = 7;//设置二维码的版本号
    private static final int width = 67 + 12 * (version - 1);//设置二维码的宽度
    private static final int height = 67 + 12 * (version - 1);//设置二维码的高度

    private static final String format = "jpg";//设置二维码的格式

    private static final String url = "G://Test/Q_ITOffer/web/images/code/qrcode.jpg";
    private static final File file = new File(url);//设置二维码的保存地址

    public void code() throws IOException {

        Qrcode x = new Qrcode();
        /**
         * 纠错等级分为
         * level L : 最大 7% 的错误能够被纠正；
         * level M : 最大 15% 的错误能够被纠正；
         * level Q : 最大 25% 的错误能够被纠正；
         * level H : 最大 30% 的错误能够被纠正；
         */
        x.setQrcodeErrorCorrect('L');
        x.setQrcodeEncodeMode('B');//注意版本信息 N代表数字 、A代表 a-z,A-Z、B代表其他字符)
        x.setQrcodeVersion(version);//版本号  1-40

        String qrData = new RandNum().getNum().toString();//内容信息

        //缓冲区
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        //绘图
        Graphics2D gs = bufferedImage.createGraphics();

        gs.setBackground(Color.WHITE);//设置背景颜色
        gs.setColor(Color.BLACK);//设置颜色
        gs.clearRect(0, 0, width, height);//清除画板内容

        //偏移量
        int pixoff = 2;


        /**
         * 容易踩坑的地方
         * 1.注意for循环里面的i，j的顺序，
         *   s[j][i]二维数组的j，i的顺序要与这个方法中的 gs.fillRect(j*3+pixoff,i*3+pixoff, 3, 3);
         *   顺序匹配，否则会出现解析图片是一串数字
         * 2.注意此判断if (d.length > 0 && d.length < 120)
         *   是否会引起字符串长度大于120导致生成代码不执行，二维码空白
         *   根据自己的字符串大小来设置此配置
         */

        //往画板中填充内容
        byte[] d = qrData.getBytes("utf-8");//汉字转格式需要抛出异常
        if (d.length > 0 && d.length < 120) {
            boolean[][] s = x.calQrcode(d);

            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j][i]) {
                        gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                    }
                }
            }
        }

        gs.dispose();//结束绘画
        bufferedImage.flush();//结束图片流的生成

        //二维码输出并保存
        ImageIO.write(bufferedImage, format, file);
    }
}
