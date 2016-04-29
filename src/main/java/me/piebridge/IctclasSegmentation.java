package me.piebridge;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Created by Liu DongMiao &lt;liudongmiao@gmail.com&gt; on 2016/04/29.
 *
 * @author thom
 */
public class IctclasSegmentation implements Segmentation {

    private final NLPIR nlpir;

    public IctclasSegmentation() {
        nlpir = NLPIR.INSTANCE;
        nlpir.NLPIR_Init("", 1, "");
    }

    @Override
    public void addUserWord(String userWord) {
        nlpir.NLPIR_AddUserWord(userWord + " " + USER_DEFINE);
    }

    @Override
    public String parse(String paragraph, boolean showNature) {
        return nlpir.NLPIR_ParagraphProcess(paragraph, showNature ? 1 : 0);
    }

    @Override
    protected void finalize() throws Throwable {
        nlpir.NLPIR_Exit();
        super.finalize();
    }

    private interface NLPIR extends Library {

        NLPIR INSTANCE = (NLPIR) Native.loadLibrary("NLPIR", NLPIR.class);

        /**
         * 组件初始化
         *
         * @param sDataPath    Data文件夹的父目录，如果为空字符串（即：""），那么，程序自动从项目的根目录中寻找
         * @param encoding     编码格式，具体的编码对照如下： 0：GBK；1：UTF8；2：BIG5；3：GBK，里面包含繁体字
         * @param sLicenceCode 授权码，为空字符串（即：""）就可以了
         * @return true：初始化成功；false：初始化失败
         */
        boolean NLPIR_Init(String sDataPath, int encoding, String sLicenceCode);

        /**
         * 分词
         *
         * @param sParagraph 文本内容
         * @param bPOSTagged 1：显示词性；0：不显示词性
         * @return 分词结果
         */
        String NLPIR_ParagraphProcess(String sParagraph, int bPOSTagged);

        /**
         * 添加用户自定义词
         *
         * @param userWord 用户词 格式：单词+空格+词性，例如：你好 v
         * @return 1：内存中不存在；2：内存中已存在 备注：保存到内存中，下次初始化后失效，需要用save保存到文件中
         */
        int NLPIR_AddUserWord(String userWord);

        /**
         * 退出，释放资源
         *
         * @return 成功或失败
         */
        boolean NLPIR_Exit();
    }

}
