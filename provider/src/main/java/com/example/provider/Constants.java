package com.example.provider;



import java.util.HashMap;
import java.util.Map;

/**
 * 系统通用常量
 *
 * @author fanlin.zeng
 * @date 2017/11/10 11:20
 */
public final class Constants {

    /**
     * 当前用户
     */
    public static final String CURRENT_USER = "CURRENT_USER";
    /**
     * 当前用户
     */
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    /**
     * mapper方法中查询语句开头格式，必须以select开头，才会切换数据源
     */
    public static final String MAPPER_METHOD_STARTSWITH_SELECT = "select";

    /**
     * 缓存键值
     */
    public static final Map<Class<?>, String> CACHE_KEY_MAP = new HashMap<>(5);

    /**
     * 缓存命名空间前缀
     */
    public static final String CACHE_NAMESPACE_PREFIX = "jww:";

    /**
     * 缓存命名空间枚举
     */
    public enum CacheNamespaceEnum {
        /**
         * 数据缓存
         */
        DATA(CACHE_NAMESPACE_PREFIX + "data:", "数据缓存"),
        LOCK(CACHE_NAMESPACE_PREFIX + "lock:", "分布式锁"),
        TOKEN(CACHE_NAMESPACE_PREFIX + "token:", "票据"),
        CAPTCHA(CACHE_NAMESPACE_PREFIX + "captcha:", "验证码"),
        SHIRO(CACHE_NAMESPACE_PREFIX + "shiro:", "shiro"),
        IP(CACHE_NAMESPACE_PREFIX + "ip:", "ip归属地");

        /**
         * 值
         */
        private String value;
        /**
         * 描述
         */
        private String message;

        CacheNamespaceEnum(String value, String message) {
            this.value = value;
            this.message = message;
        }

        public String value() {
            return this.value;
        }

        public String getMessage() {
            return this.message;
        }
    }



    /**
     * 多数据源枚举
     */
    public enum DataSourceEnum {
        // 主库
        MASTER("masterDataSource", true),
        // 从库
        SLAVE("slaveDataSource", false);

        /**
         * 数据源名称
         */
        private String name;
        /**
         * 是否是默认数据源
         */
        private boolean master;

        DataSourceEnum(String name, boolean master) {
            this.name = name;
            this.master = master;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isMaster() {
            return master;
        }

        public void setMaster(boolean master) {
            this.master = master;
        }

        public String getDefault() {
            String defaultDataSource = "";
            for (DataSourceEnum dataSourceEnum : DataSourceEnum.values()) {
                if (!"".equals(defaultDataSource)) {
                    break;
                }
                if (dataSourceEnum.master) {
                    defaultDataSource = dataSourceEnum.getName();
                }
            }
            return defaultDataSource;
        }

    }

    /**
     * 日志操作类型枚举
     */
    public enum LogOptEnum {
        //查询
        QUERY(0, "查询"),
        ADD(1, "新增"),
        MODIFY(2, "修改"),
        DELETE(3, "删除"),
        LOGIN(4, "登录"),
        UNKNOW(9, "未知");
        private final int value;
        private final String message;

        LogOptEnum(int value, String message) {
            this.value = value;
            this.message = message;
        }

        public int value() {
            return this.value;
        }

        public String getMessage() {
            return this.message;
        }

    }

}
