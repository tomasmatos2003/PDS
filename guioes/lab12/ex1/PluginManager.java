package lab12.ex1;

abstract class PluginManager {
    public static IPlugin load(String name) throws Exception {
        IPlugin p = null;
        p = (IPlugin) Class.forName(name).getDeclaredConstructor().newInstance();
       
        return p;
    }
}
