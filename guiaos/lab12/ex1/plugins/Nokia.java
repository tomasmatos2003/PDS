package lab12.ex1.plugins;

import lab12.ex1.IPlugin;

public class Nokia implements IPlugin {
    private String name;
    private String version;
    private String camara;

    public Nokia(String name, String version, String camara) {
        this.name = name;
        this.version = version;
        this.camara = camara;
    }

    public Nokia() {
    }
    
    public void setCamara(String camara) {
        this.camara = camara;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    public String getCamara() {
        return camara;
    }
    public String getName() {
        return name;
    }
    public String getVersion() {
        return version;
    }

    @Override
    public void fazQualQuerCoisa() {
        System.out.println("coisas de Nokia");
    }
    @Override
    public String toString() {
        return "Nokia [name=" + name + ", version=" + version + ", camara=" + camara + "]";
    }
    
}
