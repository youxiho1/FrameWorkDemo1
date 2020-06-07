package app;

import java.util.WeakHashMap;

//单例模式
public class Configurator {
    private static final WeakHashMap<String, Object> CONFIGS = new WeakHashMap<>();

    //下面开始构建一个线程安全的单例模式
    //start**********************
    private Configurator() {
        CONFIGS.put(ConfigType.CONFIG_READY.name(), false);         //现在还没有Ready
        //枚举类的name()是？
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }
    //end****************************

    final WeakHashMap<String, Object> getConfigs() {
        return CONFIGS;
    }

    public final void configure() {
        CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) CONFIGS.get(ConfigType.CONFIG_READY.name());
        if(!isReady) {
            throw new RuntimeException("Configuration not ready, please call configure()");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) CONFIGS.get(key);
    }
}
