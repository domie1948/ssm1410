package com.design.base.utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * 加载属性文件
 *
 * @author 刘文铭
 * @see PropertiesConfigHelper
 * @since 1.0
 */
public final class PropertiesConfigHelper {
    private PropertiesConfigHelper(){}
    
    //使用日志输出
    private final static Logger logger = Logger.getLogger(PropertiesConfigHelper.class);
    //设置后缀名
    private final static String EXT = ".properties";
    //实例化Properties对象
    private static Properties configProperties = null;
    
    /**
     * 加载properties文件
     *
     * @param filepaths properties文件路径
     */
    public static void load(String... filepaths) {
        logger.debug("开始读取properties文件 开始时间" + System.currentTimeMillis());
        if(configProperties==null){
            configProperties = new Properties();
        }
        //配置文件路径
        String configFilePath;
        InputStream inputStream = null;
        //遍历filepathke数组
        for (int i = 0; i < filepaths.length; i++) {
            configFilePath = filepaths[i];
            //读取属性文件后缀名为.properties
            try {
                if (configFilePath.toLowerCase().endsWith(EXT)) {
                    inputStream = PropertiesConfigHelper.class.getClassLoader().getResourceAsStream(configFilePath);
                    configProperties.load(inputStream);
                } else {
                    throw new RuntimeException("无法读取该文件: " + configFilePath);
                }
                logger.debug("文件 \"" + configFilePath + "\" 读取 成功! 时间为:" + System.currentTimeMillis());
            } catch (Exception e) {
                logger.debug("文件 \"" + configFilePath + "\" 读取 失败, 失败异常信息:\\n" + e.getMessage());
                throw new RuntimeException("文件 \"" + configFilePath + "\" 加载失败", e);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        logger.debug("所有配置文件读取完毕,当关闭文件FileInputStream时，异常信息 :\\n" + e.getMessage());
                    }
                }
            }
            
        }
        
    }
    
    /**
     * 获取 int 类型的配置属性的value
     *
     * @param key          配置属性的key
     * @param defaultValue 默认值
     * @return 对应的配置属性value，如果配置属性的value不为short类型或不存在对应的配置属性，则返回 defaultValue
     */
    public static Short getShortValue(String key, Short defaultValue) {
        try {
            return getShortValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    /**
     * 获取 short 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @return 对应的配置属性value
     */
    public static Short getShortValue(String key) {
        return Short.parseShort(configProperties.getProperty(key));
    }
    
    /**
     * 获取 int 类型的配置属性的value
     *
     * @param key          配置属性的key
     * @param defaultValue 默认值
     * @return 对应的配置属性value，如果配置属性的value不为int类型或不存在对应的配置属性，则返回 defaultValue
     */
    public static int getIntegerValue(String key, Integer defaultValue) {
        try {
            return getIntegerValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    /**
     * 获取 int 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @return 对应的配置属性value
     */
    public static Integer getIntegerValue(String key) {
        return Integer.parseInt(configProperties.getProperty(key));
    }
    
    
    /**
     * 获取 float 类型的配置属性的value
     *
     * @param key          配置属性的key
     * @param defaultValue 默认值
     * @return 对应的配置属性value，如果配置属性的value不为float类型或不存在对应的配置属性，则返回 defaultValue
     */
    public static Float getFloatValue(String key, float defaultValue) {
        try {
            return getFloatValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    /**
     * 获取 float 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @return 对应的配置属性value
     */
    public static Float getFloatValue(String key) {
        return Float.parseFloat(configProperties.getProperty(key));
    }
    
    /**
     * 获取 double 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @param defaultValue 默认值
     * @return 对应的配置属性value，如果配置属性的value不为double类型或不存在对应的配置属性，则返回 defaultValue
     */
    public static Double getDoubleValue(String key, double defaultValue) {
        try {
            return getDoubleValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    /**
     * 获取 Double 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @return 对应的配置属性value
     */
    public static Double getDoubleValue(String key) {
        return Double.parseDouble(configProperties.getProperty(key));
    }
    
    
    
    /**
     * 获取 long 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @param defaultValue 默认值
     * @return 对应的配置属性value，如果配置属性的value不为long类型或不存在对应的配置属性，则返回 defaultValue
     */
    public static Long getLongValue(String key, long defaultValue) {
        try {
            return getLongValue(key);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    /**
     * 获取 Long 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @return 对应的配置属性value
     */
    public static Long getLongValue(String key) {
        return Long.parseLong(configProperties.getProperty(key));
    }
    
    
    
    /**
     * 获取 String 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @param defaultValue 默认值
     * @return 对应的配置属性value，如果配置属性的value为""或不存在对应的配置属性，则返回 defaultValue
     */
    public static String getStringValue(String key, String defaultValue) {
        String value = configProperties.getProperty(key);
        return (value == null) ? defaultValue : getStringValue(key);
    }
    /**
     * 获取 String 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @return 对应的配置属性value
     */
    public static String getStringValue(String key) {
        return configProperties.getProperty(key);
    }
    
    /**
     * 获取 boolean 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @param defaultValue 默认值
     * @return 如果在配置文件中没有定义此属性，则返回 defaultValue;
     *         如果 value 为y、on、yes 、true 或非 0 数值(均不区分大小写) 则返回 true, 否则返回 false
     */
    public static boolean getBooleanValue(String key, Boolean defaultValue) {
        String value = configProperties.getProperty(key);
        return (value == null) ? defaultValue : getBooleanValue(key);
    }
    /**
     * 获取 boolean 类型的配置属性的value
     *
     * @param key 配置属性的key
     * @return 对应的配置属性value
     */
    public static Boolean getBooleanValue(String key) {
        String value = configProperties.getProperty(key);
        return ("y".equalsIgnoreCase(value)) || ("on".equalsIgnoreCase(value)) || ("yes".equalsIgnoreCase(value))
                || ("true".equalsIgnoreCase(value)) || (getIntegerValue(key, 0) != 0);
    }
    /**
     * 加载properties文件
     *
     * @param filepath properties文件路径
     */
    public static void write(String key, String value,String filepath){
        if(configProperties==null){
            configProperties = new Properties();
        }
        
        OutputStream outputStream = null;
        try{
            //String base = PropertiesConfigHelper.class.getResource("/"+filepath).getPath();
            java.net.URL url = PropertiesConfigHelper.class.getResource("/"+filepath);
            File file = new File(url.toURI());
            //判断文件是否存在
            if(!file.exists()){
                file.createNewFile();
            }
            
            load(filepath);//加载文件
            
            outputStream = new FileOutputStream(file);
            
            configProperties.setProperty(key,value);
            
            configProperties.store(outputStream,"");
            
            
        }catch (Exception e){
            throw new RuntimeException("文件 \"" + filepath + "\" 加载失败", e);
        }finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    logger.debug("所有配置文件修改完毕,FileOutputStream异常信息 :\\n" + e.getMessage());
                }
            }
        }
        
    }
    
    
    
}
